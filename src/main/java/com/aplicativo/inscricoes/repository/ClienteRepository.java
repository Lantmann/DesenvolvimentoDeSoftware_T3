package com.aplicativo.aplicativo.Respository;

import com.suaempresa.subscriptions.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Por exemplo, encontrar cliente por email
    Cliente findByEmail(String email);
}
