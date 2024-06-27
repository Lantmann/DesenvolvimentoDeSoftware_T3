package com.suaempresa.subscriptions.service;

import com.suaempresa.subscriptions.model.Assinatura;
import com.suaempresa.subscriptions.repository.AssinaturaRepository;
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

class AssinaturaServiceTest {

    @Mock
    private AssinaturaRepository assinaturaRepository;

    @InjectMocks
    private AssinaturaService assinaturaService;

    private Assinatura assinatura1;
    private Assinatura assinatura2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        assinatura1 = new Assinatura();
        assinatura1.setId(1L);

        assinatura2 = new Assinatura();
        assinatura2.setId(2L);
    }

    @Test
    void testFindAll() {
        when(assinaturaRepository.findAll()).thenReturn(Arrays.asList(assinatura1, assinatura2));

        List<Assinatura> assinaturas = assinaturaService.findAll();

        assertEquals(2, assinaturas.size());
        verify(assinaturaRepository, times(1)).findAll();
    }

    @Test
    void testFindById() {
        when(assinaturaRepository.findById(1L)).thenReturn(Optional.of(assinatura1));

        Optional<Assinatura> assinatura = assinaturaService.findById(1L);

        assertTrue(assinatura.isPresent());
        assertEquals(1L, assinatura.get().getId());
        verify(assinaturaRepository, times(1)).findById(1L);
    }

    @Test
    void testSave() {
        when(assinaturaRepository.save(assinatura1)).thenReturn(assinatura1);

        Assinatura savedAssinatura = assinaturaService.save(assinatura1);

        assertNotNull(savedAssinatura);
        assertEquals(1L, savedAssinatura.getId());
        verify(assinaturaRepository, times(1)).save(assinatura1);
    }

    @Test
    void testDeleteById() {
        doNothing().when(assinaturaRepository).deleteById(1L);

        assinaturaService.deleteById(1L);

        verify(assinaturaRepository, times(1)).deleteById(1L);
    }
}
