package br.com.uniamerica.estacionamento.service;

import br.com.uniamerica.estacionamento.entity.Condutor;
import br.com.uniamerica.estacionamento.repository.CondutorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
public class CondutorService {
    final CondutorRepository condutorRepository;

    public CondutorService(CondutorRepository condutorRepository) {
        this.condutorRepository = condutorRepository;
    }

    @Transactional(rollbackFor = Exception.class)
    public void createCondutorValidation(final Condutor condutor) {

        Condutor databaseCondutor = this.condutorRepository.findByCpf(condutor.getCpf());
        Assert.isTrue(databaseCondutor == null,
                "Já existe um condutor com este CPF nos registros");

        this.condutorRepository.save(condutor);
    }

    @Transactional(rollbackFor = Exception.class)
    public void updateCondutorValidation(final Long id, final Condutor condutor) {

        Condutor databaseCondutor = this.condutorRepository.findById(id).orElse(null);
        Assert.isTrue(databaseCondutor != null,
                "Registro não encontrado");

        databaseCondutor = this.condutorRepository.findByCpf(condutor.getCpf());
        if (databaseCondutor != null) {
            Assert.isTrue(condutor.getId().equals(databaseCondutor.getId()),
                    "Já existe um condutor com este CPF nos registros");
        }

        this.condutorRepository.save(condutor);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteCondutorValidation(final Long id) {

        Condutor databaseCondutor = this.condutorRepository.findById(id).orElse(null);
        Assert.isTrue(databaseCondutor != null,
                "Registro não encontrado");

        this.condutorRepository.deleteById(id);
    }
}
