package com.chronos.money.api.resource;

import com.chronos.money.api.model.Pedido;
import com.chronos.money.api.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by john on 15/10/17.
 */
@RestController
@RequestMapping("/pedidos")
public class PedidoResource {

    @Autowired
    private PedidoRepository repository;


    @GetMapping
    public List<Pedido>  listar(){
        List<Pedido> pedidos = repository.findAll();
        return pedidos ;
    }
}
