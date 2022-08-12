package com.avaliacaoderestaurantes.usuariosms.controller;

import com.avaliacaoderestaurantes.usuariosms.service.UsuarioService;
import com.avaliacaoderestaurantes.usuariosms.service.UsuarioService.UsuarioDto;
import com.avaliacaoderestaurantes.usuariosms.service.UsuarioService.UsuarioFiltro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public UsuarioFiltro listarUsuarios(
        @RequestBody UsuarioFiltro filtro
    ){
        return filtro;
    }

    @GetMapping("/{id}")
    public UsuarioDto getUsuarioPeloId(
            @PathVariable Long id
    ){
        return usuarioService.getUsuarioPorId(id);
    }

    @PostMapping
    public UsuarioDto inserirUsuario(
            @RequestBody @Valid UsuarioService.NovoUsuarioForm novoUsuarioForm
    ){
        return usuarioService.criarNovoUsuario(novoUsuarioForm);
    }

//    @PutMapping("/{id}")
//    public UsuarioDto atualizarUsuario(
//            @PathVariable Long id,
//            @RequestBody Usuario usuario
//    ){
//        return null;
//    }
//
//    @PatchMapping("/{id}")
//    public UsuarioDto atualizarRestaurante(
//            @PathVariable Long id,
//            @RequestBody HashMap<Object, Object> fields
//    ){
//        return null;
//    }

    @DeleteMapping("/{id}")
    public UsuarioDto deletarRestaurante(
            @PathVariable Long id
    ) {
        return usuarioService.deletarUsuario(id);
    }

}
