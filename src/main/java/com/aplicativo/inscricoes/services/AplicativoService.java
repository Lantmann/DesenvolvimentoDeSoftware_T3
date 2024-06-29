package com.aplicativo.inscricoes.services;

import com.aplicativo.inscricoes.entidades.Aplicativo;
import com.aplicativo.inscricoes.repository.AplicativoRepository;

import java.lang.reflect.Array;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AplicativoService {

    @Autowired
    private AplicativoRepository aplicativoRepository;

    public Aplicativo create(Aplicativo aplicativo){
        return aplicativoRepository.save(aplicativo);
    }

    public Aplicativo update(Long id, Aplicativo alteracoes){
        Aplicativo aplicativo = aplicativoRepository.findById(id).orElse(null);
        if(aplicativo!=null){
            aplicativo.setNome(alteracoes.getNome());
            aplicativo.setCustoMensal(alteracoes.getCustoMensal());
        }
        return null;
    }

    public String allId(){
        List<Aplicativo> aplicativos = aplicativoRepository.findAll();

        String ids = aplicativos.stream()
                    .map(aplicativo -> String.valueOf(aplicativo.getId()))
                    .collect(Collectors.joining("; "));
        return ids;
    }
}
