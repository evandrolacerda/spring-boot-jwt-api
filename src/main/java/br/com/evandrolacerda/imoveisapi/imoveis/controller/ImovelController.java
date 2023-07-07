package br.com.evandrolacerda.imoveisapi.imoveis.controller;


import br.com.evandrolacerda.imoveisapi.imoveis.entity.Imovel;
import br.com.evandrolacerda.imoveisapi.imoveis.service.ImovelListingService;
import jakarta.persistence.EntityManager;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping( "/imoveis" )
public class ImovelController {

    @Autowired
    EntityManager entityManager;

    @GetMapping("/")
    public @ResponseBody List<Imovel> index(HttpServletRequest request) {

        ImovelListingService service = new ImovelListingService(request, entityManager );

        return service.getResults();
    }
}
