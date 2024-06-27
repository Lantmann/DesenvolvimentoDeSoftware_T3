package com.aplicativo.inscricoes.service;

import com.aplicativo.inscricoes.entidades.Aplicativo;
import com.aplicativo.inscricoes.repository.AplicativoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AplicativoService {

    @Autowired
    private AplicativoRepository aplicativoRepository;

    public List<Aplicativo> findAll() {
        return aplicativoRepository.findAll();
    }

    public Optional<Aplicativo> findById(Long id) {
        return aplicativoRepository.findById(id);
    }

    public Aplicativo save(Aplicativo aplicativo) {
        return aplicativoRepository.save(aplicativo);
    }

    public void deleteById(Long id) {
        aplicativoRepository.deleteById(id);
    }

    public Aplicativo findByNome(String nome) {
        return aplicativoRepository.findByNome(nome);
    }
}
