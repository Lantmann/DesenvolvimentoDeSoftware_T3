package com.aplicativo.inscricoes.controller;

import com.aplicativo.inscricoes.repository.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("")
    public String getMensagemInicial() {
        return "Central Dados Usuario";
    }

    @GetMapping("/getNome")
    public String getAll() {
        return usuarioRepository.findAll().getFirst().getNome();
    }
    
}
