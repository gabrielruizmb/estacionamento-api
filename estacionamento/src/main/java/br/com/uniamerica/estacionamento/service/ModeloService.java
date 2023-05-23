package br.com.uniamerica.estacionamento.service;

import br.com.uniamerica.estacionamento.entity.Modelo;
import br.com.uniamerica.estacionamento.repository.MarcaRepository;
import br.com.uniamerica.estacionamento.repository.ModeloRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ModeloService {
    final ModeloRepository modeloRepository;
    final MarcaRepository marcaRepository;

    public ModeloService(ModeloRepository modeloRepository, MarcaRepository marcaRepository) {
        this.modeloRepository = modeloRepository;
        this.marcaRepository = marcaRepository;
    }
    @Transactional(rollbackFor = Exception.class)
    public void modeloValidation(final Modelo modelo) {
        this.modeloRepository.save(modelo);
    }
    @Transactional(rollbackFor = Exception.class)
    public void modeloUpdateValidation(final Long id, final Modelo modelo) {
        final Modelo databaseModelo = this.modeloRepository.findById(id).orElse(null);
        if (databaseModelo == null || !databaseModelo.getId().equals(modelo.getId())) {
            throw new RuntimeException("Registro não encontrado");
        }

        this.modeloRepository.save(modelo);
    }
    @Transactional(rollbackFor = Exception.class)
    public void deleteModeloValidation(final Long id) {
        Modelo databaseModelo = this.modeloRepository.findById(id).orElse(null);

        if (databaseModelo == null || !databaseModelo.getId().equals(id)) {
            throw new RuntimeException("Registro não encontrado");
        }

        this.modeloRepository.deleteById(id);
    }
}
