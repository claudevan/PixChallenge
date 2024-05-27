package com.claudevan.pixchallenge.exceptions;

import com.claudevan.pixchallenge.model.dto.chave.ChaveCreateRequest;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

import java.text.MessageFormat;

@Getter
@Setter
public class ChaveJaCadastradaException extends PixException {
    private ChaveCreateRequest request;

    public ChaveJaCadastradaException(ChaveCreateRequest request) {
        this.request = request;
    }

    @Override
    public ProblemDetail toProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

        pb.setTitle("Chave já cadastrada");
        pb.setDetail(MessageFormat.format("A chave {0}, para o tipo: {1}, já está cadastrada", request.valorChave(), request.tipoChave()));

        return pb;
    }

}
