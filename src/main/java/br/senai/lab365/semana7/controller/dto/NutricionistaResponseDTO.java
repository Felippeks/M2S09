package br.senai.lab365.semana7.controller.dto;

import br.senai.lab365.semana7.entity.Nutricionista;

import java.util.List;

public class NutricionistaResponseDTO {
    private Long id;
    private String crn;
    private String especialidade;
    private String nome;
    private int yearsOfExperience;
    private List<String> certifications;

    public NutricionistaResponseDTO() {
    }

    public NutricionistaResponseDTO(Long id, String crn, String especialidade, String nome, int yearsOfExperience, List<String> certifications) {
        this.id = id;
        this.crn = crn;
        this.especialidade = especialidade;
        this.nome = nome;
        this.yearsOfExperience = yearsOfExperience;
        this.certifications = certifications;
    }

    public NutricionistaResponseDTO(Nutricionista nutricionista) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}