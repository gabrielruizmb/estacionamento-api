package br.com.uniamerica.estacionamento.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalTime;
@Entity
@Table(name = "configuracoes", schema = "public")
public class Configuracao extends AbstractEntity{
    @Getter @Setter
    @Column(name = "valor_hora", nullable = false)
    private BigDecimal valorHora;

    @Getter @Setter
    @Column(name = "valor_minuto_hora", nullable = false)
    private BigDecimal valorMinutoHora;

    @Getter @Setter
    @Column(name = "inicio_expediente", nullable = false)
    private LocalTime inicioExpediente;

    @Getter @Setter
    @Column(name = "fim_expediente", nullable = false)
    private LocalTime fimExpediente;

    @Getter @Setter
    @Column(name = "tempo_desconto", nullable = false)
    private LocalTime tempoParaDesconto;

    @Getter @Setter
    @Column(name = "tempo_de_desconto", nullable = false)
    private LocalTime tempoDeDesconte;

    @Getter @Setter
    @Column(name = "gerar_desconto", nullable = false)
    private boolean gerarDesconto;
    @Getter @Setter
    @Column(name = "vagas_moto", nullable = false, length = 100)
    private int vagasMoto;
    @Getter @Setter
    @Column(name = "vagas_carro", nullable = false, length = 100)
    private int vagasCarro;
    @Getter @Setter
    @Column(name = "vagas_van", nullable = false, length = 100)
    private int vagasVan;
}
