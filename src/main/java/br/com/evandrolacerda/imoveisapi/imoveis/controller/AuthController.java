package br.com.evandrolacerda.imoveisapi.imoveis.controller;

import br.com.evandrolacerda.imoveisapi.dto.AuthDTO;
import br.com.evandrolacerda.imoveisapi.dto.LoginResponseDTO;
import br.com.evandrolacerda.imoveisapi.dto.RegisterDTO;
import br.com.evandrolacerda.imoveisapi.imoveis.entity.User;
import br.com.evandrolacerda.imoveisapi.imoveis.service.TokenService;
import br.com.evandrolacerda.imoveisapi.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    protected AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthDTO authDto) {

        var usernamePassword = new UsernamePasswordAuthenticationToken( authDto.email(), authDto.password() );
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken( (User) auth.getPrincipal() );

        var response = new LoginResponseDTO( token );
        return ResponseEntity.ok( response );

    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO registerDTO) {

        if( userRepository.findByEmail( registerDTO.email() ) != null ){
            return ResponseEntity.badRequest().build();
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode( registerDTO.password() );

        User newUser = new User( registerDTO.email(), encryptedPassword, registerDTO.name(), registerDTO.role() );

        userRepository.save( newUser );

        return ResponseEntity.ok().build();

    }
}
