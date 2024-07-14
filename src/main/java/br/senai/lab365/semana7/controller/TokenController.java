package br.senai.lab365.semana7.controller;


import br.senai.lab365.semana7.controller.dto.LoginRequest;
import br.senai.lab365.semana7.controller.dto.LoginResponse;
import br.senai.lab365.semana7.entity.UsuarioEntity;
import br.senai.lab365.semana7.repository.UsuarioRepository;
import br.senai.lab365.semana7.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class TokenController {


    private final JwtEncoder jwtEncoder;
    private final UsuarioService usuarioService;

    private static long TEMPO_EXPIRACAO = 36000L;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> geraToken(
            @RequestBody LoginRequest loginRequest
    ){
        UsuarioEntity usuario = usuarioService.validarUsuario(loginRequest);
        Instant agora = Instant.now();
        String scope = usuario.getAuthorities().stream().map(autority -> autority.getAuthority()).collect(Collectors.joining(" "));

        JwtClaimsSet claims = JwtClaimsSet.builder().issuer("Self").issuedAt(agora).expiresAt(agora.plusSeconds(TEMPO_EXPIRACAO)).subject(usuario.getUsername()).claim("scope",scope).build();

        var valorjwt = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
        return ResponseEntity.ok(new LoginResponse(valorjwt, TEMPO_EXPIRACAO));
    }
}
