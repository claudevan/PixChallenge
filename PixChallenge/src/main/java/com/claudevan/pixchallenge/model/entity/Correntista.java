package com.claudevan.pixchallenge.model.entity;

import com.claudevan.pixchallenge.model.dto.chave.ChaveCreateRequest;
import com.claudevan.pixchallenge.model.dto.correntista.CorrentistaCreateRequest;
import com.claudevan.pixchallenge.model.enums.TipoConta;
import com.claudevan.pixchallenge.model.enums.TipoPessoa;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.ArrayList;
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

    private TipoConta tipoConta;

    private String nome;
    private String sobrenome;

    private TipoPessoa tipoPessoa;

    @Column(unique = true, nullable = false, length = 14)
    private String documento;

    @Column(name = "dataInclusao", insertable = true, updatable = false)
    @CreationTimestamp
    private Instant dataInclusao = Instant.now();

    @Column(name = "dataAlteracao", insertable = false, updatable = true)
    @UpdateTimestamp
    private Instant dataAlteracao = Instant.now();

    @OneToMany(mappedBy = "correntista", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Conta> contas;

    @org.springframework.data.annotation.Transient
    private Integer quantidadeMaxima;

    public Correntista(CorrentistaCreateRequest request) {
        this.nome = request.nome();
        this.tipoConta = request.tipoConta();
        this.sobrenome = request.sobrenome();
        this.tipoPessoa = request.tipoPessoa();
    }

    public Correntista(ChaveCreateRequest request) {
        this.nome = request.nome();
        this.tipoConta = request.tipoConta();
        this.sobrenome = request.sobrenome();
        this.tipoPessoa = request.tipoPessoa();
        this.documento = request.documento();
    }
}
