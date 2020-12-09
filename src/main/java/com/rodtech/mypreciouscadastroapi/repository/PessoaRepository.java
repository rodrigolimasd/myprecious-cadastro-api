package com.rodtech.mypreciouscadastroapi.repository;

import com.rodtech.mypreciouscadastroapi.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    Optional<Pessoa> findFirstByNomeAndIdIsNot(String nome, Long id);
}
