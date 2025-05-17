package com.example.gestionatelier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.example")
@EnableJpaRepositories(basePackages = "com.example.dao.repositories")
@EntityScan(basePackages = "com.example.dao.entities")
public class GestionAtelierApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionAtelierApplication.class, args);
	}

}
