package com.avaliacaoderestaurantes.usuariosms.controller;

import com.avaliacaoderestaurantes.usuariosms.service.UsuarioService;
import com.avaliacaoderestaurantes.usuariosms.service.UsuarioService.UsuarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public Page<UsuarioDto> listarUsuarios(
        @PageableDefault(page = 0, size = 10) Pageable paginacao
    ){
        return usuarioService.listarUsuarios(paginacao);
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
    public UsuarioDto deletarUsuario(
            @PathVariable Long id
    ) {
        return usuarioService.deletarUsuario(id);
    }

}
