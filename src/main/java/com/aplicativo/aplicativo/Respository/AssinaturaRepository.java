package com.aplicativo.aplicativo.Respository;

import com.suaempresa.subscriptions.model.Assinatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssinaturaRepository extends JpaRepository<Assinatura, Long> {
    // Métodos customizados podem ser adicionados aqui
}
