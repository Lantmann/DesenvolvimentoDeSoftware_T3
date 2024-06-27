package com.aplicativo.aplicativo.Respository;

import com.suaempresa.subscriptions.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
    // Métodos adicionais podem ser definidos aqui, por exemplo, buscar pagamentos por assinatura
}
