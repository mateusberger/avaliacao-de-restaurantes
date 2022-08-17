package com.avaliacaoderestaurantes.avaliacoesms.http;

import com.avaliacaoderestaurantes.avaliacoesms.service.UsuarioService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("usuarios-ms")
public interface UsuarioHttpInterface {

    @RequestMapping(method = RequestMethod.GET, value = "/usuario/{id}")
    UsuarioService.UsuarioDto getUsuario(@PathVariable Long id);
}
