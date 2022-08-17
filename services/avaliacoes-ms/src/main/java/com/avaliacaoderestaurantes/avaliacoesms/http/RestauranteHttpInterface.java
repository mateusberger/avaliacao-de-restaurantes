package com.avaliacaoderestaurantes.avaliacoesms.http;

import com.avaliacaoderestaurantes.avaliacoesms.service.RestauranteService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("restaurantes-ms")
public interface RestauranteHttpInterface {

    @RequestMapping(method = RequestMethod.GET, path = "/restaurante/{id}")
    RestauranteService.RestauranteDto getRestaurante(@PathVariable Long id);

}
