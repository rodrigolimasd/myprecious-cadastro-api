package com.rodtech.mypreciouscadastroapi.controller;

import com.rodtech.mypreciouscadastroapi.model.Categoria;
import com.rodtech.mypreciouscadastroapi.model.constants.API;
import com.rodtech.mypreciouscadastroapi.service.CategoriaService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(API.VERSAO +"/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(categoriaService.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity buscarTodos(Pageable pageable){
        return ResponseEntity.ok(categoriaService.buscarTodos(pageable));
    }

    @PostMapping
    public ResponseEntity incluir(@RequestBody @Valid Categoria categoria){
        Categoria result = categoriaService.incluir(categoria);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(result.getId()).toUri();
        return ResponseEntity.created(uri).body(categoria);
    }

    @PutMapping
    public ResponseEntity atualizar(@RequestBody @Valid Categoria categoria){
        categoriaService.atualizar(categoria);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Long id){
        categoriaService.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
