package com.aplicativo.inscricoes.controller;

import com.aplicativo.inscricoes.repository.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

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
}
