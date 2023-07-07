package br.com.evandrolacerda.imoveisapi.imoveis.entity.filters;
import jakarta.persistence.criteria.*;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public class LocationWithinFilter extends BaseFilter implements Filter  {

    public LocationWithinFilter(List<Predicate> predicates, Root root, CriteriaBuilder criteriaBuilder, HttpServletRequest request) {
        super(predicates, root, criteriaBuilder, request);
    }

    /* is_within_distance(location, St_MakePoint(-49.18958, -25.5404342), 1000 ) = true
     * is_within_distance é uma função criada no postgresql para contornar a falta de suporte a geography pelo hibernate
     * CREATE OR REPLACE FUNCTION is_within_distance(
     *   point1 GEOMETRY(Point, 4326),
     *   point2 GEOMETRY(Point, 4326),
     *   distance_in_meters FLOAT8
     * )
     * RETURNS BOOLEAN AS $$
     * BEGIN
     *   RETURN ST_DWithin(
     *     point1::geography,
     *     point2::geography,
     *     distance_in_meters
     *   );
     * END;
     * $$ LANGUAGE plpgsql;
     */
    public void apply() {

        String lat = request.getParameter("lat");
        String lng = request.getParameter("lng");
        String distance = request.getParameter("distance");

        if ( lat != null && lng != null && distance != null ) {

            Expression<?> isWithinDistance = criteriaBuilder.function(
                    "is_within_distance",
                    Object.class,
                    root.get("location"),
                    criteriaBuilder.function(
                            "St_MakePoint",
                            Object.class,
                            criteriaBuilder.literal(Double.parseDouble(lng)),
                            criteriaBuilder.literal(Double.parseDouble(lat))
                    ),
                    criteriaBuilder.literal(Double.parseDouble(distance))
            );


            predicates.add(criteriaBuilder.isTrue((Expression<Boolean>) isWithinDistance));



        }

    }
}
