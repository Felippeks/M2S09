package br.senai.lab365.semana7.controller.dto;

import br.senai.lab365.semana7.entity.Paciente;

public class PacienteResponseDTO {
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private EnderecoResponseDTO endereco;

    public PacienteResponseDTO() {
    }

    public PacienteResponseDTO(Long id, String nome, String cpf, String email, String telefone, EnderecoResponseDTO endereco) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public PacienteResponseDTO(Paciente paciente) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public EnderecoResponseDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoResponseDTO endereco) {
        this.endereco = endereco;
    }

}