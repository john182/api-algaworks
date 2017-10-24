package com.chronos.money.api.security;

import com.chronos.money.api.model.Usuario;
import com.chronos.money.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Created by john on 17/10/17.
 */
@Service
public class AppUserDetailsService implements UserDetailsService {
    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<Usuario> usuarioOptional = repository.findByEmail(email);
        Usuario usuario = usuarioOptional.orElseThrow(()->new UsernameNotFoundException("Usuário e senha invalido"));
        return new UsuarioSistema(usuario,getPermissoes(usuario));

    }

    private Collection<? extends GrantedAuthority> getPermissoes(Usuario usuario) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();

        usuario.getPermissoes().forEach(p-> authorities.add(new SimpleGrantedAuthority(p.getDescricao().toUpperCase())));

        return authorities;
    }
}
