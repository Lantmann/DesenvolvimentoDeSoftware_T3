package com.aplicativo.inscricoes.controller;

import com.aplicativo.inscricoes.entidades.Pagamento;
import com.aplicativo.inscricoes.service.PagamentoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class PagamentoControllerTest {

    @Mock
    private PagamentoService pagamentoService;

    @InjectMocks
    private PagamentoController pagamentoController;

    private MockMvc mockMvc;

    private Pagamento pagamento1;
    private Pagamento pagamento2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(pagamentoController).build();

        pagamento1 = new Pagamento();
        pagamento1.setId(1L);
        pagamento1.setValorPago(100.0);
        pagamento1.setDataPagamento(new java.util.Date());

        pagamento2 = new Pagamento();
        pagamento2.setId(2L);
        pagamento2.setValorPago(200.0);
        pagamento2.setDataPagamento(new java.util.Date());
    }

    @Test
    void testGetAllPagamentos() throws Exception {
        when(pagamentoService.findAll()).thenReturn(Arrays.asList(pagamento1, pagamento2));

        mockMvc.perform(get("/api/pagamentos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[1].id").value(2L));

        verify(pagamentoService, times(1)).findAll();
    }

    @Test
    void testGetPagamentoById() throws Exception {
        when(pagamentoService.findById(1L)).thenReturn(Optional.of(pagamento1));

        mockMvc.perform(get("/api/pagamentos/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L));

        verify(pagamentoService, times(1)).findById(1L);
    }

    @Test
    void testCreatePagamento() throws Exception {
        when(pagamentoService.save(any(Pagamento.class))).thenReturn(pagamento1);

        mockMvc.perform(post("/api/pagamentos")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"assinaturaId\":1,\"valorPago\":100.0,\"dataPagamento\":\"2023-01-01\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L));

        verify(pagamentoService, times(1)).save(any(Pagamento.class));
    }

    @Test
    void testUpdatePagamento() throws Exception {
        when(pagamentoService.findById(1L)).thenReturn(Optional.of(pagamento1));
        when(pagamentoService.save(any(Pagamento.class))).thenReturn(pagamento1);

        mockMvc.perform(put("/api/pagamentos/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"assinaturaId\":1,\"valorPago\":150.0,\"dataPagamento\":\"2023-01-01\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L));

        verify(pagamentoService, times(1)).save(any(Pagamento.class));
    }

    @Test
    void testDeletePagamento() throws Exception {
        doNothing().when(pagamentoService).deleteById(1L);

        mockMvc.perform(delete("/api/pagamentos/1"))
                .andExpect(status().isOk());

        verify(pagamentoService, times(1)).deleteById(1L);
    }
}
