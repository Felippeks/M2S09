package br.senai.lab365.semana7.controller.dto;

import java.time.LocalDateTime;

public class ConsultaInfo {

    private LocalDateTime dateTime;
    private String nutricionistaName;
    private String pacienteName;

    public ConsultaInfo() {
    }

    public ConsultaInfo(LocalDateTime dateTime, String nutricionistaName, String pacienteName) {
        this.dateTime = dateTime;
        this.nutricionistaName = nutricionistaName;
        this.pacienteName = pacienteName;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getNutricionistaName() {
        return nutricionistaName;
    }

    public void setNutricionistaName(String nutricionistaName) {
        this.nutricionistaName = nutricionistaName;
    }

    public String getPacienteName() {
        return pacienteName;
    }

    public void setPacienteName(String pacienteName) {
        this.pacienteName = pacienteName;
    }
}