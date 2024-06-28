package com.aplicativo.inscricoes.repository;

import com.aplicativo.inscricoes.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Encontrar cliente por email
    Cliente findByEmail(String email);
}
