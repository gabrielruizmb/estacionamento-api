package br.com.uniamerica.estacionamento.service;

import br.com.uniamerica.estacionamento.entity.Marca;
import br.com.uniamerica.estacionamento.repository.MarcaRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class MarcaService {

    final MarcaRepository marcaRepository;

    public MarcaService(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    public void createMarca(final Marca marca) {

        Assert.isTrue(!marca.getNome().equals(""), "Marca não pode ser nulo!");
        this.marcaRepository.save(marca);
    }
}
