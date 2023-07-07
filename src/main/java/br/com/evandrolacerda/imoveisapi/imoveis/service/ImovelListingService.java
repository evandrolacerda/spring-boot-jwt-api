package br.com.evandrolacerda.imoveisapi.imoveis.service;

import br.com.evandrolacerda.imoveisapi.imoveis.entity.Imovel;
import br.com.evandrolacerda.imoveisapi.imoveis.entity.filters.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class ImovelListingService {

    private final HttpServletRequest request;
    private int page;

    private int perPage;

    List<Filter> filters;


    private CriteriaBuilder criteriaBuilder;

    private CriteriaQuery<Imovel> criteriaQuery;

    private Root<Imovel> root;

    private List<Predicate> predicates = new ArrayList<>();

    private final EntityManager entityManager;


    public ImovelListingService(HttpServletRequest request, EntityManager entityManager) {
        this.request = request;
        this.entityManager = entityManager;
        this.page = 1;

        this.perPage = 20;

        if (this.request.getParameter("page") != null) {
            this.page = Integer.parseInt(this.request.getParameter("page"));
        }

        if (this.request.getParameter("per_page") != null) {
            this.perPage = Integer.parseInt(this.request.getParameter("per_page"));
        }

        this.criteriaBuilder = this.entityManager.getCriteriaBuilder();
        this.criteriaQuery = criteriaBuilder.createQuery(Imovel.class);
        this.root = criteriaQuery.from(Imovel.class);


        this.filters = getAllowedFilters();

        for (Filter filter : filters) {
            filter.apply();
        }

    }



    private int getCountAllResults() {
        return 0;
    }

    public List<Imovel> getResults() {


        criteriaQuery.where(predicates.toArray(new Predicate[0]));

        List<Imovel> imoveis = entityManager.createQuery(criteriaQuery)
                .setFirstResult((page - 1) * perPage )
                .setMaxResults( perPage )
                .getResultList();

        return imoveis;
    }

    private List<Filter> getAllowedFilters()  {

        List<String> classNames = new ArrayList<>();
        classNames.add("br.com.evandrolacerda.imoveisapi.imoveis.entity.filters.CityFilter");
        classNames.add("br.com.evandrolacerda.imoveisapi.imoveis.entity.filters.LocationWithinFilter");
        classNames.add("br.com.evandrolacerda.imoveisapi.imoveis.entity.filters.MaxPriceFilter");
        classNames.add("br.com.evandrolacerda.imoveisapi.imoveis.entity.filters.MaxPrivateAreaFilter");
        classNames.add("br.com.evandrolacerda.imoveisapi.imoveis.entity.filters.MinPriceFilter");
        classNames.add("br.com.evandrolacerda.imoveisapi.imoveis.entity.filters.MinPrivateAreaFilter");
        classNames.add("br.com.evandrolacerda.imoveisapi.imoveis.entity.filters.NeighborhoodFilter");
        classNames.add("br.com.evandrolacerda.imoveisapi.imoveis.entity.filters.StateFilter");
        classNames.add("br.com.evandrolacerda.imoveisapi.imoveis.entity.filters.TypeFilter");
        classNames.add("br.com.evandrolacerda.imoveisapi.imoveis.entity.filters.UpdatedAtMaxFilter");
        classNames.add("br.com.evandrolacerda.imoveisapi.imoveis.entity.filters.UpdatedAtMinFilter");



        List<Filter> filters =  new ArrayList<>();

        for ( String className : classNames ) {
            try {
                Class<?> clazz = Class.forName(className);
                Constructor<?> constructor = clazz.getConstructor(
                        List.class, Root.class, CriteriaBuilder.class, HttpServletRequest.class
                );
                Filter instance = (Filter) constructor.newInstance(
                        predicates, root, criteriaBuilder, request
                );
                filters.add( instance);
            } catch (ReflectiveOperationException e) {
                e.printStackTrace();
            }
        }

        return filters;

    }
}
