package com.claudevan.pixchallenge.model.entity;

import com.claudevan.pixchallenge.model.enums.TipoChave;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ChaveId implements Serializable {
    private Conta conta;
    private TipoChave tipoChave;
}
