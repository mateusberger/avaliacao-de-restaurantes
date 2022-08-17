package com.avaliacaoderestaurantes.avaliacoesms.service;

import com.avaliacaoderestaurantes.avaliacoesms.http.UsuarioHttpInterface;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioHttpInterface usuarioHttpInterface;

    @LoadBalanced
    @CircuitBreaker(name = "usuarioCircuitBreaker", fallbackMethod = "fallBackGetUsuario")
    public UsuarioDto getUsuario(Long usuarioId){
       return usuarioHttpInterface.getUsuario(usuarioId);
    }

    public UsuarioDto fallBackGetUsuario(Long usuarioId, Throwable t){
        return new UsuarioDto(usuarioId, "...");
    }

    @Schema(name = "Usuário")
    public record UsuarioDto(
            Long id,
            String nome
    ) {}
}
