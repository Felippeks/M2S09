package br.senai.lab365.semana7.controller;

import br.senai.lab365.semana7.controller.dto.ConsultaRequestDTO;
import br.senai.lab365.semana7.controller.dto.ConsultaResponseDTO;
import br.senai.lab365.semana7.controller.dto.NutricionistaResponseDTO;
import br.senai.lab365.semana7.controller.dto.PacienteResponseDTO;
import br.senai.lab365.semana7.entity.Consulta;
import br.senai.lab365.semana7.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @PostMapping
    public ResponseEntity<ConsultaResponseDTO> createConsulta(@RequestBody ConsultaRequestDTO consultaRequestDTO) {
        Consulta consulta = new Consulta(null, consultaRequestDTO.getDataDaConsulta(), consultaRequestDTO.getObservacoes(), consultaRequestDTO.getNutricionista().toEntity(), consultaRequestDTO.getPaciente().toEntity());
        Consulta createdConsulta = consultaService.createConsulta(consulta);
        return ResponseEntity.ok(new ConsultaResponseDTO(createdConsulta.getId(), createdConsulta.getDataDaConsulta(), createdConsulta.getObservacoes(), new NutricionistaResponseDTO(createdConsulta.getNutricionista()), new PacienteResponseDTO(createdConsulta.getPaciente())));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsultaResponseDTO> updateConsulta(@PathVariable Long id, @RequestBody ConsultaRequestDTO consultaRequestDTO) {
        Consulta consulta = new Consulta(id, consultaRequestDTO.getDataDaConsulta(), consultaRequestDTO.getObservacoes(), consultaRequestDTO.getNutricionista().toEntity(), consultaRequestDTO.getPaciente().toEntity());
        Consulta updatedConsulta = consultaService.updateConsulta(consulta);
        return ResponseEntity.ok(new ConsultaResponseDTO(updatedConsulta.getId(), updatedConsulta.getDataDaConsulta(), updatedConsulta.getObservacoes(), new NutricionistaResponseDTO(updatedConsulta.getNutricionista()), new PacienteResponseDTO(updatedConsulta.getPaciente())));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConsulta(@PathVariable Long id) {
        consultaService.deleteConsulta(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ConsultaResponseDTO>> getAllConsultas() {
        List<Consulta> consultas = consultaService.getAllConsultas();
        List<ConsultaResponseDTO> consultaResponseDTOS = consultas.stream().map(consulta -> new ConsultaResponseDTO(consulta.getId(), consulta.getDataDaConsulta(), consulta.getObservacoes(), new NutricionistaResponseDTO(consulta.getNutricionista()), new PacienteResponseDTO(consulta.getPaciente()))).collect(Collectors.toList());
        return ResponseEntity.ok(consultaResponseDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultaResponseDTO> getConsultaById(@PathVariable Long id) {
        Consulta consulta = consultaService.getConsultaById(id);
        return ResponseEntity.ok(new ConsultaResponseDTO(consulta.getId(), consulta.getDataDaConsulta(), consulta.getObservacoes(), new NutricionistaResponseDTO(consulta.getNutricionista()), new PacienteResponseDTO(consulta.getPaciente())));
    }
}