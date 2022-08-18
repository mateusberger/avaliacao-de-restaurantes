package com.avaliacaoderestaurantes.usuariosms.service;

import com.avaliacaoderestaurantes.usuariosms.exception.UsuarioNaoEncontradoException;
import com.avaliacaoderestaurantes.usuariosms.model.Usuario;
import com.avaliacaoderestaurantes.usuariosms.repository.UsuarioRepository;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    @Autowired
    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Page<UsuarioDto> listarUsuarios(
            Pageable paginacao
    ) {

        return (repository.findAll(paginacao)).map(usuario -> UsuarioDto.fromUsuario(usuario));
    }

    public UsuarioDto getUsuarioPorId(
            Long id
    ) {
        Optional<Usuario> usuario = repository.findById(id);
        if (usuario.isEmpty()) {
            throw new UsuarioNaoEncontradoException();
        }
        return UsuarioDto.fromUsuario(usuario.get());
    }

    public UsuarioDto criarNovoUsuario(
            @Valid NovoUsuarioForm form
    ) {
        Usuario usuarioSalvo = repository.save(NovoUsuarioForm.toUsuario(form));
        return UsuarioDto.fromUsuario(usuarioSalvo);
    }

    public UsuarioDto deletarUsuario(
            Long id
    ) {
        Optional<Usuario> aDeletar = repository.findById(id);

        if (aDeletar.isEmpty()){
            throw new UsuarioNaoEncontradoException();
        }

        UsuarioDto deletado = UsuarioDto.fromUsuario(aDeletar.get());

        repository.delete(aDeletar.get());

        return deletado;
    }

//--------------------dtos---------------------

    @Schema(name = "Formulário de cadastro de Usuário")
    public record NovoUsuarioForm(
            @NotBlank @NotNull String nome,
            @NotBlank @NotNull @Email String email,
            @NotNull LocalDate nascimento
    ) {

        public static Usuario toUsuario(NovoUsuarioForm novoUsuarioForm){
            Usuario usuario = new Usuario();
            usuario.setNome(novoUsuarioForm.nome());
            usuario.setEmail(novoUsuarioForm.email());
            usuario.setNascimento(novoUsuarioForm.nascimento());
            return usuario;
        }

    }

    @Schema(name = "Usuário")
    public record UsuarioDto(
            Long id,
            String nome,
            String email,
            LocalDate nascimento
    ) {

        public static UsuarioDto fromUsuario(Usuario usuario){
            return new UsuarioDto(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getNascimento());
        }

    }

}