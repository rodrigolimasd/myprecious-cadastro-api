package com.rodtech.mypreciouscadastroapi.service.impl;

import com.rodtech.mypreciouscadastroapi.model.Categoria;
import com.rodtech.mypreciouscadastroapi.repository.CategoriaRepository;
import com.rodtech.mypreciouscadastroapi.service.CategoriaService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public List<Categoria> buscarTodos(Pageable pageable) {
        return categoriaRepository.findAll(pageable).getContent();
    }

    @Override
    public Categoria buscarPorId(Long id) {
        return buscarCategoriaPorId(id);
    }

    @Override
    public Categoria incluir(Categoria categoria) {
        validar(categoria);
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria atualizar(Categoria categoria) {
        validar(categoria);
        Categoria categoriaDb = buscarCategoriaPorId(categoria.getId());
        categoriaDb.setNome(categoria.getNome());
        categoriaDb.setCodigo(categoria.getCodigo());
        return categoriaRepository.save(categoriaDb);
    }

    @Override
    public void excluir(Long id) {
        Categoria categoriaDb = buscarCategoriaPorId(id);
        categoriaRepository.delete(categoriaDb);
    }

    private Categoria buscarCategoriaPorId(Long id){
        return categoriaRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Categoria não encontrada"));
    }

    private void validar(Categoria categoria){

        Long id = categoria.getId()!=null ? categoria.getId() : 0L;
        if(categoriaRepository.findFirstByNomeAndIdIsNot(categoria.getNome(), id).isPresent()){
            throw new RuntimeException("Já existe uma Categoria com o mesmo nome");
        }
        if(categoriaRepository.findFirstByCodigoAndIdIsNot(categoria.getCodigo(), id).isPresent()){
            throw new RuntimeException("Já existe uma Categoria com o mesmo código");
        }

    }
}
