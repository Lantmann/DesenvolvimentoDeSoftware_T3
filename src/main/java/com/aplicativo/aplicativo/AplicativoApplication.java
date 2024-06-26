package com.aplicativo.aplicativo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.aplicativo.aplicativo.dbFinder;
import com.aplicativo.aplicativo.h2bd;

@SpringBootApplication
public class AplicativoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AplicativoApplication.class, args);
		h2bd.iniciaBD();
	}

}
