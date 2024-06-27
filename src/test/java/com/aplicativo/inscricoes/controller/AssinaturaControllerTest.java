package com.suaempresa.subscriptions.controller;

import com.suaempresa.subscriptions.model.Assinatura;
import com.suaempresa.subscriptions.service.AssinaturaService;
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

class AssinaturaControllerTest {

    @Mock
    private AssinaturaService assinaturaService;

    @InjectMocks
    private AssinaturaController assinaturaController;

    private MockMvc mockMvc;

    private Assinatura assinatura1;
    private Assinatura assinatura2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(assinaturaController).build();

        assinatura1 = new Assinatura();
        assinatura1.setId(1L);
        assinatura1.setInicioVigencia(new java.util.Date());
        assinatura1.setFimVigencia(new java.util.Date());

        assinatura2 = new Assinatura();
        assinatura2.setId(2L);
        assinatura2.setInicioVigencia(new java.util.Date());
        assinatura2.setFimVigencia(new java.util.Date());
    }

    @Test
    void testGetAllAssinaturas() throws Exception {
        when(assinaturaService.findAll()).thenReturn(Arrays.asList(assinatura1, assinatura2));

        mockMvc.perform(get("/api/assinaturas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[1].id").value(2L));

        verify(assinaturaService, times(1)).findAll();
    }

    @Test
    void testGetAssinaturaById() throws Exception {
        when(assinaturaService.findById(1L)).thenReturn(Optional.of(assinatura1));

        mockMvc.perform(get("/api/assinaturas/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L));

        verify(assinaturaService, times(1)).findById(1L);
    }

    @Test
    void testCreateAssinatura() throws Exception {
        when(assinaturaService.save(any(Assinatura.class))).thenReturn(assinatura1);

        mockMvc.perform(post("/api/assinaturas")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"clienteId\":1,\"aplicativoId\":1,\"inicioVigencia\":\"2023-01-01\",\"fimVigencia\":\"2024-01-01\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L));

        verify(assinaturaService, times(1)).save(any(Assinatura.class));
    }

    @Test
    void testUpdateAssinatura() throws Exception {
        when(assinaturaService.findById(1L)).thenReturn(Optional.of(assinatura1));
        when(assinaturaService.save(any(Assinatura.class))).thenReturn(assinatura1);

        mockMvc.perform(put("/api/assinaturas/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"clienteId\":1,\"aplicativoId\":1,\"inicioVigencia\":\"2023-01-01\",\"fimVigencia\":\"2024-01-01\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L));

        verify(assinaturaService, times(1)).save(any(Assinatura.class));
    }

    @Test
    void testDeleteAssinatura() throws Exception {
        doNothing().when(assinaturaService).deleteById(1L);

        mockMvc.perform(delete("/api/assinaturas/1"))
                .andExpect(status().isOk());

        verify(assinaturaService, times(1)).deleteById(1L);
    }
}
