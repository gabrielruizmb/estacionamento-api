package br.com.uniamerica.estacionamento.service;

import br.com.uniamerica.estacionamento.entity.Condutor;
import br.com.uniamerica.estacionamento.entity.Veiculo;
import br.com.uniamerica.estacionamento.repository.CondutorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CondutorService {
    final CondutorRepository condutorRepository;

    public CondutorService(CondutorRepository condutorRepository) {
        this.condutorRepository = condutorRepository;
    }

    @Transactional(rollbackFor = Exception.class)
    public void createCondutorValidation(final Condutor condutor) {
        this.condutorRepository.save(condutor);
    }

    @Transactional(rollbackFor = Exception.class)
    public void updateCondutorValidation(final Long id, final Condutor condutor) {
        this.condutorRepository.save(condutor);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteCondutorValidation(final Long id) {
        this.condutorRepository.deleteById(id);
    }
}
