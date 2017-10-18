package com.chronos.money.api.resource;

import com.chronos.money.api.evento.RecursoCriadoEvent;
import com.chronos.money.api.model.Usuario;
import com.chronos.money.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by john on 17/10/17.
 */
@RestController
@RequestMapping("/usuarios")
public class UsuarioResource {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private ApplicationEventPublisher publisher;

    @CrossOrigin(maxAge =  10,origins = {"http://localhost:8000"})
    @GetMapping
    public List<Usuario> listar(){
        List<Usuario> usuarios = repository.findAll();
        return usuarios ;
    }
    @PostMapping
    public ResponseEntity<Usuario> salvar(@Valid @RequestBody Usuario categoria, HttpServletResponse response){
        Usuario usuarioSalvo = repository.save(categoria);

        publisher.publishEvent(new RecursoCriadoEvent(this,response,usuarioSalvo.getCodigo()));

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
    }
    @GetMapping("/{codigo}")
    public ResponseEntity<Usuario> getCategoria(@PathVariable Long codigo){
        Usuario usuario = repository.findOne(codigo);
        return usuario!=null?ResponseEntity.ok(usuario):ResponseEntity.notFound().build();
    }
}
