package com.rodtech.mypreciouscadastroapi.controller;

import com.rodtech.mypreciouscadastroapi.model.Carteira;
import com.rodtech.mypreciouscadastroapi.model.constants.API;
import com.rodtech.mypreciouscadastroapi.service.CarteiraService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = API.VERSAO + "/carteiras")
public class CarteiraController {

    private final CarteiraService carteiraService;

    public CarteiraController(CarteiraService carteiraService) {
        this.carteiraService = carteiraService;
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(carteiraService.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity buscarTodos(Pageable pageable){
        return ResponseEntity.ok(carteiraService.buscarTodos(pageable));
    }

    @PostMapping
    public ResponseEntity incluir(@RequestBody @Valid Carteira carteira){
        Carteira result = carteiraService.incluir(carteira);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(result.getId()).toUri();
        return ResponseEntity.created(uri).body(carteira);
    }

    @PutMapping
    public ResponseEntity atualizar(@RequestBody @Valid Carteira carteira){
        carteiraService.atualizar(carteira);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Long id){
        carteiraService.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
