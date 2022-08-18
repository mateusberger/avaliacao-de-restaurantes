package com.avaliacaoderestaurantes.usuariosms.controller;

import com.avaliacaoderestaurantes.usuariosms.service.UsuarioService;
import com.avaliacaoderestaurantes.usuariosms.service.UsuarioService.UsuarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public Page<UsuarioDto> listarUsuarios(
            @RequestParam(defaultValue = "0") Integer pagina,
            @RequestParam(defaultValue = "20") Integer tamanhoPagina
    ) {
        Pageable paginacao = PageRequest.of(pagina, tamanhoPagina);
        return usuarioService.listarUsuarios(paginacao);
    }

    @GetMapping("/{id}")
    public UsuarioDto getUsuarioPeloId(
            @PathVariable Long id
    ) {
        return usuarioService.getUsuarioPorId(id);
    }

    @PostMapping
    public UsuarioDto inserirUsuario(
            @RequestBody @Valid UsuarioService.NovoUsuarioForm novoUsuarioForm
    ) {
        return usuarioService.criarNovoUsuario(novoUsuarioForm);
    }

    @DeleteMapping("/{id}")
    public UsuarioDto deletarUsuario(
            @PathVariable Long id
    ) {
        return usuarioService.deletarUsuario(id);
    }

}
