package com.claudevan.pixchallenge.service;

import com.claudevan.pixchallenge.exceptions.ChaveJaCadastradaException;
import com.claudevan.pixchallenge.model.dto.chave.ChaveCreateRequest;
import com.claudevan.pixchallenge.model.entity.Chave;
import com.claudevan.pixchallenge.model.entity.Conta;
import com.claudevan.pixchallenge.model.entity.Correntista;
import com.claudevan.pixchallenge.repositories.ChaveRepository;
import com.claudevan.pixchallenge.repositories.ContaRepository;
import com.claudevan.pixchallenge.repositories.CorrentistaRepository;
import jakarta.transaction.Transactional;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

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

    @Transactional
    public String create(ChaveCreateRequest request) {
        Correntista correntistaSalvo = null;
        Conta contaSalva = null;
        Chave chaveSalva = null;

        var correntista = correntistaRepository.findCorrentistaByDocumento(request.documento());
        if(correntista.isEmpty()) {
            correntistaSalvo = correntistaRepository.save(new Correntista(request));
        }

        var conta = contaRepository.findContaByAgenciaAndConta(request.agencia(), request.conta());
        if(conta.isEmpty()){
            contaSalva = contaRepository.save(new Conta(request, correntistaSalvo));
        }

        var chave = chaveRepository.findChaveByValorAndTipoChave(request.valorChave(), request.tipoChave());

        if(chave.isPresent()){
            throw new ChaveJaCadastradaException(request);
        }

        var chavesCadastradas = chaveRepository.findChaveByConta(contaSalva);

        if(chavesCadastradas.stream().count() > 5){
            throw new ChaveJaCadastradaException(request);
        }

        chaveSalva = chaveRepository.save(new Chave(request, contaSalva));



        //Pesquisar chave e quantidades cadastradas

        return correntistaSalvo.getId().toString();
    }
}
