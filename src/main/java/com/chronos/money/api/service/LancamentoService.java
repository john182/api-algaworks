package com.chronos.money.api.service;

import com.chronos.money.api.model.Lancamento;
import com.chronos.money.api.model.Pessoa;
import com.chronos.money.api.repository.LancamentoRepository;
import com.chronos.money.api.repository.PessoaRepository;
import com.chronos.money.api.service.exception.PesssoaInexistenteException;
import org.springframework.beans.BeanUtils;
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

    public Lancamento salvar(Lancamento lancamento) {
        validarPessoa(lancamento);

        return repository.save(lancamento);
    }

    public Lancamento atualizar(Long codigo, Lancamento lancamento) {
        Lancamento lancamentoSalvo = buscarLancamentoExistente(codigo);
        if (!lancamento.getPessoa().equals(lancamentoSalvo.getPessoa())) {
            validarPessoa(lancamento);
        }

        BeanUtils.copyProperties(lancamento, lancamentoSalvo, "codigo");

        return repository.save(lancamentoSalvo);
    }

    private void validarPessoa(Lancamento lancamento) {
        Pessoa pessoa = null;
        if (lancamento.getPessoa().getCodigo() != null) {
            pessoa = pessoaRepository.findOne(lancamento.getPessoa().getCodigo());
        }

        if (pessoa == null || pessoa.isInativo()) {
            throw new PesssoaInexistenteException();
        }
    }

    private Lancamento buscarLancamentoExistente(Long codigo) {
        Lancamento lancamentoSalvo = repository.findOne(codigo);
        if (lancamentoSalvo == null) {
            throw new IllegalArgumentException();
        }
        return lancamentoSalvo;
    }

}
