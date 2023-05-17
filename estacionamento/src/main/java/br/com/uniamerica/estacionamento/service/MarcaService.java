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

        Assert.isTrue(marca.getNome().length() > 0,
                "O nome da marca não pode ser nulo!");
        Assert.isTrue(marca.getNome().length() < 50,
                "O nome da marca deve ter menos que 50 carácteres");

        final Marca databaseMarcaUpdate = this.marcaRepository.findByNome(marca.getNome());
        Assert.isTrue(databaseMarcaUpdate == null || !databaseMarca.getNome().equals(marca.getNome()),
                "Esta marca já está registrada");

        // Define a data de cadastro do registro atualizado para a data de cadastro do registro do banco de dados.
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
