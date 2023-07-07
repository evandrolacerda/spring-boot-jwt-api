package br.com.evandrolacerda.imoveisapi.imoveis.entity.filters;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.servlet.http.HttpServletRequest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class UpdatedAtMinFilter extends BaseFilter implements Filter{

    public UpdatedAtMinFilter(List<Predicate> predicates, Root root, CriteriaBuilder criteriaBuilder, HttpServletRequest request) {
        super(predicates, root, criteriaBuilder, request);
    }

    @Override
    public void apply() {
        String updatedAtMin = request.getParameter("updated_at_min");

        if( updatedAtMin == null ){
            return;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate data = LocalDate.parse( updatedAtMin, formatter );
        predicates.add(
                criteriaBuilder.greaterThanOrEqualTo( root.get("updatedAt"), data )
        );
    }
}
