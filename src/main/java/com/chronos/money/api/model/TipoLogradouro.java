package com.chronos.money.api.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by john on 07/11/17.
 */
@Entity
@Table(name = "tipo_logradouro")
public class TipoLogradouro implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    private Integer id;

    @Size(max = 3)
    private String codigoCadsus;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    private String codigoDne;

    private Integer flagAtivo;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    private String nome;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigoCadsus() {
        return codigoCadsus;
    }

    public void setCodigoCadsus(String codigoCadsus) {
        this.codigoCadsus = codigoCadsus;
    }

    public String getCodigoDne() {
        return codigoDne;
    }

    public void setCodigoDne(String codigoDne) {
        this.codigoDne = codigoDne;
    }

    public Integer getFlagAtivo() {
        return flagAtivo;
    }

    public void setFlagAtivo(Integer flagAtivo) {
        this.flagAtivo = flagAtivo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
