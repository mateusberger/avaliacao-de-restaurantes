package com.avaliacaoderestaurantes.avaliacoesms.repository;

import com.avaliacaoderestaurantes.avaliacoesms.model.Avaliacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AvaliacaoRepository extends PagingAndSortingRepository<Avaliacao, Long> {
    
    Page<Avaliacao> findAllByIdUsuario(Long idUsuario, Pageable paginacao);
    
    Page<Avaliacao> findAllByIdRestaurante(Long idRestaurante, Pageable paginacao);
}
