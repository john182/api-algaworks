package com.chronos.money.api.repository;

import com.chronos.money.api.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by john on 05/10/17.
 */
public interface CategoriaRepository extends JpaRepository<Categoria,Long> {


    List<Categoria> findByNome(String nome);
}
