package com.claudevan.pixchallenge.model.dto.chave;

import com.claudevan.pixchallenge.model.enums.TipoChave;
import com.claudevan.pixchallenge.model.enums.TipoConta;

import java.util.UUID;

public record ChaveUpdateRequest (
        UUID id,
        TipoConta tipoConta,
        Integer Agencia,
        Integer Conta,
        String Nome,
        String Sobrenome
){
}
