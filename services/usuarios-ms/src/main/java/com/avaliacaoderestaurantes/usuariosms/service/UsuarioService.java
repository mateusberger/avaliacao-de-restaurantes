package com.avaliacaoderestaurantes.usuariosms.service;

import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Service
public class UsuarioService {

    public List<UsuarioDto> listarUsuarios(UsuarioFiltro filtro){
        return null;
    }

    public UsuarioDto getUsuarioPorId(Long id){
        return null;
    }

    public UsuarioDto criarNovoUsuario(@Valid NovoUsuarioForm form){
        return null;
    }

    public UsuarioDto deletarUsuario(Long id){
        return null;
    }


    public record NovoUsuarioForm(
            @NotBlank @NotNull String nome,
            @NotBlank @NotNull @Email String email,
            @NotNull LocalDate nascimento
            ){}

    public record UsuarioDto(Long id, String nome){}

    public record UsuarioFiltro(Long paginaAtual, Long itensPorPagina, String nome){}
}