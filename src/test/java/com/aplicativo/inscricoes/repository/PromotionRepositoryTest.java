package com.suaempresa.subscriptions.repository;

import com.suaempresa.subscriptions.model.Promocao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PromotionRepositoryTest {

    @Autowired
    private PromotionRepository promotionRepository;

    private Promocao promocao1;
    private Promocao promocao2;

    @BeforeEach
    void setUp() {
        promocao1 = new Promocao();
        promocao1.setDescricao("Promo Verão");
        promocao1.setDesconto(15.0);

        promocao2 = new Promocao();
        promocao2.setDescricao("Promoção de Natal");
        promocao2.setDesconto(30.0);

        promotionRepository.save(promocao1);
        promotionRepository.save(promocao2);
    }

    @Test
    void testFindAll() {
        List<Promocao> promocoes = promotionRepository.findAll();

        assertEquals(2, promocoes.size());
    }

    @Test
    void testFindById() {
        Optional<Promocao> promocao = promotionRepository.findById(promocao1.getId());

        assertTrue(promocao.isPresent());
        assertEquals("Promo Verão", promocao.get().getDescricao());
    }

    @Test
    void testSave() {
        Promocao promocao3 = new Promocao();
        promocao3.setDescricao("Black Friday");
        promocao3.setDesconto(50.0);

        Promocao savedPromocao = promotionRepository.save(promocao3);

        assertNotNull(savedPromocao);
        assertEquals("Black Friday", savedPromocao.getDescricao());
    }

    @Test
    void testDeleteById() {
        promotionRepository.deleteById(promocao1.getId());

        Optional<Promocao> promocao = promotionRepository.findById(promocao1.getId());

        assertFalse(promocao.isPresent());
    }
}
