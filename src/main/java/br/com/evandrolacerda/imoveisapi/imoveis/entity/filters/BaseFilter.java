package br.com.evandrolacerda.imoveisapi.imoveis.entity.filters;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public abstract class BaseFilter {

    protected final List<Predicate> predicates;
    protected final Root root;
    protected final CriteriaBuilder criteriaBuilder;
    protected final HttpServletRequest request;

    public BaseFilter(List<Predicate> predicates, Root root, CriteriaBuilder criteriaBuilder, HttpServletRequest request ) {

        this.predicates = predicates;
        this.root = root;
        this.criteriaBuilder = criteriaBuilder;
        this.request = request;
    }



}
