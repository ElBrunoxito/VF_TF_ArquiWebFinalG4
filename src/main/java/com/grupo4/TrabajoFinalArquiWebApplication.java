package com.grupo4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication (exclude = { SecurityAutoConfiguration.class})
public class TrabajoFinalArquiWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrabajoFinalArquiWebApplication.class, args);
	}

}
