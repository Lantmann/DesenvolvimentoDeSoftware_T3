package com.aplicativo.inscricoes.controller;

import com.aplicativo.inscricoes.dto.AssinaturaDTO;
import com.aplicativo.inscricoes.entidades.Assinatura;
import com.aplicativo.inscricoes.repository.AssinaturaRepository;
import com.aplicativo.inscricoes.util.Helpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/assinaturas")
public class AssinaturaController {

    @Autowired
    private AssinaturaRepository assinaturaRepository;

    @GetMapping
    public List<AssinaturaDTO> getAllAssinaturas() {
        return assinaturaRepository.findAll().stream()
                .map(Helpers::convertToAssinaturaDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public AssinaturaDTO createAssinatura(@RequestBody AssinaturaDTO assinaturaDTO) {
        Assinatura assinatura = Helpers.convertToAssinaturaEntity(assinaturaDTO);
        assinatura = assinaturaRepository.save(assinatura);
        return Helpers.convertToAssinaturaDTO(assinatura);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssinaturaDTO> getAssinaturaById(@PathVariable Long id) {
        return assinaturaRepository.findById(id)
                .map(assinatura -> ResponseEntity.ok(Helpers.convertToAssinaturaDTO(assinatura)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AssinaturaDTO> updateAssinatura(@PathVariable Long id, @RequestBody AssinaturaDTO assinaturaDTO) {
        return assinaturaRepository.findById(id).map(existingAssinatura -> {
            existingAssinatura.setClienteId(assinaturaDTO.getClienteId());
            existingAssinatura.setAplicativoId(assinaturaDTO.getAplicativoId());
            existingAssinatura.setInicioVigencia(assinaturaDTO.getInicioVigencia());
            existingAssinatura.setFimVigencia(assinaturaDTO.getFimVigencia());
            assinaturaRepository.save(existingAssinatura);
            return ResponseEntity.ok(Helpers.convertToAssinaturaDTO(existingAssinatura));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAssinatura(@PathVariable Long id) {
        return assinaturaRepository.findById(id).map(assinatura -> {
            assinaturaRepository.delete(assinatura);
            return ResponseEntity.ok().<Void>build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
