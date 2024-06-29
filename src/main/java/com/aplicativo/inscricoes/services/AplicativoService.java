package com.aplicativo.inscricoes.services;

import com.aplicativo.inscricoes.entidades.Aplicativo;
import com.aplicativo.inscricoes.repository.AplicativoRepository;

import java.lang.reflect.Field;
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

    public String allNome(){
        List<Aplicativo> aplicativos = aplicativoRepository.findAll();

        String nomes = aplicativos.stream()
                    .map(aplicativo -> String.valueOf(aplicativo.getNome()))
                    .collect(Collectors.joining("; "));
        return nomes;
    }

    public String allCusto(){
        List<Aplicativo> aplicativos = aplicativoRepository.findAll();

        String custo = aplicativos.stream()
                    .map(aplicativo -> Float.toString(aplicativo.getCustoMensal()))
                    .collect(Collectors.joining("; "));
        return custo;
    }

    public String getAll() {
        List<Aplicativo> aplicativos = aplicativoRepository.findAll();
        return aplicativos.stream()
                .map(this::entidadeParaString)
                .collect(Collectors.joining("\n"));
    }

    private String entidadeParaString(Aplicativo aplicativo) {
        StringBuilder sb = new StringBuilder();
        Field[] fields = aplicativo.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true); // Necessário para acessar campos privados
            try {
                sb.append(field.get(aplicativo)).append(" ");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        // Remove o último espaço extra
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }
}
