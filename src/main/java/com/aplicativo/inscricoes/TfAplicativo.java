package com.aplicativo.inscricoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.aplicativo.inscricoes.entidades.Aplicativo;
import com.aplicativo.inscricoes.services.AplicativoService;

@SpringBootApplication
@EnableJpaRepositories(basePackages={"com.aplicativo.inscricoes"})
public class TfAplicativo {
    
    public static void main(String[] args) {
        SpringApplication.run(TfAplicativo.class, args);
        
    }
}
