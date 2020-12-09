package com.rodtech.mypreciouscadastroapi.repository;

import com.rodtech.mypreciouscadastroapi.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    Optional<Categoria> findFirstByNomeAndIdIsNot(String nome, Long id);
    Optional<Categoria> findFirstByCodigoAndIdIsNot(String nome, Long id);

}
