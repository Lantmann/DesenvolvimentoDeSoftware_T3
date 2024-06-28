package com.aplicativo.inscricoes.repository;

import com.aplicativo.inscricoes.entidades.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
    // Métodos adicionais podem ser definidos aqui, por exemplo, buscar pagamentos por assinatura

}
