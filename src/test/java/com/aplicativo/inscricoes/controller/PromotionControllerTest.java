package com.aplicativo.inscricoes.controller;

import com.aplicativo.inscricoes.entidades.Promocao;
import com.aplicativo.inscricoes.service.PromotionService;
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

class PromotionControllerTest {

    @Mock
    private PromotionService promotionService;

    @InjectMocks
    private PromotionController promotionController;

    private MockMvc mockMvc;

    private Promocao promocao1;
    private Promocao promocao2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(promotionController).build();

        promocao1 = new Promocao();
        promocao1.setId(1L);
        promocao1.setDescricao("Promo Verão");
        promocao1.setDesconto(15.0);

        promocao2 = new Promocao();
        promocao2.setId(2L);
        promocao2.setDescricao("Promoção de Natal");
        promocao2.setDesconto(30.0);
    }

    @Test
    void testGetAllPromocoes() throws Exception {
        when(promotionService.findAll()).thenReturn(Arrays.asList(promocao1, promocao2));

        mockMvc.perform(get("/api/promocoes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].descricao").value("Promo Verão"))
                .andExpect(jsonPath("$[1].descricao").value("Promoção de Natal"));

        verify(promotionService, times(1)).findAll();
    }

    @Test
    void testGetPromocaoById() throws Exception {
        when(promotionService.findById(1L)).thenReturn(Optional.of(promocao1));

        mockMvc.perform(get("/api/promocoes/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.descricao").value("Promo Verão"));

        verify(promotionService, times(1)).findById(1L);
    }

    @Test
    void testCreatePromocao() throws Exception {
        when(promotionService.save(any(Promocao.class))).thenReturn(promocao1);

        mockMvc.perform(post("/api/promocoes")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"descricao\":\"Promo Verão\",\"desconto\":15.0}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.descricao").value("Promo Verão"));

        verify(promotionService, times(1)).save(any(Promocao.class));
    }

    @Test
    void testUpdatePromocao() throws Exception {
        when(promotionService.findById(1L)).thenReturn(Optional.of(promocao1));
        when(promotionService.save(any(Promocao.class))).thenReturn(promocao1);

        mockMvc.perform(put("/api/promocoes/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"descricao\":\"Promo Verão\",\"desconto\":15.0}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.descricao").value("Promo Verão"));

        verify(promotionService, times(1)).save(any(Promocao.class));
    }

    @Test
    void testDeletePromocao() throws Exception {
        doNothing().when(promotionService).deleteById(1L);

        mockMvc.perform(delete("/api/promocoes/1"))
                .andExpect(status().isOk());

        verify(promotionService, times(1)).deleteById(1L);
    }
}
