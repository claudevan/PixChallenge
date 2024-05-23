package com.claudevan.pixchallenge.service;

import com.claudevan.pixchallenge.model.dto.chave.ChaveCreateRequest;
import com.claudevan.pixchallenge.repositories.ChaveRepository;
import com.claudevan.pixchallenge.repositories.ContaRepository;
import com.claudevan.pixchallenge.repositories.CorrentistaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ChaveService {


    private final ChaveRepository chaveRepository;
    private final CorrentistaRepository correntistaRepository;
    private final ContaRepository contaRepository;

    public ChaveService(ChaveRepository chaveRepository, CorrentistaRepository correntistaRepository, ContaRepository contaRepository) {
        this.chaveRepository = chaveRepository;
        this.correntistaRepository = correntistaRepository;
        this.contaRepository = contaRepository;
    }

    public String create(ChaveCreateRequest request){
        UUID correntistaId = contaRepository.findCorrentistaByAgenciaConta(request.Agencia(), request.Conta());

        //Senão encontrar o correntista deve cadastrar

        //Pesquisar chave e quantidades cadastradas

        return correntistaId.toString();
    }
}
