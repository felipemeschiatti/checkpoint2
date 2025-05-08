package br.com.fiap.checkpoint2.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.checkpoint2.dto.Paciente.PacienteRequestCreate;
import br.com.fiap.checkpoint2.dto.Paciente.PacienteRequestUpdate;
import br.com.fiap.checkpoint2.dto.Paciente.PacienteResponse;
import br.com.fiap.checkpoint2.service.PacienteService;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService service;

    @PostMapping
    public ResponseEntity<PacienteResponse> create(@RequestBody PacienteRequestCreate dto) {
        Paciente p = service.create(dto);
        return ResponseEntity.status(201)
                             .body(new PacienteResponse().toDto(p));
    }

    @GetMapping
    public ResponseEntity<List<PacienteResponse>> findAll() {
        List<PacienteResponse> list = service.getAll().stream()
            .map(p -> new PacienteResponse().toDto(p))
            .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteResponse> findById(@PathVariable Long id) {
        return service.getById(id)
            .map(p -> ResponseEntity.ok(new PacienteResponse().toDto(p)))
            .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteResponse> update(
            @PathVariable Long id,
            @RequestBody PacienteRequestUpdate dto) {

        return service.update(id, dto)
            .map(p -> ResponseEntity.ok(new PacienteResponse().toDto(p)))
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean removed = service.delete(id);
        return removed
            ? ResponseEntity.noContent().build()
            : ResponseEntity.notFound().build();
    }
}