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
@IdClass(ChaveComposta.class)
public class Chave {
    @Id @JoinColumn(name = "conta_id")
    @OneToOne(fetch = FetchType.LAZY)
    private Conta conta;

    @Id @JoinColumn(name = "tipo_chave_id")
    private TipoChave tipoChave;

    @Column(length = 36, unique = true)
    private String valor;

    public Chave(ChaveCreateRequest request, Conta contaNew) {
        conta = contaNew;
        tipoChave = request.tipoChave();
        valor = request.valorChave();
    }
}

