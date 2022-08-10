package com.avaliacaoderestaurantes.avaliacoesms.controller;

import com.avaliacaoderestaurantes.avaliacoesms.model.Avaliacao;
import com.avaliacaoderestaurantes.avaliacoesms.model.Restaurante;
import com.avaliacaoderestaurantes.avaliacoesms.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public List<Avaliacao> listarAvaliacoes(){

        List<Avaliacao> avaliacaos = Arrays.asList(
                new Avaliacao(1L, 5, 1L, 3L),
                new Avaliacao(2L, 4, 2L, 2L),
                new Avaliacao(3L, 3, 3L, 4L),
                new Avaliacao(4L, 2, 4L, 5L),
                new Avaliacao(5L, 1, 5L, 1L)
        );

        avaliacaos.stream().forEach((a) -> {
            ResponseEntity<Restaurante> restaurante = restTemplate.getForEntity(
                    "http://localhost:8181/restaurantes-ms/restaurante/" + a.getIdRestaurante(),
                    Restaurante.class
            );

            if (restaurante.getStatusCode() != HttpStatus.OK){
                return;
            }

            a.setRestaurante(restaurante.getBody());

        });

        avaliacaos.stream().forEach((a) -> {
            ResponseEntity<Usuario> usuario = restTemplate.getForEntity(
                    "http://localhost:8181/usuarios-ms/usuario/" + a.getIdUsuario(),
                    Usuario.class
            );

            if (usuario.getStatusCode() != HttpStatus.OK){
                return;
            }

            a.setUsuario(usuario.getBody());

        });

        return avaliacaos;

    }

    @GetMapping("/{id}")
    public Avaliacao getAvaliacaoPorId(@PathVariable Long id){
        return new Avaliacao(id, 1, 5L, 1L);
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
