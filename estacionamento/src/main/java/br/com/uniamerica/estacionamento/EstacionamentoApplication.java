package br.com.uniamerica.estacionamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(value = "http://localhost:8080/", allowedHeaders = "*")
@SpringBootApplication
public class EstacionamentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstacionamentoApplication.class, args);
	}

}
