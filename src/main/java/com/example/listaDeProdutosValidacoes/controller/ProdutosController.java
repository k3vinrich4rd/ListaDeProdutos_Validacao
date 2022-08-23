package com.example.listaDeProdutosValidacoes.controller;

import com.example.listaDeProdutosValidacoes.model.ProdutosModel;
import com.example.listaDeProdutosValidacoes.service.ProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/produtos")
public class ProdutosController {

    @Autowired
    private ProdutosService produtosService;

    @GetMapping
    public ResponseEntity<List<ProdutosModel>> buscarTodosProdutos(){
        return ResponseEntity.ok(produtosService.buscarTodos());// Retorna o status, considerado mais prático por ter mais
        // Mais funcionalidades e nos dá a possibilidade de dar a resposta que queremos passar para o usuário e dev

        /*
        Response entity: É uma Classe que importamos através do HTTP, é criado pelo spring Web que nos auxilia a fazer
        criações com o CRUD, impede de declarar informações que não foram declaradas
        */

        // O ponto "." é uma forma de pesquisa para saber os métodos que a classe que está sendo usada oferece


        /*Outra forma de se fazer
             @GetMapping
             public ResponseEntity<List<ProdutosModel>> buscarTodosProdutos(){
             return ResponseEntity.ok(produtosService.buscarTodos();
         */

    }

    @GetMapping(path = "/{codigo}")
    public ResponseEntity<Optional<ProdutosModel>> buscarPorId(@PathVariable Long codigo){
        return ResponseEntity.ok(produtosService.buscarId(codigo));
    }

    @PostMapping
    public ResponseEntity<ProdutosModel> cadastrarProdutos(@RequestBody ProdutosModel produtosModel){
        ProdutosModel produtos = produtosService.cadastrar(produtosModel);
        return new ResponseEntity<>(produtos, HttpStatus.CREATED); // Vai retornar 201 - 204, pois está criando algo
    }

    @PutMapping(path = "/{codigo}")
    public ResponseEntity<ProdutosModel> alterarProdutos(@RequestBody ProdutosModel produtos){
        return ResponseEntity.ok(produtosService.alterar(produtos));
    }

    @DeleteMapping(path = "/{codigo}") // Não é necessário usar o response entity no delete
    // exemplo: public. ResponseEntity<void>
    public void deletarProdutos(@PathVariable Long codigo){
        produtosService.deletar(codigo);
    }
}
