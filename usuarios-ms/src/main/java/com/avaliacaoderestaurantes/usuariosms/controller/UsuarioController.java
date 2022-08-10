package com.avaliacaoderestaurantes.usuariosms.controller;

import com.avaliacaoderestaurantes.usuariosms.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @GetMapping
    public List<Usuario> listarUsuarios(){
        return Arrays.asList(
                new Usuario(1L, "Henrique"),
                new Usuario(2L, "João"),
                new Usuario(3L, "Mateus"),
                new Usuario(4L, "Amanda"),
                new Usuario(5L, "Cassandra")
        );
    }

    @GetMapping("/{id}")
    public Usuario getUsuarioPeloId(@PathVariable Long id){
        return new Usuario(id, "Maria");
    }

}
