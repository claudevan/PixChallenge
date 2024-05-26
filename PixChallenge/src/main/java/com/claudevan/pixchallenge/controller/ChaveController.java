package com.claudevan.pixchallenge.controller;

import com.claudevan.pixchallenge.model.dto.chave.ChaveCreateRequest;
import com.claudevan.pixchallenge.service.ChaveService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chaves")
public class ChaveController {


    private final ChaveService chaveService;

    public ChaveController(ChaveService chaveService) {
        this.chaveService = chaveService;
    }

    @PostMapping
    ResponseEntity<String> create(@Valid @RequestBody ChaveCreateRequest request){

        return ResponseEntity.ok(chaveService.create(request));
    }

//    @PutMapping
//    ResponseEntity<ChaveUpdateResponse> update(@RequestBody ChaveUpdateRequest request){
//        return ResponseEntity.ok("Chave created");
//    }
//
//    @DeleteMapping("{id}")
//    ResponseEntity<ChaveDeleteResponse> delete(@PathVariable UUID id){
//        return ResponseEntity.ok("Chave created");
//    }
}
