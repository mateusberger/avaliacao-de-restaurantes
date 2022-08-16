package com.avaliacaoderestaurantes.usuariosms.controller;

import com.avaliacaoderestaurantes.usuariosms.service.UsuarioService;
import com.avaliacaoderestaurantes.usuariosms.service.UsuarioService.UsuarioDto;
import com.avaliacaoderestaurantes.usuariosms.service.UsuarioService.UsuarioFiltro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
        @RequestParam Integer pagina,
        @RequestParam Integer itensPorPagina
    ){
        return usuarioService.listarUsuarios(new UsuarioFiltro(pagina, itensPorPagina));
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
