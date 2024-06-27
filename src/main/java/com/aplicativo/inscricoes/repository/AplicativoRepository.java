package com.aplicativo.inscricoes.repository;

import com.aplicativo.inscricoes.entidade.Aplicativo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AplicativoRepository extends JpaRepository<Aplicativo, Long> {
    // Métodos personalizados, como buscar por nome
    Aplicativo findByNome(String nome);
}
