package com.chronos.money.api.repository.pessoa;

import com.chronos.money.api.model.*;
import com.chronos.money.api.repository.filter.LancamentoFilter;
import com.chronos.money.api.repository.lancamento.LancamentoRepositoryQuery;
import com.chronos.money.api.repository.projection.ResumoLancamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by john on 13/10/17.
 */
public class PessoaRepositoryImpl implements PessoaRepositoryQuery {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Page<Pessoa> filtrar(String nome, Pageable pageable) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Pessoa> criteria = builder.createQuery(Pessoa.class);
        Root<Pessoa> root = criteria.from(Pessoa.class);




        //Cria as restriçoes
        Predicate[] predicates = criarRestricoes(nome,builder,root);
        criteria.where(predicates);
        Long total = getTotais(nome);
        TypedQuery<Pessoa> query = em.createQuery(criteria);

        addRestricoesPaginacao(query,pageable);


        return new PageImpl<>(query.getResultList(),pageable,total) ;
    }




    private Predicate[] criarRestricoes(String nome, CriteriaBuilder builder, Root<Pessoa> root) {

        List<Predicate> predicates = new ArrayList<>();

        if(!StringUtils.isEmpty(nome)){

            predicates.add(builder.like(builder.lower(root.get("nome")),"%"+nome.toLowerCase()+"%"));
        }


        return predicates.toArray(new Predicate[predicates.size()]);

    }

    private Long getTotais(String nome){
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root<Pessoa> root = criteria.from(Pessoa.class);

        //Cria as restriçoes
        Predicate[] predicates = criarRestricoes(nome,builder,root);
        criteria.where(predicates);
        criteria.select(builder.count(root));
        return em.createQuery(criteria).getSingleResult();
    }

    private void addRestricoesPaginacao(TypedQuery<?> query,Pageable pageable){
        int paginaAtual = pageable.getPageNumber();
        int totalRegistrosPorPagia = pageable.getPageSize();
        int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagia;
        query.setFirstResult(primeiroRegistroDaPagina);
        query.setMaxResults(totalRegistrosPorPagia);

    }
}
