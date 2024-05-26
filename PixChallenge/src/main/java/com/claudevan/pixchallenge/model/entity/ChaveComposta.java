package com.claudevan.pixchallenge.model.entity;

import com.claudevan.pixchallenge.model.enums.TipoChave;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChaveComposta implements Serializable {
    private Conta conta;
    private TipoChave tipoChave;
}
