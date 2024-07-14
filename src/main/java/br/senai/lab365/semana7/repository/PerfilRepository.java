package br.senai.lab365.semana7.repository;

import br.senai.lab365.semana7.entity.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PerfilRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByNomePerfil(String nomePerfil);
}

