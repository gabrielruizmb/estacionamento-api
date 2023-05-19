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

        Assert.isTrue(marca.getNome().length() > 0 && marca.getNome().length() < 50,
                "O nome da marca deve conter entre 1 e 50 caractéres");

        final Marca databaseMarca = this.marcaRepository.findByNome(marca.getNome());
        Assert.isTrue(databaseMarca == null || !databaseMarca.getNome().equals(marca.getNome()),
                "Esta marca já está registrada");

        this.marcaRepository.save(marca);
    }
    @Transactional
    public void marcaUpdateValidation(final Long id, final Marca marca) {

        final Marca databaseMarca = this.marcaRepository.findById(id).orElse(null);
        if (databaseMarca == null || !databaseMarca.getId().equals(marca.getId())) {
            throw new RuntimeException("Registro não encontrado");
        }

        marca.setCadastro(databaseMarca.getCadastro());

        this.marcaRepository.save(marca);
    }

    @Transactional
    public void deleteMarcaValidation(final Long id) {
        Marca databaseMarca = this.marcaRepository.findById(id).orElse(null);

        if (databaseMarca == null || !databaseMarca.getId().equals(id)) {
            throw new RuntimeException("Registro não encontrado");
        }

        this.marcaRepository.deleteById(id);
    }
}
