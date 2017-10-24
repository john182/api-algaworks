package com.chronos.money.api.model;

import javax.persistence.*;

/**
 * Created by john on 19/10/17.
 */
@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String titulo;
    private String urlImagem;
    private String sumario;
    private boolean ehFavorito;


    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public String getSumario() {
        return sumario;
    }

    public void setSumario(String sumario) {
        this.sumario = sumario;
    }

    public boolean isEhFavorito() {
        return ehFavorito;
    }

    public void setEhFavorito(boolean ehFavorito) {
        this.ehFavorito = ehFavorito;
    }
}
