package com.chronos.money.api.repository.filter;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * Created by john on 13/10/17.
 */
public class LancamentoFilter {


    private String descricao;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataVencimentoDe;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate getDataVencimentoAte;


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataVencimentoDe() {
        return dataVencimentoDe;
    }

    public void setDataVencimentoDe(LocalDate dataVencimentoDe) {
        this.dataVencimentoDe = dataVencimentoDe;
    }

    public LocalDate getGetDataVencimentoAte() {
        return getDataVencimentoAte;
    }

    public void setGetDataVencimentoAte(LocalDate getDataVencimentoAte) {
        this.getDataVencimentoAte = getDataVencimentoAte;
    }
}
