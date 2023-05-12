package br.com.uniamerica.estacionamento.service;

import br.com.uniamerica.estacionamento.entity.Modelo;
import br.com.uniamerica.estacionamento.repository.ModeloRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class ModeloService {
    final ModeloRepository modeloRepository;

    public ModeloService(ModeloRepository modeloRepository) {
        this.modeloRepository = modeloRepository;
    }

    @Transactional
    public void modeloValidation(final Modelo modelo) {
        Assert.isTrue(modelo.getNome().length() > 0,
                "O nome da marca não pode ser nulo!");
        Assert.isTrue(modelo.getNome().length() < 50,
                "O nome da marca deve ter menos que 50 carácteres");
        Assert.isTrue(modelo.getMarca() != null, "O campo de marca não pode ser nulo");

        this.modeloRepository.save(modelo);
    }

    public void modeloUpdateValidation(final Long id, final Modelo modelo) {
        final Modelo databaseModelo = this.modeloRepository.findById(id).orElse(null);
        if (databaseModelo == null || !databaseModelo.getId().equals(modelo.getId())) {
            throw new RuntimeException("Registro não encontrado");
        }
        modeloValidation(modelo);
    }

}
