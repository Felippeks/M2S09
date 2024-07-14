package br.senai.lab365.semana7.repository;

import br.senai.lab365.semana7.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}