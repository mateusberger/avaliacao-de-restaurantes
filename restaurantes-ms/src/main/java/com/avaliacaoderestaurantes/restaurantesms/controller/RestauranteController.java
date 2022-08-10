package com.avaliacaoderestaurantes.restaurantesms.controller;

import com.avaliacaoderestaurantes.restaurantesms.model.Restaurante;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/restaurante")
public class RestauranteController {

    @GetMapping
    public List<Restaurante> listarRestaurantes(){
        return Arrays.asList(
                new Restaurante(1L, "Pé de Fava"),
                new Restaurante(2L, "Desejo e Requinte"),
                new Restaurante(3L, "Versatil"),
                new Restaurante(4L, "Versatto"),
                new Restaurante(5L, "Caravela")
        );
    }

    @GetMapping("/{id}")
    public Restaurante getRestaurantePeloId(@PathVariable Long id){
        return new Restaurante(id, "Coqueiro");
    }

}
