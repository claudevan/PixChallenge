package com.claudevan.pixchallenge.model.entity;

import com.claudevan.pixchallenge.model.enums.TipoChave;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "chaves")
@AllArgsConstructor
@NoArgsConstructor
public class Chave {
    @Id @JoinColumn(name = "conta_id")
    @OneToOne(fetch = FetchType.LAZY)
    private Conta conta;

    @Id @JoinColumn(name = "tipo_chave_id")
    private TipoChave tipoChave;

    @Column(length = 36, unique = true)
    private String valor;
}
