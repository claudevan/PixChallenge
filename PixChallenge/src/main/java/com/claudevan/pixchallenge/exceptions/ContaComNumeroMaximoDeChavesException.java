package com.claudevan.pixchallenge.exceptions;

import com.claudevan.pixchallenge.model.dto.chave.ChaveCreateRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

import java.text.MessageFormat;

public class ContaComNumeroMaximoDeChavesException extends PixException {
    private final ChaveCreateRequest request;
    private final Integer quantidade;

    public ContaComNumeroMaximoDeChavesException(ChaveCreateRequest request, Integer quantidade) {
        this.request = request;
        this.quantidade = quantidade;
    }

    @Override
    public ProblemDetail toProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

        pb.setTitle("Número Máximo de chaves");
        pb.setDetail(MessageFormat.format("A conta {0} e agencia {1}, já possui {2} chaves cadastradas", request.conta(), request.agencia(), quantidade));

        return pb;
    }
}
