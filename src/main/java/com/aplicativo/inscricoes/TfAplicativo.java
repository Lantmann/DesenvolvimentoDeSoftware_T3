package com.aplicativo.inscricoes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe principal que inicia a aplicação Spring Boot.
 */
@SpringBootApplication  // Indica que esta é uma classe de configuração que inicia uma aplicação Spring Boot
public class TfAplicativo {

    /**
     * Método principal que inicia a aplicação Spring Boot.
     * @param args argumentos da linha de comando
     */
    public static void main(String[] args) {
        SpringApplication.run(TfAplicativo.class, args);  // Inicia a aplicação Spring Boot
    }
}
