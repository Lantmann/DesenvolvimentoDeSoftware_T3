package com.suaempresa.subscriptions.repository;

import com.suaempresa.subscriptions.model.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ClienteRepositoryTest {

    @Autowired
    private ClienteRepository clienteRepository;

    private Cliente cliente1;
    private Cliente cliente2;

    @BeforeEach
    void setUp() {
        cliente1 = new Cliente();
        cliente1.setNome("John Doe");
        cliente1.setEmail("john.doe@example.com");

        cliente2 = new Cliente();
        cliente2.setNome("Jane Doe");
        cliente2.setEmail("jane.doe@example.com");

        clienteRepository.save(cliente1);
        clienteRepository.save(cliente2);
    }

    @Test
    void testFindAll() {
        List<Cliente> clientes = clienteRepository.findAll();

        assertEquals(2, clientes.size());
    }

    @Test
    void testFindById() {
        Optional<Cliente> cliente = clienteRepository.findById(cliente1.getId());

        assertTrue(cliente.isPresent());
        assertEquals("John Doe", cliente.get().getNome());
    }

    @Test
    void testSave() {
        Cliente cliente3 = new Cliente();
        cliente3.setNome("Carlos Silva");
        cliente3.setEmail("carlos.silva@example.com");

        Cliente savedCliente = clienteRepository.save(cliente3);

        assertNotNull(savedCliente);
        assertEquals("Carlos Silva", savedCliente.getNome());
    }

    @Test
    void testDeleteById() {
        clienteRepository.deleteById(cliente1.getId());

        Optional<Cliente> cliente = clienteRepository.findById(cliente1.getId());

        assertFalse(cliente.isPresent());
    }

    @Test
    void testFindByEmail() {
        Cliente cliente = clienteRepository.findByEmail("jane.doe@example.com");

        assertNotNull(cliente);
        assertEquals("Jane Doe", cliente.getNome());
    }
}
