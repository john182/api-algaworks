package com.chronos.money.api.repository.pessoa;

import com.chronos.money.api.model.Lancamento;
import com.chronos.money.api.model.Pessoa;
import com.chronos.money.api.repository.filter.LancamentoFilter;
import com.chronos.money.api.repository.projection.ResumoLancamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by john on 13/10/17.
 */
public interface PessoaRepositoryQuery {

    public Page<Pessoa> filtrar(String nome, Pageable pageable);

}
