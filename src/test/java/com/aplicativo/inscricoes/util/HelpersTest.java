package com.suaempresa.subscriptions.util;

import com.suaempresa.subscriptions.dto.ClienteDTO;
import com.suaempresa.subscriptions.model.Cliente;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelpersTest {

    @Test
    void testConvertToClienteDTO() {
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNome("John Doe");
        cliente.setEmail("john.doe@example.com");

        ClienteDTO clienteDTO = Helpers.convertToClienteDTO(cliente);

        assertNotNull(clienteDTO);
        assertEquals(1L, clienteDTO.getId());
        assertEquals("John Doe", clienteDTO.getNome());
        assertEquals("john.doe@example.com", clienteDTO.getEmail());
    }

    @Test
    void testConvertToClienteEntity() {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(1L);
        clienteDTO.setNome("John Doe");
        clienteDTO.setEmail("john.doe@example.com");

        Cliente cliente = Helpers.convertToClienteEntity(clienteDTO);

        assertNotNull(cliente);
        assertEquals(1L, cliente.getId());
        assertEquals("John Doe", cliente.getNome());
        assertEquals("john.doe@example.com", cliente.getEmail());
    }

    @Test
    void testIsDateInFuture() {
        java.util.Date futureDate = new java.util.Date(System.currentTimeMillis() + 86400000); // 1 day in the future
        java.util.Date pastDate = new java.util.Date(System.currentTimeMillis() - 86400000); // 1 day in the past

        assertTrue(Helpers.isDateInFuture(futureDate));
        assertFalse(Helpers.isDateInFuture(pastDate));
    }

    @Test
    void testIsValidEmail() {
        assertTrue(Helpers.isValidEmail("test@example.com"));
        assertFalse(Helpers.isValidEmail("invalid-email"));
        assertFalse(Helpers.isValidEmail("invalid@.com"));
    }

    @Test
    void testIsValueWithinRange() {
        assertTrue(Helpers.isValueWithinRange(10.0, 0.0, 20.0));
        assertFalse(Helpers.isValueWithinRange(25.0, 0.0, 20.0));
        assertFalse(Helpers.isValueWithinRange(-5.0, 0.0, 20.0));
    }
}
