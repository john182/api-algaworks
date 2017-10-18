package com.chronos.money.api.repository;

import com.chronos.money.api.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by john on 15/10/17.
 */
public interface PedidoRepository extends JpaRepository<Pedido,Long> {
}
