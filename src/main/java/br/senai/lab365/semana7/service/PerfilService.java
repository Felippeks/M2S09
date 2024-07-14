package br.senai.lab365.semana7.service;

import br.senai.lab365.semana7.controller.dto.PerfilRequest;
import br.senai.lab365.semana7.entity.Role;
import br.senai.lab365.semana7.repository.PerfilRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PerfilService {
    private final PerfilRepository repository;

    public void cadastraPerfil(PerfilRequest perfilRequest) {
        if (repository.findByNomePerfil(perfilRequest.nomePerfil()).isPresent()) {
            throw
                    new RuntimeException("Perfil já existe com o nome :" + perfilRequest.nomePerfil());
        }
        Role role = new Role();
        role.setNomePerfil(perfilRequest.nomePerfil());
        repository.save(role);
    }

    public Role validaPerfil(String nomePerfil){
        Role perfil = repository.findByNomePerfil(nomePerfil)
                .orElseThrow(
                        () -> new RuntimeException("Perfil não existe com nome : " + nomePerfil)
                );
        return perfil;
    }
}
