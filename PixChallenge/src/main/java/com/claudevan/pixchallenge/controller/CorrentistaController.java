package com.claudevan.pixchallenge.controller;

import com.claudevan.pixchallenge.entity.Correntista;
import com.claudevan.pixchallenge.service.CorrentistaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/Correntistas")
public class CorrentistaController {


    private final CorrentistaService correntistaService;

    public CorrentistaController(CorrentistaService correntistaService) {
        this.correntistaService = correntistaService;
    }

    @PostMapping
    List<Correntista> create(@RequestBody Correntista correntista)
    {
        return correntistaService.create(correntista);
    }

    @GetMapping
    List<Correntista> list()
    {
        return correntistaService.list();
    }

    @PutMapping
    List<Correntista> update(@RequestBody Correntista correntista)
    {
        return correntistaService.update(correntista);
    }

    @DeleteMapping("{id}")
    List<Correntista> delete(@PathVariable UUID id)
    {
        return correntistaService.delete(id);
    }
}
