package com.claudevan.pixchallenge.model.entity;

import com.claudevan.pixchallenge.model.dto.chave.ChaveCreateRequest;
import com.claudevan.pixchallenge.model.enums.TipoChave;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Data
@Entity
@Table(name = "chaves")
@AllArgsConstructor
@NoArgsConstructor
@IdClass(ChaveId.class)
public class Chave {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "conta_id")
    private Conta conta;

    @Id
    @Column(name = "tipo_chave")
    @Enumerated(EnumType.STRING)
    private TipoChave tipoChave;

    @Column(length = 36, unique = true)
    private String valor;

    @Column(nullable = false)
    private boolean ativa = true;

    @Column(name = "dataInclusao", insertable = true, updatable = false)
    @CreationTimestamp
    private Instant dataInclusao = Instant.now();

    @Column(name = "dataAlteracao", insertable = false, updatable = true)
    @UpdateTimestamp
    private Instant dataAlteracao = Instant.now();

    public Chave(ChaveCreateRequest request) {
        //this.conta = conta;
        this.tipoChave = request.tipoChave();
        this.valor = request.valorChave();
    }
}

