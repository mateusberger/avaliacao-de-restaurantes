package com.avaliacaoderestaurantes.usuariosms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UsuariosMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsuariosMsApplication.class, args);
	}

}
