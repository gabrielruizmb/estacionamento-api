package br.com.uniamerica.estacionamento.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

@Audited
@AuditTable(value = "tb_veiculos_audit", schema = "audit")
@Entity
@Table(name = "veiculos", schema = "public")
public class Veiculo extends AbstractEntity{
    @Getter @Setter
    @Column(name = "placa", nullable = false, length = 10)
    private String placa;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "modelo_id", nullable = false)
    private Modelo modelo;

    @Getter @Setter
    @Column(name = "cor", nullable = false)
    private Cor cor;

    @Getter @Setter
    @Column(name = "tipo", nullable = false)
    private Tipo tipo;

    @Getter @Setter
    @Column(name = "ano", nullable = false, length = 5)
    private int ano;
}
