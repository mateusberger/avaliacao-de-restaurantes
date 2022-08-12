package com.avaliacaoderestaurantes.restaurantesms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RestaurantesMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantesMsApplication.class, args);
	}

}
