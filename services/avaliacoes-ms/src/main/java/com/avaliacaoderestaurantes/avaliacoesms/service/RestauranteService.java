package com.avaliacaoderestaurantes.avaliacoesms.service;

import com.avaliacaoderestaurantes.avaliacoesms.http.RestauranteHttpInterface;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;

@Service
public class RestauranteService {

    @Autowired
    private RestauranteHttpInterface restauranteHttpInterface;

    @LoadBalanced
    @CircuitBreaker(name = "restauranteCircuitBreaker", fallbackMethod = "fallBackGetRestaurante")
    public RestauranteDto getRestaurante(Long restauranteId){

        return restauranteHttpInterface.getRestaurante(restauranteId);
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
