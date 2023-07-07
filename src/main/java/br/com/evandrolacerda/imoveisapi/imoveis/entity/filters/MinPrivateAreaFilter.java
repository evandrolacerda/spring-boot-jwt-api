package br.com.evandrolacerda.imoveisapi.imoveis.entity.filters;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public class MinPrivateAreaFilter extends BaseFilter implements Filter {
    public MinPrivateAreaFilter(List<Predicate> predicates, Root root, CriteriaBuilder criteriaBuilder, HttpServletRequest request) {
        super(predicates, root, criteriaBuilder, request);
    }

    @Override
    public void apply() {

        String minPrivateArea = request.getParameter("min_private_area");

        if (minPrivateArea == null) {
            return;
        }

        predicates.add(
                criteriaBuilder.greaterThanOrEqualTo(root.get("privateArea"), Double.parseDouble(minPrivateArea))
        );
    }
}
