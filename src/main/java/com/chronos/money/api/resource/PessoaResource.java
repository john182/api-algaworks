package com.chronos.money.api.resource;

import com.chronos.money.api.evento.RecursoCriadoEvent;
import com.chronos.money.api.model.Lancamento;
import com.chronos.money.api.model.Pessoa;
import com.chronos.money.api.repository.PessoaRepository;
import com.chronos.money.api.repository.filter.LancamentoFilter;
import com.chronos.money.api.service.PessoaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

/**
 * Created by john on 08/10/17.
 */
@RestController
@RequestMapping("/pessoas")
public class PessoaResource {


    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private PessoaService service;
    @Autowired
    private ApplicationEventPublisher publisher;

//    @GetMapping
//    public List<Pessoa> listar() {
//        List<Pessoa> Pessoas = pessoaRepository.findAll();
//        return Pessoas;
//    }

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_PESQUISAR_PESSOA')")
    public Page<Pessoa> pesquisar(@RequestParam(required = false, defaultValue = "%") String nome, @PageableDefault(size = 10) Pageable pageable){
        Page<Pessoa> pessoas = pessoaRepository.filtrar(nome,pageable);
        return pessoas ;
    }

    @PostMapping
    public ResponseEntity<Pessoa> salvar(@Valid @RequestBody Pessoa Pessoa, HttpServletResponse response) {
        Pessoa pessoaSalva = pessoaRepository.save(Pessoa);

        publisher.publishEvent(new RecursoCriadoEvent(this, response, pessoaSalva.getCodigo()));

        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Pessoa> getPessoa(@PathVariable Long codigo) {
        Pessoa Pessoa = pessoaRepository.findOne(codigo);
        return Pessoa != null ? ResponseEntity.ok(Pessoa) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long codigo) {
        pessoaRepository.delete(codigo);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Pessoa> atualizar(@PathVariable Long codigo, @Valid @RequestBody Pessoa pessoa) {

        return ResponseEntity.ok(service.atualizar(codigo,pessoa));
    }

    @PutMapping("/{codigo}/ativo")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarStatus(@PathVariable Long codigo, @Valid @RequestBody Boolean ativo) {

       service.atualizarStatus(codigo,ativo);
    }

}
