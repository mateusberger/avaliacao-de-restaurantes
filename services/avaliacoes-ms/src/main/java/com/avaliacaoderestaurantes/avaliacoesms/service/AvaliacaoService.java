package com.avaliacaoderestaurantes.avaliacoesms.service;

import com.avaliacaoderestaurantes.avaliacoesms.exception.AvaliacaoNaoEncontradoException;
import com.avaliacaoderestaurantes.avaliacoesms.model.Avaliacao;
import com.avaliacaoderestaurantes.avaliacoesms.repository.AvaliacaoRepository;
import com.avaliacaoderestaurantes.avaliacoesms.service.RestauranteService.RestauranteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import static com.avaliacaoderestaurantes.avaliacoesms.service.UsuarioService.*;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class AvaliacaoService {

    private final AvaliacaoRepository repository;

    private final UsuarioService usuarioService;

    private final RestauranteService restauranteService;

    @Autowired
    public AvaliacaoService(
            AvaliacaoRepository avaliacaoRepository,
            UsuarioService usuarioService,
            RestauranteService restauranteService
    ) {
        this.repository = avaliacaoRepository;
        this.usuarioService = usuarioService;
        this.restauranteService = restauranteService;
    }

    public Page<AvaliacaoDto> listarAvaliacoes(Pageable paginacao) {

        Page<Avaliacao> avaliacoes = repository.findAll(paginacao);

        return avaliacoes.map(this::buscarDadosDeUsuarioERestauranteDaAvaliacao);
    }
    
    public Page<AvaliacaoDto> listarAvaliacoesPorIdUsuario(Long idUsuario, Pageable paginacao) {

        Page<Avaliacao> avaliacoes = repository.findAllByIdUsuario(idUsuario, paginacao);

        return avaliacoes.map(this::buscarDadosDeUsuarioERestauranteDaAvaliacao);
    }
    
    public Page<AvaliacaoDto> listarAvaliacoesPorIdRestaurante(Long idRestaurante, Pageable paginacao) {

        Page<Avaliacao> avaliacoes = repository.findAllByIdRestaurante(idRestaurante, paginacao);

        return avaliacoes.map(this::buscarDadosDeUsuarioERestauranteDaAvaliacao);
    }

    public AvaliacaoDto getAvaliacaoPorId(
            Long id
    ) {
        Optional<Avaliacao> avaliacao = repository.findById(id);
        
        if (avaliacao.isEmpty()) {
            throw new AvaliacaoNaoEncontradoException();
        }
        
        return buscarDadosDeUsuarioERestauranteDaAvaliacao(avaliacao.get());
    }

    public AvaliacaoDto criarNovaAvaliacao(
            @Valid NovaAvaliacaoForm form
    ) {
        Avaliacao avaliacaoSalvo = repository.save(NovaAvaliacaoForm.toAvaliacao(form));
        return AvaliacaoDto.fromAvaliacao(avaliacaoSalvo);
    }

    public AvaliacaoDto deletarAvaliacao(
            Long id
    ) {
        Optional<Avaliacao> aDeletar = repository.findById(id);

        if (aDeletar.isEmpty()){
            throw new AvaliacaoNaoEncontradoException();
        }

        AvaliacaoDto deletado = AvaliacaoDto.fromAvaliacao(aDeletar.get());

        repository.delete(aDeletar.get());

        return deletado;
    }
    
    private AvaliacaoDto buscarDadosDeUsuarioERestauranteDaAvaliacao(Avaliacao avaliacao) {

        RestauranteDto restaurante = restauranteService
                .getRestaurante(avaliacao.getIdRestaurante());

        UsuarioDto usuario = usuarioService
                .getUsuario(avaliacao.getIdUsuario());

        return AvaliacaoDto.fromAvaliacaoUsuarioERestaurante(avaliacao, usuario, restaurante);
    }

    //--------------------dtos---------------------
    
    public record AvaliacaoDto(Long id, Integer nota, UsuarioDto usuario, RestauranteDto restaurante) {

        public static AvaliacaoDto fromAvaliacaoUsuarioERestaurante(
                Avaliacao avaliacao,
                UsuarioDto usuarioDto,
                RestauranteDto restauranteDto
        ) {
            return new AvaliacaoDto(avaliacao.getId(), avaliacao.getNota(), usuarioDto, restauranteDto);
        }
        
        public static AvaliacaoDto fromAvaliacao(
                Avaliacao avaliacao
        ) {
            return new AvaliacaoDto(
                    avaliacao.getId(), avaliacao.getNota(),
                    new UsuarioDto(avaliacao.getId(), "..."),
                    new RestauranteDto(avaliacao.getId(), "...")
            );
        }
    }
    
    public record NovaAvaliacaoForm(Integer nota, Long usuarioId, Long restauranteId){
        
        public static Avaliacao toAvaliacao(NovaAvaliacaoForm form){
            Avaliacao avaliacao = new Avaliacao();
            avaliacao.setNota(form.nota());
            avaliacao.setIdUsuario(form.usuarioId());
            avaliacao.setIdRestaurante(form.restauranteId());
            return avaliacao;
        }
    }

}
