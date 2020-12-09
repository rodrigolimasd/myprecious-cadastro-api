package com.rodtech.mypreciouscadastroapi.service;

import com.rodtech.mypreciouscadastroapi.model.Carteira;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CarteiraService {

    List<Carteira> buscarTodos(Pageable pageable);
    Carteira buscarPorId(Long id);
    Carteira incluir(Carteira carteira);
    Carteira atualizar(Carteira carteira);
    void excluir(Long id);

}
