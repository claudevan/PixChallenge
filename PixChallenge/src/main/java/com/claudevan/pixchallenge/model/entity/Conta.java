package com.claudevan.pixchallenge.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "contas")
@AllArgsConstructor
@NoArgsConstructor
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private Integer conta;
    @Column(nullable = false)
    private String agencia;

    @OneToOne
    @JoinColumn(name = "correntista_id")
    private Correntista correntista;

    @OneToMany
    private List<Chave> chaves;
}
