package com.aplicativo.inscricoes.controller;

import com.aplicativo.inscricoes.services.*;
import com.aplicativo.inscricoes.entidades.Cliente;
import com.aplicativo.inscricoes.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteService clienteService;

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

    @GetMapping("/clientes")
    public List<Cliente> getAllClientes() {
        return clienteService.getAll();
    }
}
