package com.ia.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.ia.spring")
public class LogisticaSpring {

	public static void main(String[] args) {
		SpringApplication.run(LogisticaSpring.class, args);
	}
	
}
