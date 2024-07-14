package br.senai.lab365.semana7.controller.dto;

import br.senai.lab365.semana7.entity.Endereco;

public class EnderecoRequestDTO {
    private String logradouro;
    private String estado;
    private String cidade;
    private String numero;
    private String cep;

    public EnderecoRequestDTO() {
    }

    public EnderecoRequestDTO(String logradouro, String estado, String cidade, String numero, String cep) {
        this.logradouro = logradouro;
        this.estado = estado;
        this.cidade = cidade;
        this.numero = numero;
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Endereco toEntity() {
        Endereco endereco = new Endereco();
        endereco.setLogradouro(this.logradouro);
        endereco.setEstado(this.estado);
        endereco.setCidade(this.cidade);
        endereco.setNumero(this.numero);
        endereco.setCep(this.cep);
        return endereco;
    }
}