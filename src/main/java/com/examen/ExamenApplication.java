package com.examen;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class ExamenApplication {

	@Value("${mensaje}")
	static String mensaje;
	
	public static void main(String[] args) {
		SpringApplication.run(ExamenApplication.class, args);
		
		
			System.out.println(mensaje);
		
	}

}
