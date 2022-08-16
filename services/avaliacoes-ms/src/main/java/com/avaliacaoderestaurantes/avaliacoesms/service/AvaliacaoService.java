package com.avaliacaoderestaurantes.avaliacoesms.service;

import com.avaliacaoderestaurantes.avaliacoesms.model.Avaliacao;
import com.avaliacaoderestaurantes.avaliacoesms.service.RestauranteService.RestauranteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.avaliacaoderestaurantes.avaliacoesms.service.UsuarioService.*;

@Service
public class AvaliacaoService {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RestauranteService restauranteService;

    private List<Avaliacao> avaliacoes = Arrays.asList(
            new Avaliacao(1L, 5, 1L, 3L),
            new Avaliacao(2L, 4, 2L, 2L),
            new Avaliacao(3L, 3, 3L, 4L),
            new Avaliacao(4L, 2, 4L, 5L),
            new Avaliacao(5L, 1, 5L, 1L)
    );

    public List<AvaliacaoDto> listarAvaliacoes(){
        return avaliacoes.stream()
                .map(avaliacao -> {
                    RestauranteDto restaurante = restauranteService.getRestaurante(avaliacao.getIdRestaurante());
                    UsuarioDto usuario = usuarioService.getUsuario(avaliacao.getIdUsuario());
                    return AvaliacaoDto.avaliacaoDtoFrom(avaliacao, usuario, restaurante);
                })
                .toList();
    }

    public record AvaliacaoDto(Long id, Integer nota, UsuarioDto usuario, RestauranteDto restaurante){

        public static AvaliacaoDto avaliacaoDtoFrom(
                Avaliacao avaliacao,
                UsuarioDto usuarioDto,
                RestauranteDto restauranteDto
        ){
            return new AvaliacaoDto(avaliacao.getId(), avaliacao.getNota(), usuarioDto, restauranteDto);
        }
    }

}
