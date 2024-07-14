package br.senai.lab365.semana7.controller.dto;

import br.senai.lab365.semana7.entity.Paciente;

import java.util.Date;

public class PacienteRequestDTO {
    private String nome;
    private Date dataDeNascimento;
    private String cpf;
    private String telefone;
    private String email;
    private EnderecoRequestDTO endereco;

    public PacienteRequestDTO() {
    }

    public PacienteRequestDTO(String nome, Date dataDeNascimento, String cpf, String telefone, String email, EnderecoRequestDTO endereco) {
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EnderecoRequestDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoRequestDTO endereco) {
        this.endereco = endereco;
    }

    public Paciente toEntity() {
        Paciente paciente = new Paciente();
        paciente.setNome(this.nome);
        paciente.setDataDeNascimento(this.dataDeNascimento);
        paciente.setCpf(this.cpf);
        paciente.setTelefone(this.telefone);
        paciente.setEmail(this.email);
        if (this.endereco != null) {
            paciente.setEndereco(this.endereco.toEntity());
        }
        return paciente;
    }
}