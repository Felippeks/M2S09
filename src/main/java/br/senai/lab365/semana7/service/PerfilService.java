package br.senai.lab365.semana7.service;

import br.senai.lab365.semana7.controller.dto.PerfilRequest;
import br.senai.lab365.semana7.entity.PerfilEntity;
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
        PerfilEntity perfilEntity = new PerfilEntity();
        perfilEntity.setNomePerfil(perfilRequest.nomePerfil());
        repository.save(perfilEntity);
    }

    public PerfilEntity validaPerfil(String nomePerfil){
        PerfilEntity perfil = repository.findByNomePerfil(nomePerfil)
                .orElseThrow(
                        () -> new RuntimeException("Perfil não existe com nome : " + nomePerfil)
                );
        return perfil;
    }
}
