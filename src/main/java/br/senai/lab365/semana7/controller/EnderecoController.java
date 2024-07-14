package br.senai.lab365.semana7.controller;

import br.senai.lab365.semana7.controller.dto.EnderecoRequestDTO;
import br.senai.lab365.semana7.controller.dto.EnderecoResponseDTO;
import br.senai.lab365.semana7.entity.Endereco;
import br.senai.lab365.semana7.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<EnderecoResponseDTO> createEndereco(@RequestBody EnderecoRequestDTO enderecoRequestDTO) {
        Endereco endereco = enderecoService.createEndereco(enderecoRequestDTO.toEntity());
        return ResponseEntity.ok(new EnderecoResponseDTO(endereco.getId(), endereco.getLogradouro(), endereco.getEstado(), endereco.getCidade(), endereco.getNumero(), endereco.getCep()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnderecoResponseDTO> updateEndereco(@PathVariable Long id, @RequestBody EnderecoRequestDTO enderecoRequestDTO) {
        Endereco endereco = enderecoRequestDTO.toEntity();
        endereco.setId(id);
        Endereco updatedEndereco = enderecoService.updateEndereco(endereco);
        return ResponseEntity.ok(new EnderecoResponseDTO(updatedEndereco.getId(), updatedEndereco.getLogradouro(), updatedEndereco.getEstado(), updatedEndereco.getCidade(), updatedEndereco.getNumero(), updatedEndereco.getCep()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEndereco(@PathVariable Long id) {
        enderecoService.deleteEndereco(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<EnderecoResponseDTO>> getAllEnderecos() {
        List<Endereco> enderecos = enderecoService.getAllEnderecos();
        List<EnderecoResponseDTO> enderecoResponseDTOS = enderecos.stream().map(endereco -> new EnderecoResponseDTO(endereco.getId(), endereco.getLogradouro(), endereco.getEstado(), endereco.getCidade(), endereco.getNumero(), endereco.getCep())).collect(Collectors.toList());
        return ResponseEntity.ok(enderecoResponseDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoResponseDTO> getEnderecoById(@PathVariable Long id) {
        Endereco endereco = enderecoService.getEnderecoById(id);
        return ResponseEntity.ok(new EnderecoResponseDTO(endereco.getId(), endereco.getLogradouro(), endereco.getEstado(), endereco.getCidade(), endereco.getNumero(), endereco.getCep()));
    }
}