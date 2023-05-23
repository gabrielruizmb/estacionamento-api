package br.com.uniamerica.estacionamento.service;

import br.com.uniamerica.estacionamento.entity.Veiculo;
import br.com.uniamerica.estacionamento.repository.VeiculoRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.Year;

@Service
public class VeiculoService {
    final VeiculoRepository veiculoRepository;

    public VeiculoService(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    public void createVeiculoValidation(final Veiculo veiculo) {
        final int validVeichleYear = Year.now().getValue() + 1;
        Assert.isTrue(veiculo.getAno() > 1886 && veiculo.getAno() < validVeichleYear,
                "O ano do veiculo deve ser entre 1886 e " + validVeichleYear);
        this.veiculoRepository.save(veiculo);
    }
}
