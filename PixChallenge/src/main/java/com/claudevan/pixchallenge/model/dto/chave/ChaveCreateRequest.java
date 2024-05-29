package com.claudevan.pixchallenge.model.dto.chave;

import com.claudevan.pixchallenge.model.enums.TipoChave;
import com.claudevan.pixchallenge.model.enums.TipoConta;
import com.claudevan.pixchallenge.model.enums.TipoPessoa;
import jakarta.validation.constraints.*;


public record ChaveCreateRequest (
        @NotNull(message = "Campo Obrigatorio")
        TipoChave tipoChave,

        @NotBlank(message = "Campo Obrigatorio")
        String valorChave,

        @NotNull(message = "Campo Obrigatorio")
        TipoConta tipoConta,

        @Positive @Digits(integer = 4, fraction = 0)
        Integer agencia,

        @NotNull(message = "Campo Obrigatorio")
        Integer conta,

        @NotBlank(message = "Campo Obrigatorio")
        String nome,

        String sobrenome,

        @NotNull(message = "Campo Obrigatorio")
        TipoPessoa tipoPessoa,

        @NotBlank(message = "Campo Obrigatorio")
        String documento
){

}
