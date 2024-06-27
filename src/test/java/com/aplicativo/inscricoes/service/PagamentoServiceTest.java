package com.suaempresa.subscriptions.service;

import com.suaempresa.subscriptions.model.Pagamento;
import com.suaempresa.subscriptions.repository.PagamentoRepository;
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

class PagamentoServiceTest {

    @Mock
    private PagamentoRepository pagamentoRepository;

    @InjectMocks
    private PagamentoService pagamentoService;

    private Pagamento pagamento1;
    private Pagamento pagamento2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        pagamento1 = new Pagamento();
        pagamento1.setId(1L);
        pagamento1.setValorPago(100.0);

        pagamento2 = new Pagamento();
        pagamento2.setId(2L);
        pagamento2.setValorPago(200.0);
    }

    @Test
    void testFindAll() {
        when(pagamentoRepository.findAll()).thenReturn(Arrays.asList(pagamento1, pagamento2));

        List<Pagamento> pagamentos = pagamentoService.findAll();

        assertEquals(2, pagamentos.size());
        verify(pagamentoRepository, times(1)).findAll();
    }

    @Test
    void testFindById() {
        when(pagamentoRepository.findById(1L)).thenReturn(Optional.of(pagamento1));

        Optional<Pagamento> pagamento = pagamentoService.findById(1L);

        assertTrue(pagamento.isPresent());
        assertEquals(100.0, pagamento.get().getValorPago());
        verify(pagamentoRepository, times(1)).findById(1L);
    }

    @Test
    void testSave() {
        when(pagamentoRepository.save(pagamento1)).thenReturn(pagamento1);

        Pagamento savedPagamento = pagamentoService.save(pagamento1);

        assertNotNull(savedPagamento);
        assertEquals(100.0, savedPagamento.getValorPago());
        verify(pagamentoRepository, times(1)).save(pagamento1);
    }

    @Test
    void testDeleteById() {
        doNothing().when(pagamentoRepository).deleteById(1L);

        pagamentoService.deleteById(1L);

        verify(pagamentoRepository, times(1)).deleteById(1L);
    }
}
