package br.com.evandrolacerda.imoveisapi.imoveis.entity.filters;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public class MaxPrivateAreaFilter extends BaseFilter implements Filter {

    public MaxPrivateAreaFilter(List<Predicate> predicates, Root root, CriteriaBuilder criteriaBuilder, HttpServletRequest request) {
        super(predicates, root, criteriaBuilder, request);
    }

    @Override
    public void apply() {
        String maxPrivateArea = request.getParameter("max_private_area");

        if (maxPrivateArea == null) {

            return;
        }

        predicates.add(
            criteriaBuilder.lessThanOrEqualTo(root.get("privateArea"), Double.parseDouble(maxPrivateArea))
        );
    }
}
