package br.com.uniamerica.estacionamento.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Entity
@Table(name = "condutores", schema = "public")
public class Condutor extends AbstractEntity{
    @Getter @Setter
    @Column(name = "nome", nullable = false, length = 30)
    private String nome;

    @Getter @Setter
    @Column(name = "cpf", nullable = false, unique = true, length = 15)
    private String cpf;

    @Getter @Setter
    @Column(name = "telefone", nullable = false, length = 17)
    private String telefone;

    @Getter @Setter
    @Column(name = "tempo_pago", nullable = false)
    private LocalTime tempoPago;

    @Getter @Setter
    @Column(name = "tempo_desconto", nullable = false)
    private LocalTime tempoDesconto;
}
