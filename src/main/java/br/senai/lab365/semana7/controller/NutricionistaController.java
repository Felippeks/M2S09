package br.senai.lab365.semana7.controller;

import br.senai.lab365.semana7.controller.dto.NutricionistaRequestDTO;
import br.senai.lab365.semana7.controller.dto.NutricionistaResponseDTO;
import br.senai.lab365.semana7.entity.Nutricionista;
import br.senai.lab365.semana7.service.NutricionistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/nutricionistas")
public class NutricionistaController {

    @Autowired
    private NutricionistaService nutricionistaService;

    @PreAuthorize("hasAnyAuthority('NUTRICIONISTA') or hasAnyAuthority('ADMIN')")
    @PostMapping
    public ResponseEntity<NutricionistaResponseDTO> createNutricionista(@RequestBody NutricionistaRequestDTO nutricionistaRequestDTO) {
        Nutricionista nutricionista = new Nutricionista(null, nutricionistaRequestDTO.getCrn(), nutricionistaRequestDTO.getEspecialidade(), nutricionistaRequestDTO.getNome(), nutricionistaRequestDTO.getYearsOfExperience(), nutricionistaRequestDTO.getCertifications());
        Nutricionista createdNutricionista = nutricionistaService.createNutricionista(nutricionista);
        return ResponseEntity.ok(new NutricionistaResponseDTO(createdNutricionista.getId(), createdNutricionista.getCrn(), createdNutricionista.getEspecialidade(), createdNutricionista.getNome(), createdNutricionista.getYearsOfExperience(), createdNutricionista.getCertifications()));
    }

    @PreAuthorize("hasAnyAuthority('NUTRICIONISTA') or hasAnyAuthority('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<NutricionistaResponseDTO> updateNutricionista(@PathVariable Long id, @RequestBody NutricionistaRequestDTO nutricionistaRequestDTO) {
        Nutricionista nutricionista = new Nutricionista(id, nutricionistaRequestDTO.getCrn(), nutricionistaRequestDTO.getEspecialidade(), nutricionistaRequestDTO.getNome(), nutricionistaRequestDTO.getYearsOfExperience(), nutricionistaRequestDTO.getCertifications());
        Nutricionista updatedNutricionista = nutricionistaService.updateNutricionista(nutricionista);
        return ResponseEntity.ok(new NutricionistaResponseDTO(updatedNutricionista.getId(), updatedNutricionista.getCrn(), updatedNutricionista.getEspecialidade(), updatedNutricionista.getNome(), updatedNutricionista.getYearsOfExperience(), updatedNutricionista.getCertifications()));
    }

    @PreAuthorize("hasAnyAuthority('NUTRICIONISTA') or hasAnyAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNutricionista(@PathVariable Long id) {
        nutricionistaService.deleteNutricionista(id);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasAuthority('NUTRICIONISTA') or hasAuthority('ADMIN') or hasAuthority('PACIENTE')")
    @GetMapping
    public ResponseEntity<List<NutricionistaResponseDTO>> getAllNutricionistas() {
        List<Nutricionista> nutricionistas = nutricionistaService.getAllNutricionistas();
        List<NutricionistaResponseDTO> nutricionistaResponseDTOS = nutricionistas.stream().map(nutricionista -> new NutricionistaResponseDTO(nutricionista.getId(), nutricionista.getCrn(), nutricionista.getEspecialidade(), nutricionista.getNome(), nutricionista.getYearsOfExperience(), nutricionista.getCertifications())).collect(Collectors.toList());
        return ResponseEntity.ok(nutricionistaResponseDTOS);
    }

    @PreAuthorize("hasAuthority('NUTRICIONISTA') or hasAuthority('ADMIN') or hasAuthority('PACIENTE')")
    @GetMapping("/{id}")
    public ResponseEntity<NutricionistaResponseDTO> getNutricionistaById(@PathVariable Long id) {
        Nutricionista nutricionista = nutricionistaService.getNutricionistaById(id);
        return ResponseEntity.ok(new NutricionistaResponseDTO(nutricionista.getId(), nutricionista.getCrn(), nutricionista.getEspecialidade(), nutricionista.getNome(), nutricionista.getYearsOfExperience(), nutricionista.getCertifications()));
    }

    @PatchMapping("/{id}/experience")
    public ResponseEntity<NutricionistaResponseDTO> addYearToExperience(@PathVariable Long id) {
        Nutricionista updatedNutricionista = nutricionistaService.addYearToExperience(id);
        return ResponseEntity.ok(new NutricionistaResponseDTO(updatedNutricionista.getId(), updatedNutricionista.getCrn(), updatedNutricionista.getEspecialidade(), updatedNutricionista.getNome(), updatedNutricionista.getYearsOfExperience(), updatedNutricionista.getCertifications()));
    }

    @PatchMapping("/{id}/certifications")
    public ResponseEntity<NutricionistaResponseDTO> addCertification(@PathVariable Long id, @RequestBody String certification) {
        Nutricionista updatedNutricionista = nutricionistaService.addCertification(id, certification);
        return ResponseEntity.ok(new NutricionistaResponseDTO(updatedNutricionista.getId(), updatedNutricionista.getCrn(), updatedNutricionista.getEspecialidade(), updatedNutricionista.getNome(), updatedNutricionista.getYearsOfExperience(), updatedNutricionista.getCertifications()));
    }
}