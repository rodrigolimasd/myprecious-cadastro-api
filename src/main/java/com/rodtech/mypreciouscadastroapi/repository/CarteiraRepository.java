package com.rodtech.mypreciouscadastroapi.repository;

import com.rodtech.mypreciouscadastroapi.model.Carteira;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarteiraRepository extends JpaRepository<Carteira, Long> {

    Optional<Carteira> findFirstByNomeAndIdIsNot(String nome, Long id);

}
