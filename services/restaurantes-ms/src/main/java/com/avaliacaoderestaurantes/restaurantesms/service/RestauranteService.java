package com.avaliacaoderestaurantes.restaurantesms.service;

import com.avaliacaoderestaurantes.restaurantesms.exception.RestauranteNaoEncontradoException;
import com.avaliacaoderestaurantes.restaurantesms.model.Restaurante;
import com.avaliacaoderestaurantes.restaurantesms.repository.RestauranteRepository;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RestauranteService {

    private final RestauranteRepository repository;

    @Autowired
    public RestauranteService(RestauranteRepository repository) {
        this.repository = repository;
    }

    public Page<RestauranteDto> listarRestaurantes(
            Pageable paginacao
    ) {
        Page<Restaurante> restaurantes = repository.findAll(paginacao);
        return restaurantes.map(
                (restaurante) -> RestauranteDto.fromRestaurante(restaurante)
        );
    }
    
    public RestauranteDto getRestaurantePorId(Long idRestaurante){
        Optional<Restaurante> restaurante = repository.findById(idRestaurante);
        if(restaurante.isPresent()) return RestauranteDto.fromRestaurante(restaurante.get());
        return null;
    }
    
    public RestauranteDto criarNovoRestaurante(
            @Valid NovoRestauranteForm form
    ) {
        Restaurante restauranteSalvo = repository.save(NovoRestauranteForm.toRestaurante(form));
        return RestauranteDto.fromRestaurante(restauranteSalvo);
    }

    public RestauranteDto deletarRestaurante(
            Long id
    ) {
        Optional<Restaurante> aDeletar = repository.findById(id);

        if (aDeletar.isEmpty()){
            throw new RestauranteNaoEncontradoException();
        }

        RestauranteDto deletado = RestauranteDto.fromRestaurante(aDeletar.get());

        repository.delete(aDeletar.get());

        return deletado;
    }

    //--------------------dtos---------------------
    public static record NovoRestauranteForm(String nome) {

        public static Restaurante toRestaurante(NovoRestauranteForm form) {
            Restaurante restaurante = new Restaurante();
            restaurante.setNome(form.nome());
            return restaurante;
        }
    }

    public static record RestauranteDto(Long id, String nome) {

        public static RestauranteDto fromRestaurante(Restaurante restaurante) {
            return new RestauranteDto(restaurante.getId(), restaurante.getNome());
        }
    }

}
