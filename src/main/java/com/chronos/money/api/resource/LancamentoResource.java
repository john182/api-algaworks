package com.chronos.money.api.resource;

import com.chronos.money.api.evento.RecursoCriadoEvent;
import com.chronos.money.api.exceptionhandler.ApiErro;
import com.chronos.money.api.model.Lancamento;
import com.chronos.money.api.repository.LancamentoRepository;
import com.chronos.money.api.repository.filter.LancamentoFilter;
import com.chronos.money.api.repository.projection.ResumoLancamento;
import com.chronos.money.api.service.LancamentoService;
import com.chronos.money.api.service.exception.PesssoaInexistenteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

/**
 * Created by john on 11/10/17.
 */
@RestController
@RequestMapping("/lancamentos")
public class LancamentoResource {

    @Autowired
    private LancamentoRepository repository;
    @Autowired
    private LancamentoService service;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_PESQUISAR_LANCAMENTO') and #oauth2.hasScope('read')")
    public Page<Lancamento> pesquisar(LancamentoFilter filtros,@PageableDefault(size = 10)  Pageable pageable){
        Page<Lancamento> lancamentos = repository.filtrar(filtros,pageable);
        return lancamentos ;
    }
    @GetMapping(params = "resumo")
    @PreAuthorize("hasAuthority('ROLE_PESQUISAR_LANCAMENTO') and #oauth2.hasScope('read')")
    public Page<ResumoLancamento> resumir(LancamentoFilter lancamentoFilter, Pageable pageable) {
        return repository.resumir(lancamentoFilter, pageable);
    }

    @GetMapping("/{codigo}")
    @PreAuthorize("hasAuthority('ROLE_PESQUISAR_LANCAMENTO') and #oauth2.hasScope('read')")
    public ResponseEntity<Lancamento> buscarPeloCodigo(@PathVariable Long codigo){
        Lancamento lancamento = repository.findOne(codigo);
        return lancamento!=null? ResponseEntity.ok(lancamento):ResponseEntity.notFound().build();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_CADASTRAR_LANCAMENTO') and #oauth2.hasScope('write')")
    public ResponseEntity<Lancamento> salvar(@Valid @RequestBody Lancamento lancamento, HttpServletResponse response){
        Lancamento lancamentoSalvo = service.salvar(lancamento);

        publisher.publishEvent(new RecursoCriadoEvent(this,response,lancamentoSalvo.getCodigo()));

        return ResponseEntity.status(HttpStatus.CREATED).body(lancamentoSalvo);
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAuthority('ROLE_REMOVER_LANCAMENTO') and #oauth2.hasScope('write')")
    public void remover(@PathVariable Long codigo) {
        repository.delete(codigo);
    }

    @ExceptionHandler({ PesssoaInexistenteException.class })
    public ResponseEntity<Object> handlePessoaInexistenteOuInativaException(PesssoaInexistenteException ex) {

        ApiErro apiErro = new ApiErro(HttpStatus.BAD_REQUEST,ex);

        return new ResponseEntity<>(apiErro, apiErro.getStatus());


    }

}
