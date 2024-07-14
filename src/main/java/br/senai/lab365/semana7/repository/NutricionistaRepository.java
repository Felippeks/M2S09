package br.senai.lab365.semana7.repository;

import br.senai.lab365.semana7.entity.Nutricionista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NutricionistaRepository extends JpaRepository<Nutricionista, Long> {
    Optional<Nutricionista> findByNome(String nome);
}