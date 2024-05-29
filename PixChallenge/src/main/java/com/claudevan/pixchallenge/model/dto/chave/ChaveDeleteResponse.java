package com.claudevan.pixchallenge.model.dto.chave;

import com.claudevan.pixchallenge.model.enums.TipoChave;
import com.claudevan.pixchallenge.model.enums.TipoConta;

import java.util.Date;
import java.util.UUID;

public record ChaveDeleteResponse(
        UUID id,
        TipoChave tipoChave,
        String valorChave,
        TipoConta tipoConta,
        Integer Agencia,
        Integer Conta,
        String Nome,
        String Sobrenome,
        Date DataInclusao,
        Date DataAlteracao
) {
}
