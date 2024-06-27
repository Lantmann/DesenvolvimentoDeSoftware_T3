package com.aplicativo.aplicativo.Service;

import com.suaempresa.subscriptions.model.Promocao;
import com.suaempresa.subscriptions.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PromotionService {

    @Autowired
    private PromotionRepository promotionRepository;

    public List<Promocao> findAll() {
        return promotionRepository.findAll();
    }

    public Optional<Promocao> findById(Long id) {
        return promotionRepository.findById(id);
    }

    public Promocao save(Promocao promocao) {
        return promotionRepository.save(promocao);
    }

    public void deleteById(Long id) {
        promotionRepository.deleteById(id);
    }

    public Promocao findByDescricao(String descricao) {
        return promotionRepository.findByDescricao(descricao);
    }
}
