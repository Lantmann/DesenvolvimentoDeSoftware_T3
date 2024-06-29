package com.aplicativo.inscricoes.controller;

import com.aplicativo.inscricoes.repository.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/aplicativo")
public class AplicativoController {
    private AplicativoRepository aplicativoRepository;

    public AplicativoController(AplicativoRepository aplicativoRepository) {
        this.aplicativoRepository = aplicativoRepository;
    }

    @GetMapping("/getNome")
    public String getAllNome() {
        return aplicativoRepository.findAll().getFirst().getNome();
    }

    @GetMapping("")
    public String getMensagemInicial() {
        return "Aplicacao Spring-Boot funcionando!";
    }

    @GetMapping("/getcustoMensal")
    public Float getAllCustoMensal() {
        return aplicativoRepository.findAll().getFirst().getCustoMensal();
    }

    @GetMapping("/getId")
    public Long getAllId() {
        return aplicativoRepository.findAll().getFirst().getId();
    }
    
}
