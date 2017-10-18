package com.chronos.money.api.service;

import com.chronos.money.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by john on 17/10/17.
 */
@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;
}
