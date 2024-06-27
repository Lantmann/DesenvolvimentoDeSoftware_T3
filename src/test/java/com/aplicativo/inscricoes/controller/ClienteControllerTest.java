package com.suaempresa.subscriptions.controller;

import com.suaempresa.subscriptions.model.Cliente;
import com.suaempresa.subscriptions.service.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class ClienteControllerTest {

    @Mock
    private ClienteService clienteService;

    @InjectMocks
    private ClienteController clienteController;

    private MockMvc mockMvc;

    private Cliente cliente1;
    private Cliente cliente2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(clienteController).build();
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
    void testGetAllClientes() throws Exception {
        when(clienteService.findAll()).thenReturn(Arrays.asList(cliente1, cliente2));

        mockMvc.perform(get("/api/clientes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nome").value("John Doe"))
                .andExpect(jsonPath("$[1].nome").value("Jane Doe"));

        verify(clienteService, times(1)).findAll();
    }

    @Test
    void testGetClienteById() throws Exception {
        when(clienteService.findById(1L)).thenReturn(Optional.of(cliente1));

        mockMvc.perform(get("/api/clientes/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("John Doe"));

        verify(clienteService, times(1)).findById(1L);
    }

    @Test
    void testCreateCliente() throws Exception {
        when(clienteService.save(any(Cliente.class))).thenReturn(cliente1);

        mockMvc.perform(post("/api/clientes")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"nome\":\"John Doe\",\"email\":\"john.doe@example.com\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("John Doe"));

        verify(clienteService, times(1)).save(any(Cliente.class));
    }

    @Test
    void testDeleteCliente() throws Exception {
        doNothing().when(clienteService).deleteById(1L);

        mockMvc.perform(delete("/api/clientes/1"))
                .andExpect(status().isOk());

        verify(clienteService, times(1)).deleteById(1L);
    }
}

