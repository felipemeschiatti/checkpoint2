package br.com.fiap.checkpoint2.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.fiap.checkpoint2.dto.ProfissionalRequestCreate;
import br.com.fiap.checkpoint2.dto.ProfissionalRequestUpdate;
import br.com.fiap.checkpoint2.model.Profissional;

@Service
public class ProfissionalService {
    private Long sequence = 1L;
    private List<Profissional> profissionais = new ArrayList<>();

    public Profissional create(ProfissionalRequestCreate dto) {
        Profissional p = dto.toModel();
        p.setId(sequence++);
        p.setCreatedAt(LocalDateTime.now());
        p.setUpdatedAt(LocalDateTime.now());
        profissionais.add(p);
        return p;
    }

    public Optional<Profissional> update(Long id, ProfissionalRequestUpdate dto) {
        return profissionais.stream()
            .filter(p -> p.getId().equals(id))
            .findFirst()
            .map(p -> {
                dto.toModel(p);
                p.setUpdatedAt(LocalDateTime.now());
                return p;
            });
    }

    public Optional<Profissional> getById(Long id) {
        return profissionais.stream()
            .filter(p -> p.getId().equals(id))
            .findFirst();
    }

    public List<Profissional> getAll() {
        return new ArrayList<>(profissionais);
    }

    public boolean delete(Long id) {
        return profissionais.removeIf(p -> p.getId().equals(id));
    }
}
