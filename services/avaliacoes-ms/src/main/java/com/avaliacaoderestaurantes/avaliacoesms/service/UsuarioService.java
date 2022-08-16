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
public class UsuarioService {

    @Autowired
    private RestTemplate restTemplate;

    @LoadBalanced
    @CircuitBreaker(name = "usuarioCircuitBreaker", fallbackMethod = "fallBackGetUsuario")
    public UsuarioDto getUsuario(Long usuarioId){

        ResponseEntity<UsuarioDto> usuarioResponse = restTemplate
                .getForEntity("http://usuarios-ms/usuario/" + usuarioId, UsuarioDto.class);

        if (usuarioResponse.getStatusCode() != HttpStatus.OK){

        }

        return usuarioResponse.getBody();
    }

    public UsuarioDto fallBackGetUsuario(Long usuarioId){
        return new UsuarioDto(usuarioId, "...");
    }

    @Schema(name = "Usuário")
    public record UsuarioDto(
            Long id,
            String nome
    ) {}
}
