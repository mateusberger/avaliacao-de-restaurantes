package com.avaliacaoderestaurantes.avaliacoesms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AvaliacoesMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AvaliacoesMsApplication.class, args);
	}

}
