package com.aplicativo.inscricoes.controller;

import com.aplicativo.inscricoes.entidades.Assinatura;
import com.aplicativo.inscricoes.repository.*;
import com.aplicativo.inscricoes.services.AssinaturaService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/assinaturas")
public class AssinaturaController {
    private AssinaturaRepository assinaturaRepository;

    @Autowired
    private AssinaturaService assinaturaService;

    public AssinaturaController(AssinaturaRepository assinaturaRepository) {
        this.assinaturaRepository = assinaturaRepository;
    }

    @GetMapping("/assinaturas/{tipo}")
    public List<Assinatura> getAssinaturasPorTipo(@PathVariable String tipo) {
        return assinaturaService.getAssinaturasPorTipo(tipo);
    }

    
    

    /*
    @PostMapping("/assinaturas")
    public String postMethodName(@RequestBody String entity) {
        //TODO: process POST request
        
        return entity;
    }*/
    
}
