package br.com.uniamerica.estacionamento.service;

import br.com.uniamerica.estacionamento.entity.Modelo;
import br.com.uniamerica.estacionamento.repository.ModeloRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class ModeloService {
    final ModeloRepository modeloRepository;

    public ModeloService(ModeloRepository modeloRepository) {
        this.modeloRepository = modeloRepository;
    }

    public void nomeValidation(final Modelo modelo) {
        Assert.isTrue(modelo.getNome().length() > 0,
                "O nome da marca não pode ser nulo!");
        Assert.isTrue(modelo.getNome().length() < 50,
                "O nome da marca deve ter menos que 50 carácteres");
        Assert.isTrue(!modelo.equals(null), "O campo de marca não pode ser nulo");

        this.modeloRepository.save(modelo);
    }

}
