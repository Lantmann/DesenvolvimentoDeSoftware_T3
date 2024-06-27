package com.suaempresa.subscriptions.service;

import com.suaempresa.subscriptions.model.Cliente;
import com.suaempresa.subscriptions.repository.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    private Cliente cliente1;
    private Cliente cliente2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        cliente1 = new Cliente();
        cliente1.setId(1L);
        cliente1.setNome("John Doe");
        cliente1.setEmail("john.doe@example.com");

        cliente2 = new Cliente();
        cliente2.setId(2L);
        cliente2.setNome("Jane Doe");
        cliente2.setEmail("jane.doe@example.com");
    }

    @Test
    void testFindAll() {
        when(clienteRepository.findAll()).thenReturn(Arrays.asList(cliente1, cliente2));

        List<Cliente> clientes = clienteService.findAll();

        assertEquals(2, clientes.size());
        verify(clienteRepository, times(1)).findAll();
    }

    @Test
    void testFindById() {
        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente1));

        Optional<Cliente> cliente = clienteService.findById(1L);

        assertTrue(cliente.isPresent());
        assertEquals("John Doe", cliente.get().getNome());
        verify(clienteRepository, times(1)).findById(1L);
    }

    @Test
    void testSave() {
        when(clienteRepository.save(cliente1)).thenReturn(cliente1);

        Cliente savedCliente = clienteService.save(cliente1);

        assertNotNull(savedCliente);
        assertEquals("John Doe", savedCliente.getNome());
        verify(clienteRepository, times(1)).save(cliente1);
    }

    @Test
    void testDeleteById() {
        doNothing().when(clienteRepository).deleteById(1L);

        clienteService.deleteById(1L);

        verify(clienteRepository, times(1)).deleteById(1L);
    }
}
