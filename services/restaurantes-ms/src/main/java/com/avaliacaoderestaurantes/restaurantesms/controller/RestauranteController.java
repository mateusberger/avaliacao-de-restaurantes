package com.avaliacaoderestaurantes.restaurantesms.controller;

import com.avaliacaoderestaurantes.restaurantesms.service.RestauranteService;
import com.avaliacaoderestaurantes.restaurantesms.service.RestauranteService.NovoRestauranteForm;
import com.avaliacaoderestaurantes.restaurantesms.service.RestauranteService.RestauranteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/restaurante")
public class RestauranteController {

    @Autowired
    private RestauranteService restauranteService;
    
    @GetMapping
    public Page<RestauranteDto> listarRestaurantes(
            @RequestParam(defaultValue = "0") Integer pagina,
            @RequestParam(defaultValue = "20") Integer tamanhoPagina
    ) {
        Pageable paginacao = PageRequest.of(pagina, tamanhoPagina);
        return restauranteService.listarRestaurantes(paginacao);
    }

    @GetMapping("/{id}")
    public RestauranteDto getRestaurantePeloId(@PathVariable Long id) {
        return restauranteService.getRestaurantePorId(id);
    }

    @PostMapping
    public RestauranteDto inserirRestaurante(@RequestBody NovoRestauranteForm restauranteForm) {
        return restauranteService.criarNovoRestaurante(restauranteForm);
    }

    @DeleteMapping("/{id}")
    public RestauranteDto deletarRestaurante(@PathVariable Long id) {
        return restauranteService.deletarRestaurante(id);
    }
}
