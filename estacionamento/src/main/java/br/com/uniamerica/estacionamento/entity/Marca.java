package br.com.uniamerica.estacionamento.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

@Audited
@AuditTable(value = "tb_marcas_audit", schema = "audit")
@Entity
@Table(name = "marcas", schema = "public")
public class Marca extends AbstractEntity{
    @Getter @Setter
    @Column(name = "nome", nullable = false, unique = true, length = 50)
    private String nome;
}
