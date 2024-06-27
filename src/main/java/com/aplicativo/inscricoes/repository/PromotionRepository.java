package com.aplicativo.aplicativo.Respository;

import com.suaempresa.subscriptions.model.Promocao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionRepository extends JpaRepository<Promocao, Long> {
    // Métodos para buscar promoções por descrição ou desconto
    Promocao findByDescricao(String descricao);
}
