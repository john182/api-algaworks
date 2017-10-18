package com.chronos.money.api.repository;

import com.chronos.money.api.model.Lancamento;
import com.chronos.money.api.repository.lancamento.LancamentoRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by john on 11/10/17.
 */
public interface LancamentoRepository extends JpaRepository<Lancamento,Long>,LancamentoRepositoryQuery {
}
