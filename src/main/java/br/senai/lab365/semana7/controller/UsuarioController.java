package br.senai.lab365.semana7.controller;

import br.senai.lab365.semana7.controller.dto.LoginRequest;
import br.senai.lab365.semana7.service.PerfilService;
import br.senai.lab365.semana7.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final PerfilService perfilService;


    @PostMapping("/cadastro")
    public ResponseEntity<String> cadastraUsuario(
            @RequestBody LoginRequest cadastroRequest
    ){
        usuarioService.cadastraUsuario(cadastroRequest);

        return new ResponseEntity<>("Usuario Criado",HttpStatus.CREATED);
    }
}
