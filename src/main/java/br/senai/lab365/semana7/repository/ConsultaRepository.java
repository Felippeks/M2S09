package br.senai.lab365.semana7.repository;

import br.senai.lab365.semana7.entity.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
}