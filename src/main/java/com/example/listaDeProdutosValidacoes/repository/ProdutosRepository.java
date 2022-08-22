package com.example.listaDeProdutosValidacoes.repository;

import com.example.listaDeProdutosValidacoes.model.ProdutosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutosRepository extends JpaRepository<ProdutosModel, Long> {

}
