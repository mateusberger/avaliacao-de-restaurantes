package com.avaliacaoderestaurantes.avaliacoesms.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestauranteService {

    @Autowired
    private RestTemplate restTemplate;

    @LoadBalanced
    @CircuitBreaker(name = "restauranteCircuitBreaker", fallbackMethod = "fallBackGetRestaurante")
    public RestauranteDto getRestaurante(Long restauranteId){

        ResponseEntity<RestauranteDto> restauranteResponse = restTemplate
                .getForEntity("http://restaurantes-ms/restaurante/" + restauranteId, RestauranteDto.class);

        if (restauranteResponse.getStatusCode() != HttpStatus.OK){

        }

        return restauranteResponse.getBody();
    }

    public RestauranteDto fallBackGetRestaurante(Long restauranteId, Throwable t){
        return new RestauranteService.RestauranteDto(restauranteId, "...");
    }

    @Schema(name = "Restaurante")
    public record RestauranteDto(
            Long id,
            String nome
    ){}
}
