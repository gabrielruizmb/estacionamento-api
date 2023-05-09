package br.com.uniamerica.estacionamento.controller;

import br.com.uniamerica.estacionamento.entity.Marca;
import br.com.uniamerica.estacionamento.repository.MarcaRepository;
import br.com.uniamerica.estacionamento.service.MarcaService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "api/marca")
public class MarcaController {
    final MarcaRepository marcaRepository;
    final MarcaService marcaService;

    public MarcaController(MarcaRepository marcaRepository, MarcaService marcaService) {
        this.marcaRepository = marcaRepository;
        this.marcaService = marcaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findByIdPath(@PathVariable("id") final Long id) {
        final Marca marca = this.marcaRepository.findById(id).orElse(null);
        return marca == null ? ResponseEntity.badRequest().body("Nenhum valor encontrado") : ResponseEntity.ok(marca);
    }
    @GetMapping("/lista")
    public ResponseEntity<?> listaCompleta() {
        return ResponseEntity.ok(this.marcaRepository.findAll());
    }
    @GetMapping("/ativos")
    public ResponseEntity<?> listaAtivos() {
        return ResponseEntity.ok(this.marcaRepository.findByAtivo(true));
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody final Marca marca) {
        try {
            marcaService.createMarca(marca);
            return ResponseEntity.ok("Marca cadastrada com sucesso");
        }
        catch (DataIntegrityViolationException error) {
            return ResponseEntity.internalServerError().body("Error " + error.getCause().getCause().getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> editar(@RequestParam("id") final Long id, @RequestBody final Marca marca) {
        try {
            final Marca marcaBanco = this.marcaRepository.findById(id).orElse(null);
            if (marcaBanco == null || !marcaBanco.getId().equals(marca.getId())) {
                throw new RuntimeException("Registro não encontrado");
            }

            this.marcaRepository.save(marca);
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
        final Marca marcaBanco = this.marcaRepository.findById(id).orElse(null);

        if (marcaBanco == null || !marcaBanco.getId().equals(id)) {
            throw new RuntimeException("Registro não encontrado");
        }

        this.marcaRepository.deleteById(id);
        return ResponseEntity.ok("Registro deletado com sucesso");
    }
}
