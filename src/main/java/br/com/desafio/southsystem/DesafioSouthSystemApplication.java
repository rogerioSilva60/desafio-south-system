package br.com.desafio.southsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class DesafioSouthSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioSouthSystemApplication.class, args);
	}

}
