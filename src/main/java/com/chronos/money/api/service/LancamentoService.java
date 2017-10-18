package com.chronos.money.api.service;

import com.chronos.money.api.model.Lancamento;
import com.chronos.money.api.model.Pessoa;
import com.chronos.money.api.repository.LancamentoRepository;
import com.chronos.money.api.repository.PessoaRepository;
import com.chronos.money.api.service.exception.PesssoaInexistenteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Created by john on 11/10/17.
 */
@Service
public class LancamentoService {
    @Autowired
    private LancamentoRepository repository;
    @Autowired
    private PessoaRepository pessoaRepository;

    public Lancamento salvar(Lancamento lancamento){
        Pessoa pessoa = pessoaRepository.findOne(lancamento.getPessoa().getCodigo());

        if(pessoa == null || pessoa.isInativo() ){
            throw new PesssoaInexistenteException();
        }
        lancamento=  repository.save(lancamento);
        return lancamento;
    }

}
