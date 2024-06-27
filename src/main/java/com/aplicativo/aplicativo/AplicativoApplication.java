package com.aplicativo.aplicativo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.aplicativo.aplicativo.dbFinder;
import com.aplicativo.aplicativo.h2bd;
import com.aplicativo.aplicativo.dbWriter;

@SpringBootApplication
public class AplicativoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AplicativoApplication.class, args);
		h2bd.iniciaBD();
		dbWriter.criaCliente(2222, "Gabriel", "gabriel@email.com");
		dbWriter.criaAplicativo(3333, "GenericApp", 15.99);
		System.out.println(dbFinder.select("Cliente", "nome, email"));
		System.out.println(dbFinder.select("Aplicativo", "codigo, nome, custoMensal"));
	}

}
