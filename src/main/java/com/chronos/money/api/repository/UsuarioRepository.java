package com.chronos.money.api.repository;

import com.chronos.money.api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by john on 17/10/17.
 */
public interface UsuarioRepository extends JpaRepository<Usuario , Long> {

    Optional<Usuario> findByEmail(String email);
}
