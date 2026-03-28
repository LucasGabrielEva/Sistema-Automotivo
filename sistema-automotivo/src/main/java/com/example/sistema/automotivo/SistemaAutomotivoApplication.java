package com.example.sistema.automotivo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SistemaAutomotivoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaAutomotivoApplication.class, args);
	}

}
