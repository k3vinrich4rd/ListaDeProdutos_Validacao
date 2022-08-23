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
public class ProdutosController {

    @Autowired
    private ProdutosService produtosService;

    @GetMapping(path = "/produtos")
    public ResponseEntity<List<ProdutosModel>> buscarTodosProdutos() {
        return ResponseEntity.ok(produtosService.buscarTodos());
    }

    @GetMapping(path = "/produtos/{codigo}")
    public ResponseEntity<Optional<ProdutosModel>> buscarPorId(@PathVariable Long codigo) {

        return ResponseEntity.ok(produtosService.buscarId(codigo));
    }

    @PostMapping(path = "/produtos")
    public ResponseEntity<ProdutosModel> cadastrarProdutos(@RequestBody ProdutosModel produtosModel) {
        ProdutosModel produtos = produtosService.cadastrar(produtosModel);
        return new ResponseEntity<>(produtos, HttpStatus.CREATED);
        // Vai retornar 201 - 204, pois está criando algo
    }

    @PutMapping(path = "/produtos/{codigo}")
    public ResponseEntity<ProdutosModel> alterarProdutos(@RequestBody ProdutosModel produtos) {
        return ResponseEntity.ok(produtosService.alterar(produtos));
    }

    @DeleteMapping(path = "/produtos/{codigo}") // Não é necessário usar o response entity no delete
    // exemplo: public. ResponseEntity<void>
    public void deletarProdutos(@PathVariable Long codigo) {
        produtosService.deletar(codigo);
    }
}
