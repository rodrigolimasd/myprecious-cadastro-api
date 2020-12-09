package com.rodtech.mypreciouscadastroapi.service;

import com.rodtech.mypreciouscadastroapi.model.Categoria;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoriaService {

    List<Categoria> buscarTodos(Pageable pageable);
    Categoria buscarPorId(Long id);
    Categoria incluir(Categoria categoria);
    Categoria atualizar(Categoria categoria);
    void excluir(Long id);

}
