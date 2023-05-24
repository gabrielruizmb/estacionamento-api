package br.com.uniamerica.estacionamento.controller;

import br.com.uniamerica.estacionamento.entity.Configuracao;
import br.com.uniamerica.estacionamento.repository.ConfiguracaoRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/configuracao")
public class ConfiguracaoController {
    final ConfiguracaoRepository configuracaoRepository;

    public ConfiguracaoController(ConfiguracaoRepository configuracaoRepository) {
        this.configuracaoRepository = configuracaoRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findByIdPath(@PathVariable("id") final Long id) {
        final Configuracao configuracao = this.configuracaoRepository.findById(id).orElse(null);
        return configuracao == null ?
                ResponseEntity.badRequest().body("Registro não encontrado") :
                ResponseEntity.ok(configuracao);
    }

    @PostMapping
    public ResponseEntity<?> createConfiguracao(@RequestBody final Configuracao configuracao) {
        try {
            this.configuracaoRepository.save(configuracao);
            return ResponseEntity.ok("Registro de configuração criado com sucesso");
        }
        catch (Exception error) {
            return ResponseEntity.internalServerError().body("Error: " + error.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> updateConfiguracao(@RequestParam("id") final Long id,
                                                @RequestBody final Configuracao configuracao) {
        try {
            this.configuracaoRepository.save(configuracao);
            return ResponseEntity.ok("Registro de configuração atualizado com sucesso");
        }
        catch (DataIntegrityViolationException error) {
            return ResponseEntity.internalServerError().body("Error: " + error.getCause().getCause().getMessage());
        }
        catch (Exception error) {
            return ResponseEntity.internalServerError().body("Error: " + error.getMessage());
        }
    }
}
