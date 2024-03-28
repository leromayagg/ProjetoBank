package com.example.projetobank.controller;


import com.example.projetobank.model.conta.Conta;
import com.example.projetobank.repository.ContaRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("conta")
public class ContaController {

    @Autowired
    ContaRepository repository;

    @GetMapping
    @ResponseStatus
    public List<Conta> listTodos(){
        return repository.findAll();
    }

    @PostMapping()
    public Conta create(@RequestBody @Valid Conta conta){
        log.info("Conta criada");
        return repository.save(conta);
    }

    @GetMapping("{id}")
    public ResponseEntity<Conta>buscarId(@PathVariable Long id){
        return repository.findById(id)
                .map(ResponseEntity::ok) //reference method
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("cpf/{cpf}")
    public ResponseEntity<Conta>buscarId(@PathVariable String cpf ){
        return repository.findByCpf(cpf)
                .map(ResponseEntity::ok) //reference method
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public void destroy(@PathVariable Long id) {
        repository.deleteById(id);
    }



}
