package br.com.uniamerica.estacionamento.controller;

import br.com.uniamerica.estacionamento.entity.Veiculo;
import br.com.uniamerica.estacionamento.repository.VeiculoRepository;
import br.com.uniamerica.estacionamento.service.VeiculoService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/veiculo")
public class VeiculoController {
    final VeiculoRepository veiculoRepository;
    final VeiculoService veiculoService;
    public VeiculoController(VeiculoRepository veiculoRepository, VeiculoService veiculoService) {
        this.veiculoRepository = veiculoRepository;
        this.veiculoService = veiculoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findByIdPath(@PathVariable("id") final Long id) {
        final Veiculo databaseVeiculo = this.veiculoRepository.findById(id).orElse(null);
        return databaseVeiculo == null ?
                ResponseEntity.badRequest().body("Registro não encontrado") :
                ResponseEntity.ok(databaseVeiculo);
    }
    @GetMapping("/lista")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(this.veiculoRepository.findAll());
    }
    @GetMapping("/ativos")
    public ResponseEntity<?> findByAtivos() {
        return ResponseEntity.ok(this.veiculoRepository.findByAtivo(true));
    }

    @PostMapping
    public ResponseEntity<?> createVeiculo(@RequestBody @Validated final Veiculo veiculo) {
        try {
            this.veiculoService.createVeiculoValidation(veiculo);
            return ResponseEntity.ok().body("Veiculo registrado com sucesso");
        }
        catch (Exception error) {
            return ResponseEntity.internalServerError().body("Error: " + error.getMessage());
        }
    }

}
