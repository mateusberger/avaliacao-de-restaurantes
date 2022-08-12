package com.avaliacaoderestaurantes.avaliacoesms.model;

public class Avaliacao {

    private Long id;

    private Integer nota;

    private Long idUsuario;

    private Long idRestaurante;

    private Restaurante restaurante;

    private Usuario usuario;

    public Avaliacao() {
    }

    public Avaliacao(Long id, Integer nota, Long idUsuario, Long idRestaurante) {
        this.id = id;
        this.nota = nota;
        this.idUsuario = idUsuario;
        this.idRestaurante = idRestaurante;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdRestaurante() {
        return idRestaurante;
    }

    public void setIdRestaurante(Long idRestaurante) {
        this.idRestaurante = idRestaurante;
    }
}
