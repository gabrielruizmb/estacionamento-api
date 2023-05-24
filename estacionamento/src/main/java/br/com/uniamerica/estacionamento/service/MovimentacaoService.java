package br.com.uniamerica.estacionamento.service;

import br.com.uniamerica.estacionamento.entity.Movimentacao;
import br.com.uniamerica.estacionamento.repository.MovimentacaoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
public class MovimentacaoService {
    final MovimentacaoRepository movimentacaoRepository;

    public MovimentacaoService(MovimentacaoRepository movimentacaoRepository) {
        this.movimentacaoRepository = movimentacaoRepository;
    }

    @Transactional(rollbackFor = Exception.class)
    public void updateMovimentacaoValidation(final Long id, Movimentacao movimentacao) {
        Movimentacao databaseMovimentacao = this.movimentacaoRepository.findById(id).orElse(null);
        Assert.isTrue(databaseMovimentacao != null,
                "Registro de movimentação não encontrado");

        this.movimentacaoRepository.save(movimentacao);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteMovimentacaoValidation(final Long id) {
        Movimentacao databaseMovimentacao = this.movimentacaoRepository.findById(id).orElse(null);
        Assert.isTrue(databaseMovimentacao != null,
                "Registro de movimentação não encontrado");

        this.movimentacaoRepository.deleteById(id);
    }
}
