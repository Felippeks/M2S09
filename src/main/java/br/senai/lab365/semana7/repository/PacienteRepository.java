package br.senai.lab365.semana7.repository;

import br.senai.lab365.semana7.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}