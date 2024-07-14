package br.senai.lab365.semana7.service;

import br.senai.lab365.semana7.controller.dto.ConsultaInfo;
import br.senai.lab365.semana7.entity.Consulta;
import br.senai.lab365.semana7.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    public List<ConsultaInfo> getAllConsultasInfo() {
        return consultaRepository.findAll().stream()
                .map(consulta -> {
                    LocalDateTime dateTime = consulta.getDataDaConsulta().toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDateTime();
                    return new ConsultaInfo(
                            dateTime,
                            consulta.getNutricionista().getNome(),
                            consulta.getPaciente().getNome());
                })
                .collect(Collectors.toList());
    }

    public Consulta createConsulta(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    public Consulta updateConsulta(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    public void deleteConsulta(Long id) {
        consultaRepository.deleteById(id);
    }

    public List<Consulta> getAllConsultas() {
        return consultaRepository.findAll();
    }

    public Consulta getConsultaById(Long id) {
        return consultaRepository.findById(id).orElse(null);
    }

    public ConsultaService(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }
}