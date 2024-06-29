package com.aplicativo.inscricoes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages={"com.aplicativo.inscricoes"})
public class TfAplicativo {
    
    public static void main(String[] args) {
        SpringApplication.run(TfAplicativo.class, args);
    }
}
