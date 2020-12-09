package com.rodtech.mypreciouscadastroapi.controller;

import com.rodtech.mypreciouscadastroapi.model.Pessoa;
import com.rodtech.mypreciouscadastroapi.model.constants.API;
import com.rodtech.mypreciouscadastroapi.service.PessoaService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(API.VERSAO +"/pessoas")
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(pessoaService.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity buscarTodos(Pageable pageable){
        return ResponseEntity.ok(pessoaService.buscarTodos(pageable));
    }

    @PostMapping
    public ResponseEntity incluir(@RequestBody @Valid Pessoa pessoa){
        Pessoa result = pessoaService.incluir(pessoa);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(result.getId()).toUri();
        return ResponseEntity.created(uri).body(pessoa);
    }

    @PutMapping
    public ResponseEntity atualizar(@RequestBody @Valid Pessoa pessoa){
        pessoaService.atualizar(pessoa);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Long id){
        pessoaService.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
