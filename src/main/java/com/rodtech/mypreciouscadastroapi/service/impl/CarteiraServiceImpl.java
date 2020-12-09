package com.rodtech.mypreciouscadastroapi.service.impl;

import com.rodtech.mypreciouscadastroapi.model.Carteira;
import com.rodtech.mypreciouscadastroapi.repository.CarteiraRepository;
import com.rodtech.mypreciouscadastroapi.service.CarteiraService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarteiraServiceImpl implements CarteiraService {

    private final CarteiraRepository carteiraRepository;

    public CarteiraServiceImpl(CarteiraRepository carteiraRepository) {
        this.carteiraRepository = carteiraRepository;
    }

    @Override
    public List<Carteira> buscarTodos(Pageable pageable) {
        return carteiraRepository.findAll(pageable).getContent();
    }

    @Override
    public Carteira buscarPorId(Long id) {
        return buscarCarteiraPorId(id);
    }

    @Override
    public Carteira incluir(Carteira carteira) {
        validar(carteira);
        return carteiraRepository.save(carteira);
    }

    @Override
    public Carteira atualizar(Carteira carteira) {
        validar(carteira);
        Carteira carteiraDb = buscarCarteiraPorId(carteira.getId());
        carteiraDb.setNome(carteira.getNome());
        return carteiraRepository.save(carteiraDb);
    }

    @Override
    public void excluir(Long id) {
        Carteira carteiraDb = buscarCarteiraPorId(id);
        carteiraRepository.delete(carteiraDb);
    }

    private Carteira buscarCarteiraPorId(Long id){
        return carteiraRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Carteira não encontrada"));
    }

    private void validar(Carteira carteira){

        Long id = carteira.getId()!=null ? carteira.getId() : 0L;
        if(carteiraRepository.findFirstByNomeAndIdIsNot(carteira.getNome(), id).isPresent()){
            throw new RuntimeException("Já existe uma Carteira com o mesmo nome");
        }

    }
}
