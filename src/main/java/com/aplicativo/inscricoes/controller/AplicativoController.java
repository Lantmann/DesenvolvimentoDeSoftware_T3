package com.aplicativo.inscricoes.controller;

import com.aplicativo.inscricoes.entidades.Aplicativo;
import com.aplicativo.inscricoes.entidades.Cliente;
import com.aplicativo.inscricoes.repository.*;
import com.aplicativo.inscricoes.services.AplicativoService;
import com.aplicativo.inscricoes.services.AssinaturaService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

 
@RestController
@RequestMapping("/api/aplicativo")
public class AplicativoController {
    private AplicativoRepository aplicativoRepository;

    @Autowired
    private AssinaturaService assinaturaService;

    @Autowired
    private AplicativoService aplicativoService;

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

    @GetMapping("/getAllId")
    public String getAllId() {
        return aplicativoService.allId();
    }

    @GetMapping("/teste")
    public String getApp() {
        Long id = Long.valueOf(String.valueOf(5432));
        Aplicativo novo = new Aplicativo(5432, "AppNovo", 20.99f);
        aplicativoService.create(novo);
        Aplicativo editado = new Aplicativo(0000, "AppEditado", 20.99f);
        aplicativoService.update(id, editado);
        return aplicativoRepository.findById(id).get().getNome();
    }

    @GetMapping("/getAll")
    public String getMethodName() {
        return aplicativoService.getAllCampos();
    }
    
    @GetMapping("/aplicativos")
    public List<Aplicativo> getAllAplicativos() {
        return aplicativoService.getAll();
    }


    @GetMapping("/{codigoAplicativo}/assinantes")
    public List<Cliente> listarAssinantes(@PathVariable Long codigoAplicativo) {
        return assinaturaService.listarAssinantesPorAplicativo(codigoAplicativo);
    }
    

    

}


