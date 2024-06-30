package com.aplicativo.inscricoes.controller;

import com.aplicativo.inscricoes.entidades.Aplicativo;
import com.aplicativo.inscricoes.entidades.Assinatura;
import com.aplicativo.inscricoes.entidades.Cliente;
import com.aplicativo.inscricoes.repository.*;
import com.aplicativo.inscricoes.services.AplicativoService;
import com.aplicativo.inscricoes.services.AssinaturaService;
import com.aplicativo.inscricoes.services.ClienteService;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/assinatura")
public class AssinaturaController {
    private AssinaturaRepository assinaturaRepository;

    @Autowired
    private AssinaturaService assinaturaService;

    @Autowired
    private ClienteService clienteService; 

    @Autowired
    private AplicativoService aplicativoService;

    public AssinaturaController(AssinaturaRepository assinaturaRepository) {
        this.assinaturaRepository = assinaturaRepository;
    }

    @GetMapping("/{tipo}")
    public List<Assinatura> getAssinaturasPorTipo(@PathVariable String tipo) {
        return assinaturaService.getAssinaturasPorTipo(tipo);
    }
    
    @PostMapping("/nova")
    public Assinatura createAssinatura(@RequestBody Map<String, Long> request) {
        Long clienteId = request.get("codigoCliente");
        Long aplicativoId = request.get("codigoAplicativo");

        Optional<Cliente> cliente = Optional.of(clienteService.findById(clienteId));
        Optional<Aplicativo> aplicativo = Optional.of(aplicativoService.findById(aplicativoId));

        if (cliente.isPresent() && aplicativo.isPresent()) {
            Assinatura assinatura = new Assinatura();
            assinatura.setCliente(cliente.get());
            assinatura.setAplicativo(aplicativo.get());
            assinatura.setInicioVigencia(LocalDate.now());
            assinatura.setFimVigencia(null); // Assume that the subscription is active initially

            return assinaturaService.create(assinatura);
        } else {
            throw new RuntimeException("Cliente ou Aplicativo nÃ£o encontrado");
        }
    }

    @GetMapping("/cliente/{codcli}")
    public List<Assinatura> getAssinaturasPorCliente(@PathVariable Long codcli) {
        return assinaturaService.getAssinaturasPorCliente(codcli);
    }

    @GetMapping("/aplicativo/{codapp}")
    public List<Assinatura> getAssinaturasPorAplicativo(@PathVariable Long codapp) {
        return assinaturaService.getAssinaturasPorAplicativo(codapp);
    }

    @GetMapping("/valida/{codassin}")
        public ResponseEntity<Boolean> verificarAssinaturaAtiva(@PathVariable Long codassin) {
        Optional<Assinatura> optionalAssinatura = assinaturaRepository.findById(codassin);

        if (optionalAssinatura.isPresent()) {
            Assinatura assinatura = optionalAssinatura.get();
            LocalDate dataAtual = LocalDate.now();
            LocalDate fimVigencia = assinatura.getFimVigencia();

            boolean assinaturaAtiva = fimVigencia != null && fimVigencia.isAfter(dataAtual);

            return ResponseEntity.ok(assinaturaAtiva);
        }
        else{
            return ResponseEntity.notFound().build();
        }
}

}
