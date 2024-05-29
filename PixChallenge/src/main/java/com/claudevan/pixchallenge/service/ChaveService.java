package com.claudevan.pixchallenge.service;

import com.claudevan.pixchallenge.exceptions.ChaveJaCadastradaException;
import com.claudevan.pixchallenge.exceptions.ContaComNumeroMaximoDeChavesException;
import com.claudevan.pixchallenge.model.dto.chave.ChaveCreateRequest;
import com.claudevan.pixchallenge.model.entity.Chave;
import com.claudevan.pixchallenge.model.entity.Conta;
import com.claudevan.pixchallenge.model.entity.Correntista;
import com.claudevan.pixchallenge.model.enums.TipoPessoa;
import com.claudevan.pixchallenge.repositories.ChaveRepository;
import com.claudevan.pixchallenge.repositories.ContaRepository;
import com.claudevan.pixchallenge.repositories.CorrentistaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        var correntista = getCorrentistaSaveIfNotExist(request);
        var conta = getContaSaveIfNotExist(request, correntista);

        //TODO: Colocar no correntista
        var quantidadeMaxima = correntista.getTipoPessoa() == TipoPessoa.PESSOA_FISICA ? 5 : 20;

        if(conta.getChaves().size() >= quantidadeMaxima){
            throw new ContaComNumeroMaximoDeChavesException(request, conta.getChaves().size());
        }

        var chave = chaveRepository.findChaveByValorAndTipoChave(request.valorChave(), request.tipoChave());
        if(chave.isPresent()){
            throw new ChaveJaCadastradaException(request);
        }

        var novaChave = new Chave(request);

        novaChave.setConta(conta);
        conta.getChaves().add(novaChave);

        chaveRepository.save(novaChave);

        return correntista.getId().toString();
    }

    private Correntista getCorrentistaSaveIfNotExist(ChaveCreateRequest request){
        Correntista correntistaSalvo = null;

        var correntista = correntistaRepository.findCorrentistaByDocumento(request.documento());
        if(correntista.isEmpty()) {
            correntistaSalvo = correntistaRepository.save(new Correntista(request));
        }

        return Optional.ofNullable(correntistaSalvo).orElse(correntista.get());
    }

    private Conta getContaSaveIfNotExist(ChaveCreateRequest request, Correntista correntista){
        Conta contaSalva = null;

        var conta = contaRepository.findContaByAgenciaAndConta(request.agencia(), request.conta());
        if(conta.isEmpty()){
            contaSalva = contaRepository.save(new Conta(request, correntista));
        }

        return Optional.ofNullable(contaSalva).orElse(conta.get());
    }
}
