package com.example.listaDeProdutosValidacoes.service;

import com.example.listaDeProdutosValidacoes.model.ProdutosModel;
import com.example.listaDeProdutosValidacoes.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutosService {

    @Autowired
    private ProdutosRepository produtosRepository;

    public List<ProdutosModel> buscarTodos(){
        return produtosRepository.findAll();
    }

    public Optional<ProdutosModel> buscarId(Long codigo){
        return produtosRepository.findById(codigo);
    }

    public ProdutosModel cadastrar(ProdutosModel produtosModel){

        return produtosRepository.save(produtosModel);
    }

    public ProdutosModel alterar(ProdutosModel produtos){

        return produtosRepository.save(produtos);
    }

    public void deletar(Long codigo){
        produtosRepository.deleteById(codigo);
    }
}

