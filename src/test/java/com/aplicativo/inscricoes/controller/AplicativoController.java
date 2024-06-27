package com.aplicativo.inscricoes.controller;

import com.aplicativo.inscricoes.entidades.Aplicativo;
import com.aplicativo.inscricoes.service.AplicativoService;
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

class AplicativoControllerTest {

    @Mock
    private AplicativoService aplicativoService;

    @InjectMocks
    private AplicativoController aplicativoController;

    private MockMvc mockMvc;

    private Aplicativo aplicativo1;
    private Aplicativo aplicativo2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(aplicativoController).build();

        aplicativo1 = new Aplicativo();
        aplicativo1.setId(1L);
        aplicativo1.setNome("App Pro");
        aplicativo1.setCustoMensal(19.99);

        aplicativo2 = new Aplicativo();
        aplicativo2.setId(2L);
        aplicativo2.setNome("App Basic");
        aplicativo2.setCustoMensal(9.99);
    }

    @Test
    void testGetAllAplicativos() throws Exception {
        when(aplicativoService.findAll()).thenReturn(Arrays.asList(aplicativo1, aplicativo2));

        mockMvc.perform(get("/api/aplicativos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nome").value("App Pro"))
                .andExpect(jsonPath("$[1].nome").value("App Basic"));

        verify(aplicativoService, times(1)).findAll();
    }

    @Test
    void testGetAplicativoById() throws Exception {
        when(aplicativoService.findById(1L)).thenReturn(Optional.of(aplicativo1));

        mockMvc.perform(get("/api/aplicativos/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("App Pro"));

        verify(aplicativoService, times(1)).findById(1L);
    }

    @Test
    void testCreateAplicativo() throws Exception {
        when(aplicativoService.save(any(Aplicativo.class))).thenReturn(aplicativo1);

        mockMvc.perform(post("/api/aplicativos")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"nome\":\"App Pro\",\"custoMensal\":19.99}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("App Pro"));

        verify(aplicativoService, times(1)).save(any(Aplicativo.class));
    }

    @Test
    void testUpdateAplicativo() throws Exception {
        when(aplicativoService.findById(1L)).thenReturn(Optional.of(aplicativo1));
        when(aplicativoService.save(any(Aplicativo.class))).thenReturn(aplicativo1);

        mockMvc.perform(put("/api/aplicativos/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"nome\":\"App Pro\",\"custoMensal\":19.99}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("App Pro"));

        verify(aplicativoService, times(1)).save(any(Aplicativo.class));
    }

    @Test
    void testDeleteAplicativo() throws Exception {
        doNothing().when(aplicativoService).deleteById(1L);

        mockMvc.perform(delete("/api/aplicativos/1"))
                .andExpect(status().isOk());

        verify(aplicativoService, times(1)).deleteById(1L);
    }
}
