package com.chronos.money.api.repository.lancamento;

import com.chronos.money.api.model.Categoria_;
import com.chronos.money.api.model.Lancamento;
import com.chronos.money.api.model.Lancamento_;
import com.chronos.money.api.model.Pessoa_;
import com.chronos.money.api.repository.filter.LancamentoFilter;
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
public class LancamentoRepositoryImpl implements LancamentoRepositoryQuery {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Page<Lancamento> filtrar(LancamentoFilter filtros, Pageable pageable) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Lancamento> criteria = builder.createQuery(Lancamento.class);
        Root<Lancamento> root = criteria.from(Lancamento.class);




        //Cria as restriçoes
        Predicate[] predicates = criarRestricoes(filtros,builder,root);
        criteria.where(predicates);
        Long total = getTotais(filtros);
        TypedQuery<Lancamento> query = em.createQuery(criteria);

        addRestricoesPaginacao(query,pageable);


        return new PageImpl<>(query.getResultList(),pageable,total) ;
    }


    @Override
    public Page<ResumoLancamento> resumir(LancamentoFilter lancamentoFilter, Pageable pageable) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<ResumoLancamento> criteria = builder.createQuery(ResumoLancamento.class);
        Root<Lancamento> root = criteria.from(Lancamento.class);

        criteria.select(builder.construct(ResumoLancamento.class
                , root.get(Lancamento_.codigo), root.get(Lancamento_.descricao)
                , root.get(Lancamento_.dataVencimento), root.get(Lancamento_.dataPagamento)
                , root.get(Lancamento_.valor), root.get(Lancamento_.tipo)
                , root.get(Lancamento_.categoria).get(Categoria_.nome)
                , root.get(Lancamento_.pessoa).get(Pessoa_.nome)));

        Predicate[] predicates = criarRestricoes(lancamentoFilter, builder, root);
        criteria.where(predicates);

        TypedQuery<ResumoLancamento> query = em.createQuery(criteria);
        addRestricoesPaginacao(query, pageable);

        return new PageImpl<>(query.getResultList(), pageable, getTotais(lancamentoFilter));
    }

    private Predicate[] criarRestricoes(LancamentoFilter filtros, CriteriaBuilder builder, Root<Lancamento> root) {

        List<Predicate> predicates = new ArrayList<>();

        if(!StringUtils.isEmpty(filtros.getDescricao())){

            predicates.add(builder.like(builder.lower(root.get("descricao")),"%"+filtros.getDescricao().toLowerCase()+"%"));
        }

        if(filtros.getDataVencimentoDe()!=null){
            predicates.add(builder.greaterThanOrEqualTo(root.get("dataVencimento"),filtros.getDataVencimentoDe()));
        }

        if(filtros.getGetDataVencimentoAte()!=null){
            predicates.add(builder.lessThanOrEqualTo(root.get("dataVencimento"),filtros.getGetDataVencimentoAte()));
        }

        return predicates.toArray(new Predicate[predicates.size()]);

    }

    private Long getTotais(LancamentoFilter filtros){
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root<Lancamento> root = criteria.from(Lancamento.class);

        //Cria as restriçoes
        Predicate[] predicates = criarRestricoes(filtros,builder,root);
        criteria.where(predicates);
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
