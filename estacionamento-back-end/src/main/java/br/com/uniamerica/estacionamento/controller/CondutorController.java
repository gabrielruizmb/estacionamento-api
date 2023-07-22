package br.com.uniamerica.estacionamento.controller;

import br.com.uniamerica.estacionamento.entity.Condutor;
import br.com.uniamerica.estacionamento.repository.CondutorRepository;
import br.com.uniamerica.estacionamento.service.CondutorService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/condutor")
public class CondutorController {
    final CondutorRepository condutorRepository;
    final CondutorService condutorService;

    public CondutorController(CondutorRepository condutorRepository, CondutorService condutorService) {
        this.condutorRepository = condutorRepository;
        this.condutorService = condutorService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findByIdPath(@PathVariable("id") final Long id) {
        final Condutor databaseCondutor = this.condutorRepository.findById(id).orElse(null);
        return databaseCondutor == null ?
                ResponseEntity.badRequest().body("Nenhum registro encontrado") :
                ResponseEntity.ok(databaseCondutor);
    }

    @GetMapping("/lista")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(this.condutorRepository.findAll());
    }

    @GetMapping("/ativos")
    public ResponseEntity<?> findByAtivo() {
        return ResponseEntity.ok(this.condutorRepository.findByAtivo(true));
    }

    @PostMapping
    public ResponseEntity<?> createCondutor(@RequestBody @Validated final Condutor condutor) {
        try {
            this.condutorService.createCondutorValidation(condutor);
            return ResponseEntity.ok("Condutor registrado com sucesso");
        }
        catch (Exception error) {
            return ResponseEntity.internalServerError().body("Error: " + error.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> updateCondutor(@RequestParam("id") final Long id, @RequestBody @Validated final Condutor condutor) {
        try {
            this.condutorService.updateCondutorValidation(id, condutor);
            return ResponseEntity.ok("Registro de condutor atualizado com sucesso");
        }
        catch (DataIntegrityViolationException error) {
            return ResponseEntity.internalServerError().body("Error: " + error.getCause().getCause().getMessage());
        }
        catch (Exception error) {
            return ResponseEntity.internalServerError().body("Error: " + error.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCondutor(@PathVariable("id") final Long id) {
        try {
            this.condutorService.deleteCondutorValidation(id);
            return ResponseEntity.ok("Registro de condutor deletado com sucesso");
        }
        catch (RuntimeException error) {
            return ResponseEntity.internalServerError().body("Error: " + error.getMessage());
        }
    }
}
