package br.com.evandrolacerda.imoveisapi.imoveis.entity.filters;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public class CityFilter extends BaseFilter implements Filter{


    public CityFilter(List<Predicate> predicates, Root root, CriteriaBuilder criteriaBuilder, HttpServletRequest request) {
        super(predicates, root, criteriaBuilder, request);
    }

    @Override
    public void apply() {

        String city = request.getParameter("city");
        if (city != null) {
            predicates.add(
                    criteriaBuilder.equal(root.get("city"), city)
            );
        }

    }
}
