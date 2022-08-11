package com.avaliacaoderestaurantes.usuariosms.controller;

import com.avaliacaoderestaurantes.usuariosms.model.Usuario;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public Usuario inserirUsuario(@RequestBody Usuario usuario){
        return usuario;
    }

    @PutMapping("/{id}")
    public Usuario atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario){
        return usuario;
    }

    @PatchMapping("/{id}/{nomeAtributo}")
    public Usuario atualizarRestaurante(@PathVariable Long id, @PathVariable String nomeAtributo, @RequestBody Usuario usuario){
        return usuario;
    }

    @DeleteMapping("/{id}")
    public Usuario deletarRestaurante(@PathVariable Long id) {
        return new Usuario(id, "Maria");
    }

}
