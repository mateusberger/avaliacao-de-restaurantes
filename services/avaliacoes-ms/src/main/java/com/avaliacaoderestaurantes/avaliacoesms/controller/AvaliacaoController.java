package com.avaliacaoderestaurantes.avaliacoesms.controller;

import com.avaliacaoderestaurantes.avaliacoesms.model.Avaliacao;
import com.avaliacaoderestaurantes.avaliacoesms.service.AvaliacaoService;
import com.avaliacaoderestaurantes.avaliacoesms.service.AvaliacaoService.AvaliacaoDto;
import com.avaliacaoderestaurantes.avaliacoesms.service.AvaliacaoService.NovaAvaliacaoForm;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService avaliacaoService;

    @GetMapping
    public Page<AvaliacaoDto> listarAvaliacoes(
            @RequestParam(defaultValue = "0") Integer pagina,
            @RequestParam(defaultValue = "20") Integer tamanhoPagina
    ) {
        Pageable paginacao = PageRequest.of(pagina, tamanhoPagina);
        return avaliacaoService.listarAvaliacoes(paginacao);
    }

    @GetMapping("/{id}")
    public AvaliacaoDto getAvaliacaoPorId(@PathVariable Long id) {
        return avaliacaoService.getAvaliacaoPorId(id);
    }

    @GetMapping("/usuario/{id}")
    public Avaliacao getAvaliacaoPorIdUsuario(@PathVariable Long id) {
        return new Avaliacao(5L, 1, id, 1L);
    }

    @GetMapping("/restaurante/{id}")
    public Avaliacao getAvaliacaoPorIdRestaurante(@PathVariable Long id) {
        return new Avaliacao(5L, 1, 5L, id);
    }
    
    @PostMapping
    public AvaliacaoDto inserirAvaliacao(
            @RequestBody @Valid NovaAvaliacaoForm form
    ) {
        return avaliacaoService.criarNovaAvaliacao(form);
    }

    @DeleteMapping("/{id}")
    public AvaliacaoDto deletarAvaliacao(
            @PathVariable Long id
    ) {
        return avaliacaoService.deletarAvaliacao(id);
    }

}
