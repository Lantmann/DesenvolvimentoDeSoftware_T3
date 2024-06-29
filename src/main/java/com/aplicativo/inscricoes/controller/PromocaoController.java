package com.aplicativo.inscricoes.controller;

import com.aplicativo.inscricoes.repository.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/promocao")
public class PromocaoController {

    private final PromocaoRepository promocaoRepository;

    public PromocaoController(PromocaoRepository promocaoRepository) {
        this.promocaoRepository = promocaoRepository;
    }
    @GetMapping("")
    public String getMensagemInicial() {
        return "Central Dados Promocao";
    }

    @GetMapping("/getNome")
    public String getAll() {
        return promocaoRepository.findAll().getFirst().getNome();
    }
}
