package com.aplicativo.inscricoes.controller;

import com.aplicativo.inscricoes.repository.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    private ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping("")
    public String getMensagemInicial() {
        return "Central Dados Cliente";
    }

    @GetMapping("/getNome")
    public String getAll() {
        return clienteRepository.findAll().getFirst().getNome();
    }
    
}
