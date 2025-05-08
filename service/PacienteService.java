package br.com.fiap.checkpoint2.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.fiap.checkpoint2.dto.PacienteRequestCreate;
import br.com.fiap.checkpoint2.dto.PacienteRequestUpdate;
import br.com.fiap.checkpoint2.model.Paciente;

@Service
public class PacienteService {
    private Long sequence = 1L;
    private List<Paciente> pacientes = new ArrayList<>();

    public Paciente create(PacienteRequestCreate dto) {
        Paciente p = dto.toModel();
        p.setId(sequence++);
        p.setCreatedAt(LocalDateTime.now());
        p.setUpdatedAt(LocalDateTime.now());
        pacientes.add(p);
        return p;
    }

    public Optional<Paciente> update(Long id, PacienteRequestUpdate dto) {
        return pacientes.stream()
            .filter(p -> p.getId().equals(id))
            .findFirst()
            .map(p -> {
                dto.toModel(p);
                p.setUpdatedAt(LocalDateTime.now());
                return p;
            });
    }

    public Optional<Paciente> getById(Long id) {
        return pacientes.stream()
            .filter(p -> p.getId().equals(id))
            .findFirst();
    }

    public List<Paciente> getAll() {
        return new ArrayList<>(pacientes);
    }

    public boolean delete(Long id) {
        return pacientes.removeIf(p -> p.getId().equals(id));
    }
}