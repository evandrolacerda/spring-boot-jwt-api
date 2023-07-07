package br.com.evandrolacerda.imoveisapi.imoveis.entity.filters;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public class StateFilter extends BaseFilter implements Filter{
    public StateFilter(List<Predicate> predicates, Root root, CriteriaBuilder criteriaBuilder, HttpServletRequest request) {
        super(predicates, root, criteriaBuilder, request);
    }

    @Override
    public void apply() {
        String state = request.getParameter("state");
        if (state != null) {
            predicates.add(
                    criteriaBuilder.equal(root.get("state"), state)
            );
        }
    }
}
