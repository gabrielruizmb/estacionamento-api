package br.com.uniamerica.estacionamento.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import java.time.Year;

@Audited
@AuditTable(value = "tb_veiculos_audit", schema = "audit")
@Entity
@Table(name = "veiculos", schema = "public")
public class Veiculo extends AbstractEntity{
    @Size(min = 4, max = 10, message = "A placa deve conter entre 4 e 10 caractéres")
    @Getter @Setter
    @Column(name = "placa", nullable = false, unique = true, length = 10)
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