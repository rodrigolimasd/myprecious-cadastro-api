package com.rodtech.mypreciouscadastroapi.service;

import com.rodtech.mypreciouscadastroapi.model.Pessoa;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PessoaService {

    List<Pessoa> buscarTodos(Pageable pageable);
    Pessoa buscarPorId(Long id);
    Pessoa incluir(Pessoa pessoa);
    Pessoa atualizar(Pessoa pessoa);
    void excluir(Long id);

}
