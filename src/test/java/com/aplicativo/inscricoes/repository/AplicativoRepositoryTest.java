package com.suaempresa.subscriptions.repository;

import com.suaempresa.subscriptions.model.Aplicativo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AplicativoRepositoryTest {

    @Autowired
    private AplicativoRepository aplicativoRepository;

    private Aplicativo aplicativo1;
    private Aplicativo aplicativo2;

    @BeforeEach
    void setUp() {
        aplicativo1 = new Aplicativo();
        aplicativo1.setNome("App Pro");
        aplicativo1.setCustoMensal(19.99);

        aplicativo2 = new Aplicativo();
        aplicativo2.setNome("App Basic");
        aplicativo2.setCustoMensal(9.99);

        aplicativoRepository.save(aplicativo1);
        aplicativoRepository.save(aplicativo2);
    }

    @Test
    void testFindAll() {
        List<Aplicativo> aplicativos = aplicativoRepository.findAll();

        assertEquals(2, aplicativos.size());
    }

    @Test
    void testFindById() {
        Optional<Aplicativo> aplicativo = aplicativoRepository.findById(aplicativo1.getId());

        assertTrue(aplicativo.isPresent());
        assertEquals("App Pro", aplicativo.get().getNome());
    }

    @Test
    void testSave() {
        Aplicativo aplicativo3 = new Aplicativo();
        aplicativo3.setNome("App Premium");
        aplicativo3.setCustoMensal(29.99);

        Aplicativo savedAplicativo = aplicativoRepository.save(aplicativo3);

        assertNotNull(savedAplicativo);
        assertEquals("App Premium", savedAplicativo.getNome());
    }

    @Test
    void testDeleteById() {
        aplicativoRepository.deleteById(aplicativo1.getId());

        Optional<Aplicativo> aplicativo = aplicativoRepository.findById(aplicativo1.getId());

        assertFalse(aplicativo.isPresent());
    }
}
