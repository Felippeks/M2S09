package br.senai.lab365.semana7.service;

import br.senai.lab365.semana7.entity.Endereco;
import br.senai.lab365.semana7.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco createEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public Endereco updateEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public void deleteEndereco(Long id) {
        enderecoRepository.deleteById(id);
    }

    public List<Endereco> getAllEnderecos() {
        return enderecoRepository.findAll();
    }

    public Endereco getEnderecoById(Long id) {
        return enderecoRepository.findById(id).orElse(null);
    }
    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }
}