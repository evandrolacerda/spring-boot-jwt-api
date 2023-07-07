package br.com.evandrolacerda.imoveisapi.imoveis.entity.filters;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public final class TypeFilter extends BaseFilter implements Filter {

    public TypeFilter(List<Predicate> predicates, Root root, CriteriaBuilder criteriaBuilder, HttpServletRequest request) {
        super(predicates, root, criteriaBuilder, request);
    }

    @Override
    public void apply() {
        String type = request.getParameter("type");
        if (type != null) {
            predicates.add(
                    criteriaBuilder.equal(root.get("type"), type)
            );
        }
    }

}
