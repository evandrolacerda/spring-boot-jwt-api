package br.com.evandrolacerda.imoveisapi.repositories;

import br.com.evandrolacerda.imoveisapi.imoveis.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    UserDetails findByEmail(String email);


}
