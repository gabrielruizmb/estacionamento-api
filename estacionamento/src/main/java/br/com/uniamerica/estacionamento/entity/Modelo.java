package br.com.uniamerica.estacionamento.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

@Audited
@AuditTable(value = "tb_modelos_audit", schema = "audit")
@Entity
@Table(name = "modelos", schema = "public")
public class Modelo extends AbstractEntity{
    @Getter @Setter
    @Column(name = "nome", nullable = false, unique = true,length = 30)
    private String nome;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "marca_id", nullable = false)
    private Marca marca;
}
