package com.claudevan.pixchallenge.model.entity;

import com.claudevan.pixchallenge.model.dto.correntista.CorrentistaCreateRequest;
import com.claudevan.pixchallenge.model.enums.TipoConta;
import com.claudevan.pixchallenge.model.enums.TipoPessoa;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "correntistas")
@AllArgsConstructor
@NoArgsConstructor
public class Correntista {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotBlank
    private TipoConta tipoConta;
    @NotBlank
    private String nome;
    private String sobrenome;
    @NotBlank
    private TipoPessoa tipoPessoa;
    @Column(name = "dataInclusao", insertable = true, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInclusao;
    @Column(name = "dataAlteracao", insertable = false, updatable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAlteracao;

    @OneToMany
    private List<Conta> conta;

    public Correntista(CorrentistaCreateRequest request) {
        this.nome = request.nome();
        this.tipoConta = request.tipoConta();
        this.sobrenome = request.sobrenome();
        this.tipoPessoa = request.tipoPessoa();
    }
}
