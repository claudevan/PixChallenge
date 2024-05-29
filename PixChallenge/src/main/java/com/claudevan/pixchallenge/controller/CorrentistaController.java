package com.claudevan.pixchallenge.controller;

import com.claudevan.pixchallenge.model.dto.correntista.CorrentistaCreateRequest;
import com.claudevan.pixchallenge.model.entity.Correntista;
import com.claudevan.pixchallenge.service.CorrentistaService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/Correntistas")
public class CorrentistaController {


//    private final CorrentistaService service;
//
//    public CorrentistaController(CorrentistaService service) {
//        this.service = service;
//    }
//
//    @PostMapping
//    ResponseEntity<List<Correntista>> create(@RequestBody CorrentistaCreateRequest correntista)
//    {
//        return new ResponseEntity<>(service.create(correntista), HttpStatus.CREATED);
//    }
//
//    @GetMapping
//    ResponseEntity<List<Correntista>> list()
//    {
//        return new ResponseEntity<>(service.list(), HttpStatus.OK);
//    }
//
//    @PutMapping
//    ResponseEntity<List<Correntista>> update(@RequestBody Correntista correntista)
//    {
//        return new ResponseEntity<>(service.update(correntista), HttpStatus.OK);
//    }
//
//    @DeleteMapping("{id}")
//    ResponseEntity<List<Correntista>> delete(@PathVariable UUID id)
//    {
//        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
//    }
}
