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
    private String conta;
    private String agencia;

    @OneToOne
    @JoinColumn(name = "correntista_id")
    private Correntista correntista;

    @OneToMany
    private List<Chave> chaves;
}