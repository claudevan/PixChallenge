package com.claudevan.pixchallenge.model.entity;

import com.claudevan.pixchallenge.model.dto.chave.ChaveCreateRequest;
import com.claudevan.pixchallenge.model.enums.TipoChave;
import jakarta.persistence.*;
import lombok.*;

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

    public Chave(ChaveCreateRequest request, Conta contaNew) {
        conta = contaNew;
        tipoChave = request.tipoChave();
        valor = request.valorChave();
    }
}

