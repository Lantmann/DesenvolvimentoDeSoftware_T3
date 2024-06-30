package com.aplicativo.inscricoes.controller;

import com.aplicativo.inscricoes.repository.*;
import com.aplicativo.inscricoes.services.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService; 

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
    
    @PostMapping("/usuValido")
    public boolean isUsuarioValido(@RequestBody String identificador) {
        if(usuarioService.findByNome(identificador) != null){return true;}
        return false;
    }

    
}
