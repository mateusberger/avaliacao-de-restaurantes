package com.avaliacaoderestaurantes.usuariosms.repository;

import com.avaliacaoderestaurantes.usuariosms.model.Usuario;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long> {

}