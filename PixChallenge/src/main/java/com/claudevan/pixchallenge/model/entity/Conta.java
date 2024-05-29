package com.claudevan.pixchallenge.model.entity;

import com.claudevan.pixchallenge.model.dto.chave.ChaveCreateRequest;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.ArrayList;
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
    private Integer agencia;

    @ManyToOne()
    @JoinColumn(name = "correntista_id")
    private Correntista correntista;

    @OneToMany(mappedBy = "conta", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Chave> chaves;

    @Column(name = "dataInclusao", insertable = true, updatable = false)
    @CreationTimestamp
    private Instant dataInclusao = Instant.now();

    @Column(name = "dataAlteracao", insertable = false, updatable = true)
    @UpdateTimestamp
    private Instant dataAlteracao = Instant.now();

    public Conta(ChaveCreateRequest request, Correntista correntista) {
        conta = request.conta();
        agencia = request.agencia();
        this.correntista = correntista;
    }
}
