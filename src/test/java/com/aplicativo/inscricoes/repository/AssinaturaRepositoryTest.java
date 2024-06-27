package com.suaempresa.subscriptions.repository;

import com.suaempresa.subscriptions.model.Assinatura;
import com.suaempresa.subscriptions.model.Cliente;
import com.suaempresa.subscriptions.model.Aplicativo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AssinaturaRepositoryTest {

    @Autowired
    private AssinaturaRepository assinaturaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private AplicativoRepository aplicativoRepository;

    private Assinatura assinatura1;
    private Assinatura assinatura2;
    private Cliente cliente;
    private Aplicativo aplicativo;

    @BeforeEach
    void setUp() {
        cliente = new Cliente();
        cliente.setNome("John Doe");
        cliente.setEmail("john.doe@example.com");
        cliente = clienteRepository.save(cliente);

        aplicativo = new Aplicativo();
        aplicativo.setNome("App Pro");
        aplicativo.setCustoMensal(19.99);
        aplicativo = aplicativoRepository.save(aplicativo);

        assinatura1 = new Assinatura();
        assinatura1.setCliente(cliente);
        assinatura1.setAplicativo(aplicativo);
        assinatura1.setInicioVigencia(new Date());
        assinatura1.setFimVigencia(new Date());

        assinatura2 = new Assinatura();
        assinatura2.setCliente(cliente);
        assinatura2.setAplicativo(aplicativo);
        assinatura2.setInicioVigencia(new Date());
        assinatura2.setFimVigencia(new Date());

        assinaturaRepository.save(assinatura1);
        assinaturaRepository.save(assinatura2);
    }

    @Test
    void testFindAll() {
        List<Assinatura> assinaturas = assinaturaRepository.findAll();

        assertEquals(2, assinaturas.size());
    }

    @Test
    void testFindById() {
        Optional<Assinatura> assinatura = assinaturaRepository.findById(assinatura1.getId());

        assertTrue(assinatura.isPresent());
    }

    @Test
    void testSave() {
        Assinatura assinatura3 = new Assinatura();
        assinatura3.setCliente(cliente);
        assinatura3.setAplicativo(aplicativo);
        assinatura3.setInicioVigencia(new Date());
        assinatura3.setFimVigencia(new Date());

        Assinatura savedAssinatura = assinaturaRepository.save(assinatura3);

        assertNotNull(savedAssinatura);
    }

    @Test
    void testDeleteById() {
        assinaturaRepository.deleteById(assinatura1.getId());

        Optional<Assinatura> assinatura = assinaturaRepository.findById(assinatura1.getId());

        assertFalse(assinatura.isPresent());
    }
}
