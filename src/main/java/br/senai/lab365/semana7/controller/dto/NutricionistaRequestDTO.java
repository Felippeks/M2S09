package br.senai.lab365.semana7.controller.dto;

import br.senai.lab365.semana7.entity.Nutricionista;

import java.util.List;

public class NutricionistaRequestDTO {
    private String crn;
    private String especialidade;
    private String nome;
    private int yearsOfExperience;
    private List<String> certifications;

    public NutricionistaRequestDTO() {
    }

    public NutricionistaRequestDTO(String crn, String especialidade, String nome, int yearsOfExperience, List<String> certifications) {
        this.crn = crn;
        this.especialidade = especialidade;
        this.nome = nome;
        this.yearsOfExperience = yearsOfExperience;
        this.certifications = certifications;
    }

    public String getCrn() {
        return crn;
    }

    public void setCrn(String crn) {
        this.crn = crn;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public List<String> getCertifications() {
        return certifications;
    }

    public void setCertifications(List<String> certifications) {
        this.certifications = certifications;
    }

    public Nutricionista toEntity() {
        Nutricionista nutricionista = new Nutricionista();
        nutricionista.setCrn(this.crn);
        nutricionista.setEspecialidade(this.especialidade);
        nutricionista.setNome(this.nome);
        nutricionista.setYearsOfExperience(this.yearsOfExperience);
        nutricionista.setCertifications(this.certifications);
        return nutricionista;
    }
}