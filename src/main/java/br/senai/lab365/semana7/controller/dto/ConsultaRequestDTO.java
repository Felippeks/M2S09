package br.senai.lab365.semana7.controller.dto;

import java.util.Date;

public class ConsultaRequestDTO {
    private Date dataDaConsulta;
    private String observacoes;
    private NutricionistaRequestDTO nutricionista;
    private PacienteRequestDTO paciente;

    public ConsultaRequestDTO() {
    }

    public ConsultaRequestDTO(Date dataDaConsulta, String observacoes, NutricionistaRequestDTO nutricionista, PacienteRequestDTO paciente) {
        this.dataDaConsulta = dataDaConsulta;
        this.observacoes = observacoes;
        this.nutricionista = nutricionista;
        this.paciente = paciente;
    }

    public Date getDataDaConsulta() {
        return dataDaConsulta;
    }

    public void setDataDaConsulta(Date dataDaConsulta) {
        this.dataDaConsulta = dataDaConsulta;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public NutricionistaRequestDTO getNutricionista() {
        return nutricionista;
    }

    public void setNutricionista(NutricionistaRequestDTO nutricionista) {
        this.nutricionista = nutricionista;
    }

    public PacienteRequestDTO getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteRequestDTO paciente) {
        this.paciente = paciente;
    }
}