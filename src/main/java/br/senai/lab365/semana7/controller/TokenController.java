package br.senai.lab365.semana7.controller;

import br.senai.lab365.semana7.controller.dto.LoginRequest;
import br.senai.lab365.semana7.controller.dto.LoginResponse;
import br.senai.lab365.semana7.entity.UsuarioEntity;
import br.senai.lab365.semana7.service.UsuarioService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
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
        UsuarioEntity usuarioEntity = usuarioService.validaUsuario(loginRequest);
        Instant agora = Instant.now();
        String scope = usuarioEntity.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(agora)
                .expiresAt(agora.plusSeconds(TEMPO_EXPIRACAO))
                .subject(usuarioEntity.getUsername())
                .claim("scope", scope)
                .build();
        var valorJwt = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
        return ResponseEntity.ok(new LoginResponse(valorJwt, TEMPO_EXPIRACAO));
    }

}
