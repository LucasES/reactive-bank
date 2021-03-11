package br.com.reactivebank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
public class ReactiveBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveBankApplication.class, args);
	}

}
