package com.chronos.money.api.service;

import com.chronos.money.api.model.Pessoa;
import com.chronos.money.api.repository.PessoaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

/**
 * Created by john on 10/10/17.
 */
@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa atualizar(Long codigo,Pessoa pessoa){
        Pessoa pessoaSalva = getPessoa(codigo);
        BeanUtils.copyProperties(pessoa, pessoaSalva, "codigo");
        pessoaRepository.save(pessoaSalva);
        return pessoaSalva;
    }



    public void atualizarStatus(Long codigo, Boolean ativo) {
        Pessoa pessoaSalva = getPessoa(codigo);
        pessoaSalva.setAtivo(ativo);
        pessoaRepository.save(pessoaSalva);
    }

    public Pessoa getPessoa(Long codigo) {
        Pessoa pessoaSalva = pessoaRepository.findOne(codigo);
        if(pessoaSalva==null){
            throw new EmptyResultDataAccessException(1);
        }
        return pessoaSalva;
    }
}
