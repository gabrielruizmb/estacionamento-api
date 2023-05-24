package br.com.uniamerica.estacionamento.service;

import br.com.uniamerica.estacionamento.entity.Veiculo;
import br.com.uniamerica.estacionamento.repository.VeiculoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.time.Year;

@Service
public class VeiculoService {
    final VeiculoRepository veiculoRepository;

    public VeiculoService(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    @Transactional(rollbackFor = Exception.class)
    public void createVeiculoValidation(final Veiculo veiculo) {
        // Valida se a placa a ser inserida não existe nos registros
        final Veiculo databaseVeiculo = this.veiculoRepository.findByPlaca(veiculo.getPlaca());
        Assert.isTrue(databaseVeiculo == null,
                "Já existe um veículo com esta placa nos registros");

        // Validação do ano do veículo
        final int validVehicleYear = Year.now().getValue() + 1;
        Assert.isTrue(veiculo.getAno() > 1886 && veiculo.getAno() <= validVehicleYear,
                "O ano do veiculo deve ser entre 1886 e " + validVehicleYear);

        this.veiculoRepository.save(veiculo);
    }
    @Transactional(rollbackFor = Exception.class)
    public void updateVeiculoValidation(final Long id, final Veiculo veiculo) {

        // Valida se o id do veiculo a ser atualizado existe nos registros
        Veiculo databaseVeiculo = this.veiculoRepository.findById(id).orElse(null);
        if (databaseVeiculo == null || !databaseVeiculo.getId().equals(veiculo.getId())) {
            throw new RuntimeException("Registro não encontrado");
        }

        // Valida se a placa a ser atualiza não existe nos registros
        databaseVeiculo = this.veiculoRepository.findByPlaca(veiculo.getPlaca());
        if (databaseVeiculo != null) {
            Assert.isTrue(veiculo.getId().equals(databaseVeiculo.getId()),
                    "Já existe um veículo com esta placa nos registros");
        }

        // Validação do ano do veículo
        final int validVehicleYear = Year.now().getValue() + 1;
        Assert.isTrue(veiculo.getAno() > 1886 && veiculo.getAno() <= validVehicleYear,
                "O ano do veiculo deve ser entre 1886 e " + validVehicleYear);
        this.veiculoRepository.save(veiculo);
    }
    @Transactional(rollbackFor = Exception.class)
    public void deleteVeiculoValidation(final Long id) {
        Veiculo databaseVeiculo = this.veiculoRepository.findById(id).orElse(null);

        if (databaseVeiculo == null || !databaseVeiculo.getId().equals(id)) {
            throw new RuntimeException("Registro não encontrado");
        }

        this.veiculoRepository.deleteById(id);
    }
}
