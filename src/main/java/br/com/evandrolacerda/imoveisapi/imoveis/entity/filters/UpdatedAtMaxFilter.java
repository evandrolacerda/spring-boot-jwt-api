package br.com.evandrolacerda.imoveisapi.imoveis.entity.filters;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.servlet.http.HttpServletRequest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class UpdatedAtMaxFilter extends BaseFilter implements Filter{
    public UpdatedAtMaxFilter(List<Predicate> predicates, Root root, CriteriaBuilder criteriaBuilder, HttpServletRequest request) {
        super(predicates, root, criteriaBuilder, request);
    }

    @Override
    public void apply() {
        String updatedAtMax = request.getParameter("updated_at_max");
        if( updatedAtMax == null ){
            return;
        }


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate data = LocalDate.parse( updatedAtMax, formatter );
        predicates.add(
                criteriaBuilder.lessThanOrEqualTo( root.get("updatedAt"), data )
        );
    }
}
