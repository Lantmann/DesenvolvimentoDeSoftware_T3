package com.aplicativo.inscricoes.repository;

import com.aplicativo.inscricoes.entidades.Assinatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssinaturaRepository extends JpaRepository<Assinatura, Long> {
    // Métodos customizados podem ser adicionados aqui
}
