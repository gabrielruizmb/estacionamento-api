package br.com.uniamerica.estacionamento.controller;

import br.com.uniamerica.estacionamento.entity.Modelo;
import br.com.uniamerica.estacionamento.repository.ModeloRepository;
import br.com.uniamerica.estacionamento.service.ModeloService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/api/modelo")
public class ModeloController {
    final ModeloRepository modeloRepository;
    final ModeloService modeloService;

    public ModeloController(ModeloRepository modeloRepository, ModeloService modeloService) {
        this.modeloRepository = modeloRepository;
        this.modeloService = modeloService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> findByIdPath(@PathVariable("id") final Long id) {
        final Modelo modelo = this.modeloRepository.findById(id).orElse(null);
        return modelo == null ? ResponseEntity.badRequest().body("Nenhum valor encontrado") : ResponseEntity.ok(modelo);
    }
    @GetMapping("/lista")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(this.modeloRepository.findAll());
    }
    @GetMapping("/ativos")
    public ResponseEntity<?> findByAtivo() {
        return ResponseEntity.ok(this.modeloRepository.findByAtivo(true));
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody final Modelo modelo) {
        try {
            this.modeloService.modeloValidation(modelo);
            return ResponseEntity.ok("Modelo cadastrada com sucesso");
        }
        catch (Exception error) {
            return ResponseEntity.internalServerError().body("Error " + error.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> editar(@RequestParam("id") final Long id, @RequestBody final Modelo modelo) {
        try {
            this.modeloService.modeloUpdateValidation(id, modelo);
            return ResponseEntity.ok("Registro de marca atualizado com sucesso");
        }
        catch (DataIntegrityViolationException error) {
            return ResponseEntity.internalServerError().body("Error" + error.getCause().getCause().getMessage());
        }
        catch (RuntimeException error) {
            return ResponseEntity.internalServerError().body("Error" + error.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable("id") final Long id) {
        final Modelo databaseModelo = this.modeloRepository.findById(id).orElse(null);

        if (databaseModelo== null || !databaseModelo.getId().equals(id)) {
            throw new RuntimeException("Registro não encontrado");
        }

        this.modeloRepository.deleteById(id);
        return ResponseEntity.ok("Registro deletado com sucesso");
    }
}
