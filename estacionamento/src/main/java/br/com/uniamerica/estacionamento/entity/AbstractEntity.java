package br.com.uniamerica.estacionamento.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@MappedSuperclass
public abstract class AbstractEntity {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    @NotNull
    @Getter @Setter
    @Column(name = "cadastro", nullable = false)
    private LocalDateTime cadastro;
    @Getter @Setter
    @Column(name = "atualizar")
    private LocalDateTime atualizar;
    @Getter @Setter
    @Column(name = "ativo")
    private boolean ativo;

    @PrePersist
    public void dataCadastro() {
        this.setCadastro(LocalDateTime.now());
        this.ativo = true;
    }
    @PreUpdate void dataUpdate() {
        this.setAtualizar(LocalDateTime.now());
    }
}
