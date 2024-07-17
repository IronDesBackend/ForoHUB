package com.aluracursos.Challenge.foroHub.Challenge_ForoHub.controller;

import com.aluracursos.Challenge.foroHub.Challenge_ForoHub.dto.DetailsAutenticacion;
import com.aluracursos.Challenge.foroHub.Challenge_ForoHub.dto.DetailsToken;
import com.aluracursos.Challenge.foroHub.Challenge_ForoHub.infra.security.TokenService;
import com.aluracursos.Challenge.foroHub.Challenge_ForoHub.models.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity verificarLogin(@RequestBody @Valid DetailsAutenticacion detailsAutenticacion) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(
                detailsAutenticacion.login(),
                detailsAutenticacion.password()
        );

        var autenticacion = authenticationManager.authenticate(authenticationToken);

        var tokenJWT = tokenService.generarToken((User) autenticacion.getPrincipal());

        return ResponseEntity.ok(new DetailsToken(tokenJWT));
    }
}
