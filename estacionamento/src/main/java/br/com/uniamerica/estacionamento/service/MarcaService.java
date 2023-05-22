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

        // Valida se o nome da marca a ser inserida não existe nos registros
        final Marca databaseMarca = this.marcaRepository.findByNome(marca.getNome());
        Assert.isTrue(databaseMarca == null,
                "Esta marca já está registrada");

        this.marcaRepository.save(marca);
    }
    @Transactional
    public void marcaUpdateValidation(final Long id, final Marca marca) {

        Marca databaseMarca = this.marcaRepository.findById(id).orElse(null);
        if (databaseMarca == null || !databaseMarca.getId().equals(marca.getId())) {
            throw new RuntimeException("Registro não encontrado");
        }

        marca.setCadastro(databaseMarca.getCadastro());

        databaseMarca = this.marcaRepository.findByNome(marca.getNome());
        if (databaseMarca != null) {
            Assert.isTrue(marca.getId().equals(databaseMarca.getId()),
                    "Esta marca já está nos registros");
        }

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
