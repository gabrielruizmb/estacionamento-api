package br.com.uniamerica.estacionamento.controller;

import br.com.uniamerica.estacionamento.entity.Modelo;
import br.com.uniamerica.estacionamento.repository.ModeloRepository;
import br.com.uniamerica.estacionamento.service.ModeloService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
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
    public ResponseEntity<?> cadastrar(@RequestBody @Validated final Modelo modelo) {
        try {
            this.modeloService.modeloValidation(modelo);
            return ResponseEntity.ok("Modelo cadastrado com sucesso");
        }
        catch (Exception error) {
            return ResponseEntity.internalServerError().body("Error " + error.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> editar(@RequestParam("id") final Long id, @RequestBody @Validated final Modelo modelo) {
        try {
            this.modeloService.modeloUpdateValidation(id, modelo);
            return ResponseEntity.ok("Registro de modelo atualizado com sucesso");
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
        try {
            this.modeloService.deleteModeloValidation(id);
            return ResponseEntity.ok("Registro deletado com sucesso");
        }
        catch (RuntimeException error) {
            return ResponseEntity.internalServerError().body("Error: " + error.getMessage());
        }
    }
}
