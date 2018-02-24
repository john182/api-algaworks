package com.chronos.money.api.repository;

import com.chronos.money.api.model.Pessoa;
import com.chronos.money.api.repository.pessoa.PessoaRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by john on 08/10/17.
 */
public interface PessoaRepository extends JpaRepository<Pessoa,Long>,PessoaRepositoryQuery {
}
