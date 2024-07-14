package br.senai.lab365.semana7.service;


import br.senai.lab365.semana7.controller.dto.LoginRequest;
import br.senai.lab365.semana7.entity.UsuarioEntity;
import br.senai.lab365.semana7.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UsuarioEntity validarUsuario(LoginRequest loginRequest) {
        UsuarioEntity usuario = usuarioRepository.findByUsername(loginRequest.username())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        if(!passwordEncoder.matches(loginRequest.password(), usuario.getPassword())){
            throw new RuntimeException("Senha inválida");
        }
        return usuario;
    }
}
