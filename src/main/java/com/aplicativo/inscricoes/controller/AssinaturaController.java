package com.aplicativo.inscricoes.controller;

import com.aplicativo.inscricoes.dto.AssinaturaResponseDTO;
import com.aplicativo.inscricoes.entidades.Assinatura;
import com.aplicativo.inscricoes.repository.*;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/assinaturas")
public class AssinaturaController {
    private AssinaturaRepository assinaturaRepository;

    public AssinaturaController(AssinaturaRepository assinaturaRepository) {
        this.assinaturaRepository = assinaturaRepository;
    }

    @GetMapping("")
    public String getMensagemInicial() {
        return "Central Dados Assinatura";
    }

    @GetMapping("/getId")
    public Long getId() {
        return assinaturaRepository.findAll().getFirst().getId();
    }

    @GetMapping("/getApp")
    public Long getApp() {
        return assinaturaRepository.findAll().getFirst().getAplicativo().getId();
    }

    @GetMapping("/getCli")
    public Long getCli() {
        return assinaturaRepository.findAll().getFirst().getCliente().getId();
    }

    /*@GetMapping("/assinaturas/{tipo}")
    public ResponseEntity<List<AssinaturaResponseDTO>> getAssinaturasPorTipo(@PathVariable String tipo) {
        List<Assinatura> assinaturas = assinaturaRepository.findAll();
        List<AssinaturaResponseDTO> response = assinaturas.stream()
                            .filter(a -> "TODAS".equalsIgnoreCase(tipo) 
                             ("ATIVAS".equalsIgnoreCase(tipo) && a.getFimVigencia().isAfter(LocalDate.now()) 
                             ("CANCELADAS".equalsIgnoreCase(tipo) && a.getFimVigencia().isBefore(LocalDate.now())))
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }*/
}
