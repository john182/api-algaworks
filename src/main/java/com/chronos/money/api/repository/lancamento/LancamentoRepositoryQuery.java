package com.chronos.money.api.repository.lancamento;

import com.chronos.money.api.model.Lancamento;
import com.chronos.money.api.repository.filter.LancamentoFilter;
import com.chronos.money.api.repository.projection.ResumoLancamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by john on 13/10/17.
 */
public interface LancamentoRepositoryQuery {

    public Page<Lancamento> filtrar(LancamentoFilter filtros, Pageable pageable);
    public Page<ResumoLancamento> resumir(LancamentoFilter lancamentoFilter, Pageable pageable);
}
