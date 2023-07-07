package br.com.evandrolacerda.imoveisapi.imoveis.entity.filters;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public class MinPriceFilter extends BaseFilter implements Filter {


    public MinPriceFilter(List<Predicate> predicates, Root root, CriteriaBuilder criteriaBuilder, HttpServletRequest request) {
        super(predicates, root, criteriaBuilder, request);
    }

    @Override
    public void apply() {

        String minPrice = request.getParameter("min_price");

        if (minPrice == null) {
            return;
        }

        predicates.add(
                criteriaBuilder.greaterThanOrEqualTo(root.get("price"), Double.parseDouble(minPrice))
        );

    }
}
