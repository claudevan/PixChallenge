package com.claudevan.pixchallenge.model.dto.chave;

import com.claudevan.pixchallenge.model.enums.TipoChave;
import com.claudevan.pixchallenge.model.enums.TipoConta;


public record ChaveCreateRequest (
        TipoChave tipoChave,
        String valorChave,
        TipoConta tipoConta,
        Integer Agencia,
        Integer Conta,
        String Nome,
        String Sobrenome
){

}
