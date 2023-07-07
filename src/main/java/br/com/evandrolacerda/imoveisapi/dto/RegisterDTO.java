package br.com.evandrolacerda.imoveisapi.dto;

import br.com.evandrolacerda.imoveisapi.imoveis.entity.UserRole;

public record RegisterDTO(String email, String password, String name, UserRole role ) {
}
