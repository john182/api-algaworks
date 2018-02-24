package com.chronos.money.api.resource;

import com.chronos.money.api.model.Logradouro;
import com.chronos.money.api.repository.LogradouroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by john on 07/11/17.
 */
@RestController
@RequestMapping("/logradouros")
public class LogradouroResource {

    @Autowired
    private LogradouroRepository repository;

    @GetMapping
    public List<Logradouro>  listar(){
        List<Logradouro> logradouros = repository.findAll();
        return logradouros ;
    }

}
