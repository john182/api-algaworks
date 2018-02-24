package com.chronos.money.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by john on 07/11/17.
 */
@Entity
@Table(name = "logradouro")
public class Logradouro  implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;

    @Size(max = 8)
    private String cepGeral;

    @Size(max = 500)
    private String epigrafe;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    private String nome;


    @Size(max = 120)
    private String nomeExibicao;
    @JoinColumn(name="id_tipo_Logradouro")
    @ManyToOne
    private TipoLogradouro tipoLogradouro;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCepGeral() {
        return cepGeral;
    }

    public void setCepGeral(String cepGeral) {
        this.cepGeral = cepGeral;
    }

    public String getEpigrafe() {
        return epigrafe;
    }

    public void setEpigrafe(String epigrafe) {
        this.epigrafe = epigrafe;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeExibicao() {
        return nomeExibicao;
    }

    public void setNomeExibicao(String nomeExibicao) {
        this.nomeExibicao = nomeExibicao;
    }

    public TipoLogradouro getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }
}
