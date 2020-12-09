package com.rodtech.mypreciouscadastroapi.service.impl;

import com.rodtech.mypreciouscadastroapi.model.Pessoa;
import com.rodtech.mypreciouscadastroapi.repository.PessoaRepository;
import com.rodtech.mypreciouscadastroapi.service.PessoaService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaServiceImpl implements PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaServiceImpl(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public List<Pessoa> buscarTodos(Pageable pageable) {
        return pessoaRepository.findAll(pageable).getContent();
    }

    @Override
    public Pessoa buscarPorId(Long id) {
        return buscarPessoaPorId(id);
    }

    @Override
    public Pessoa incluir(Pessoa pessoa) {
        validar(pessoa);
        return pessoaRepository.save(pessoa);
    }

    @Override
    public Pessoa atualizar(Pessoa pessoa) {
        validar(pessoa);
        Pessoa pessoaDb = buscarPessoaPorId(pessoa.getId());
        pessoaDb.setNome(pessoa.getNome());
        return pessoaRepository.save(pessoaDb);
    }

    @Override
    public void excluir(Long id) {
        Pessoa pessoaDb = buscarPessoaPorId(id);
        pessoaRepository.delete(pessoaDb);
    }

    private Pessoa buscarPessoaPorId(Long id){
        return pessoaRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Pessoa não encontrada"));
    }

    private void validar(Pessoa pessoa){

        Long id = pessoa.getId()!=null ? pessoa.getId() : 0L;
        if(pessoaRepository.findFirstByNomeAndIdIsNot(pessoa.getNome(), id).isPresent()){
            throw new RuntimeException("Já existe uma Pessoa com o mesmo nome");
        }

    }
}
