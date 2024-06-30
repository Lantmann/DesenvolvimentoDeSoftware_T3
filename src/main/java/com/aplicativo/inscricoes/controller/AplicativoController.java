package com.aplicativo.inscricoes.controller;

import com.aplicativo.inscricoes.entidades.Aplicativo;
import com.aplicativo.inscricoes.repository.*;
import com.aplicativo.inscricoes.services.AplicativoService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/aplicativo")
public class AplicativoController {
    private AplicativoRepository aplicativoRepository;

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

    @PutMapping("/atualizacusto/{idAplicativo}")
    public ResponseEntity<Aplicativo> atualizarCustoAplicativo(@PathVariable Long idAplicativo, @RequestBody Map<String, Float> body) {
        float novoCusto = body.get("custo");

        Aplicativo aplicativo = aplicativoRepository.findById(idAplicativo).get();
        if (aplicativo != null) {
            aplicativo.setCustoMensal(novoCusto);
            aplicativoRepository.save(aplicativo);
            return ResponseEntity.ok(aplicativo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
