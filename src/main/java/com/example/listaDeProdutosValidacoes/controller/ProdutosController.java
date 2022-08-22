package com.example.listaDeProdutosValidacoes.controller;

import com.example.listaDeProdutosValidacoes.model.ProdutosModel;
import com.example.listaDeProdutosValidacoes.service.ProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/produtos")
public class ProdutosController {

    @Autowired
    private ProdutosService produtosService;

    @GetMapping
    public List<ProdutosModel> buscarTodosProdutos(){
        return produtosService.buscarTodos();
    }

    @GetMapping(path = "/{codigo}")
    public Optional<ProdutosModel> buscarPorId(@PathVariable Long codigo){
        return produtosService.buscarId(codigo);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutosModel cadastrarProdutos(@RequestBody ProdutosModel produtosModel){
        return produtosService.cadastrar(produtosModel);
    }

    @PutMapping(path = "/{codigo}")
    public ProdutosModel alterarProdutos(@RequestBody ProdutosModel produtos){
        return produtosService.alterar(produtos);
    }

    @DeleteMapping(path = "/{codigo}")
    public void deletarProdutos(@PathVariable Long codigo){
        produtosService.deletar(codigo);
    }
}
