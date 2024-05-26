package com.claudevan.pixchallenge.service;

import com.claudevan.pixchallenge.model.dto.chave.ChaveCreateRequest;
import com.claudevan.pixchallenge.model.entity.Chave;
import com.claudevan.pixchallenge.model.entity.Conta;
import com.claudevan.pixchallenge.model.entity.Correntista;
import com.claudevan.pixchallenge.repositories.ChaveRepository;
import com.claudevan.pixchallenge.repositories.ContaRepository;
import com.claudevan.pixchallenge.repositories.CorrentistaRepository;
import jakarta.transaction.Transactional;
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
        var conta = contaRepository.findContaByAgenciaAndConta(request.agencia(), request.conta());

        if(conta.isEmpty()){
            var correntista = new Correntista(request);
            correntistaRepository.save(correntista);


            //var contaNew = new Conta(request, correntista);


            //var chave = new Chave(request, contaNew);
            //chaveRepository.save(chave);

            //contaRepository.save(contaNew);
        }

        //Senão encontrar o correntista deve cadastrar

        //Pesquisar chave e quantidades cadastradas

        return "";
    }
}
