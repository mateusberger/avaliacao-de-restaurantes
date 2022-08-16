package com.avaliacaoderestaurantes.avaliacoesms.controller;

import com.avaliacaoderestaurantes.avaliacoesms.model.Avaliacao;
import com.avaliacaoderestaurantes.avaliacoesms.service.AvaliacaoService;
import com.avaliacaoderestaurantes.avaliacoesms.service.AvaliacaoService.AvaliacaoDto;
import com.avaliacaoderestaurantes.avaliacoesms.service.RestauranteService;
import com.avaliacaoderestaurantes.avaliacoesms.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService avaliacaoService;

    @GetMapping
    public List<AvaliacaoDto> listarAvaliacoes(){

        return avaliacaoService.listarAvaliacoes();
    }

    @GetMapping("/{id}")
    public AvaliacaoDto getAvaliacaoPorId(@PathVariable Long id){
        return new AvaliacaoDto(
                id,
                5,
                new UsuarioService.UsuarioDto(1L, "..."),
                new RestauranteService.RestauranteDto(1L, "...")
        );
    }

    @GetMapping("/usuario/{id}")
    public Avaliacao getAvaliacaoPorIdUsuario(@PathVariable Long id){
        return new Avaliacao(5L, 1, id, 1L);
    }

    @GetMapping("/restaurante/{id}")
    public Avaliacao getAvaliacaoPorIdRestaurante(@PathVariable Long id){
        return new Avaliacao(5L, 1, 5L, id);
    }

}
