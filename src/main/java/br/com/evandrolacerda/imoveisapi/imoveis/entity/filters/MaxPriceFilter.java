package br.com.evandrolacerda.imoveisapi.imoveis.entity.filters;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public class MaxPriceFilter extends BaseFilter implements Filter{
    public MaxPriceFilter(List<Predicate> predicates, Root root, CriteriaBuilder criteriaBuilder, HttpServletRequest request) {
        super(predicates, root, criteriaBuilder, request);
    }

    @Override
    public void apply() {

        String maxPrice = request.getParameter("max_price");

        if (maxPrice == null) {
            return;
        }

        predicates.add(
                criteriaBuilder.lessThanOrEqualTo(root.get("price"), Double.parseDouble(maxPrice))
        );
    }
}
