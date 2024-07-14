package br.senai.lab365.semana7.service;

import br.senai.lab365.semana7.controller.dto.LoginRequest;
import br.senai.lab365.semana7.entity.Role;
import br.senai.lab365.semana7.entity.UsuarioEntity;
import br.senai.lab365.semana7.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final BCryptPasswordEncoder passwordEncoder;
    private final UsuarioRepository usuarioRepository;
    private final PerfilService perfilService;

    public UsuarioEntity validaUsuario(
            LoginRequest loginRequest
    ){
        UsuarioEntity usuarioEntity = usuarioRepository
                .findByUsername(loginRequest.username())
                .orElseThrow(
                        ()->new RuntimeException("Usuário não existe com o nome "
                                +loginRequest.username())
                );
        if(!passwordEncoder.matches(loginRequest.password(),usuarioEntity.getPassword())){
            throw new RuntimeException("Senha errada para usuario com nome "
                    + loginRequest.username());
        }
        return usuarioEntity;
    }

    public void cadastraUsuario(LoginRequest cadastroRequest) {
        if (usuarioRepository.findByUsername(cadastroRequest.username())
                        .isPresent()){
            throw new RuntimeException("Usuário existe com nome: "+cadastroRequest.username());
        }
        Role role = perfilService.validaPerfil(cadastroRequest.nomePerfil());

        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setUsername(cadastroRequest.username());
        usuarioEntity.setPassword(passwordEncoder.encode(cadastroRequest.password()));
        usuarioEntity.setRoleList(Set.of(role));

        usuarioRepository.save(usuarioEntity);
    }
}
