package com.claudevan.pixchallenge.service;

import com.claudevan.pixchallenge.entity.Correntista;
import com.claudevan.pixchallenge.repository.CorrentistaRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CorrentistaService {


    private final CorrentistaRepository correntistaRepository;

    public CorrentistaService(CorrentistaRepository correntistaRepository) {
        this.correntistaRepository = correntistaRepository;
    }

    public List<Correntista> create(Correntista correntista){
        correntistaRepository.save(correntista);

        return list();
    }

    public List<Correntista> list(){
        Sort sort = Sort.by("nome").ascending();

       return correntistaRepository.findAll(sort);
    }

    public List<Correntista> update(Correntista correntista){
        correntistaRepository.save(correntista);

        return list();
    }

    public List<Correntista> delete(UUID id){
        correntistaRepository.deleteById(id);

        return list();
    }
}
