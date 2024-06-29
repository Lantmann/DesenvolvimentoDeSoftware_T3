package com.aplicativo.inscricoes.repository;

import com.aplicativo.inscricoes.entidades.Promocao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromocaoRepository extends JpaRepository<Promocao, Long> {


} 
