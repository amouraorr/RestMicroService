package br.com.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration//permitir que o contexte contet do sprig seja carregado baseado nos jars, depois que os
						// já foram registrado no application content
@ComponentScan// escanea os pacote e encontra os arquivos de configuração
public class GreetingApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreetingApplication.class, args);
		

	}

}
