package br.com.uniamerica.estacionamento.controller;

import br.com.uniamerica.estacionamento.entity.Movimentacao;
import br.com.uniamerica.estacionamento.repository.MovimentacaoRepository;
import br.com.uniamerica.estacionamento.service.MovimentacaoService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/movimentacoes")
public class MovimentacaoController {
    final MovimentacaoRepository movimentacaoRepository;
    final MovimentacaoService movimentacaoService;

    public MovimentacaoController(MovimentacaoRepository movimentacaoRepository, MovimentacaoService movimentacaoService) {
        this.movimentacaoRepository = movimentacaoRepository;
        this.movimentacaoService = movimentacaoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findByIdPath(@PathVariable("id") final Long id) {
        Movimentacao movimentacao = this.movimentacaoRepository.findById(id).orElse(null);
        return movimentacao == null ?
                ResponseEntity.badRequest().body("Registro de movimentação não encontrado") :
                ResponseEntity.ok(movimentacao);
    }

    @GetMapping("/lista")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(this.movimentacaoRepository.findAll());
    }

//    @GetMapping("/abertas")
//    public ResponseEntity<?> findByAberta() {
//        return ResponseEntity.ok(this.movimentacaoRepository.findByAberta(null));
//    }

    @PostMapping
    public ResponseEntity<?> createMovimentacao(@RequestBody final Movimentacao movimentacao) {
        try {
            this.movimentacaoRepository.save(movimentacao);
            return ResponseEntity.ok("Movimentação registrada com sucesso");
        }
        catch (Exception error) {
            return ResponseEntity.internalServerError().body("Error: " + error.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> updateMovimentacao(@RequestParam("id") final Long id,
                                                @RequestBody final Movimentacao movimentacao) {
        try {
            this.movimentacaoService.updateMovimentacaoValidation(id, movimentacao);
            return ResponseEntity.ok("Movimentação atualizada com sucesso");
        }
        catch (DataIntegrityViolationException error) {
            return ResponseEntity.internalServerError().body("Error: " + error.getCause().getCause().getMessage());
        }
        catch (Exception error) {
            return ResponseEntity.internalServerError().body("Error: " + error.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMovimentacao(@PathVariable("id") final Long id) {
        try {
            this.movimentacaoService.deleteMovimentacaoValidation(id);
            return ResponseEntity.ok("Registro de movimentação deletado com sucesso");
        }
        catch (RuntimeException error) {
            return ResponseEntity.internalServerError().body("Error: " + error.getMessage());
        }
    }
}
