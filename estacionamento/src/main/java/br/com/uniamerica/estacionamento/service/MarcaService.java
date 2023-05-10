package br.com.uniamerica.estacionamento.service;

import br.com.uniamerica.estacionamento.entity.Marca;
import br.com.uniamerica.estacionamento.repository.MarcaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class MarcaService {

    final MarcaRepository marcaRepository;

    public MarcaService(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    @Transactional
    public void marcaValidation(final Marca marca) {

        Assert.isTrue(marca.getNome().length() > 0,
                "O nome da marca não pode ser nulo!");
        Assert.isTrue(marca.getNome().length() < 50,
                "O nome da marca deve ter menos que 50 carácteres");

        this.marcaRepository.save(marca);
    }
}
