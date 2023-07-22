package br.com.uniamerica.estacionamento.service;

import br.com.uniamerica.estacionamento.entity.Configuracao;
import br.com.uniamerica.estacionamento.repository.ConfiguracaoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
public class ConfiguracaoService {
    final ConfiguracaoRepository configuracaoRepository;

    public ConfiguracaoService(ConfiguracaoRepository configuracaoRepository) {
        this.configuracaoRepository = configuracaoRepository;
    }

    @Transactional(rollbackFor = Exception.class)
    public void createConfiguracaoValidation(final Configuracao configuracao) {
        this.configuracaoRepository.save(configuracao);
    }
    @Transactional(rollbackFor = Exception.class)
    public void updateConfiguracaoValidation(final Long id, final Configuracao configuracao) {

        Configuracao databaseConfiguracao = this.configuracaoRepository.findById(id).orElse(null);
        Assert.isTrue(databaseConfiguracao != null, "Registro de configuração não encontrado");

        this.configuracaoRepository.save(configuracao);
    }
}
