package com.claudevan.pixchallenge.model.dto.correntista;

import com.claudevan.pixchallenge.model.enums.TipoConta;
import com.claudevan.pixchallenge.model.enums.TipoPessoa;

import java.util.Date;

public record CorrentistaCreateRequest(
    TipoConta tipoConta,
    String nome,
    String sobrenome,
    TipoPessoa tipoPessoa
){

}
