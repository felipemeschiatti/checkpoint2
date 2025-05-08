package br.com.fiap.checkpoint2.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.fiap.checkpoint2.dto.ProfissionalRequestCreate;
import br.com.fiap.checkpoint2.dto.ProfissionalRequestUpdate;
import br.com.fiap.checkpoint2.dto.ProfissionalResponse;
import br.com.fiap.checkpoint2.model.Profissional;
import br.com.fiap.checkpont2.service.ProfissionalService;

@RestController
@RequestMapping("/profissionais")
public class ProfissionalController {

    @Autowired
    private ProfissionalService service;

    @PostMapping
    public ResponseEntity<ProfissionalResponse> create(
            @RequestBody ProfissionalRequestCreate dto) {
        Profissional p = service.create(dto);
        return ResponseEntity.status(201)
                             .body(new ProfissionalResponse().toDto(p));
    }

    @GetMapping
    public ResponseEntity<List<ProfissionalResponse>> findAll() {
        List<ProfissionalResponse> list = service.getAll().stream()
            .map(p -> new ProfissionalResponse().toDto(p))
            .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfissionalResponse> findById(@PathVariable Long id) {
        return service.getById(id)
            .map(p -> ResponseEntity.ok(new ProfissionalResponse().toDto(p)))
            .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfissionalResponse> update(
            @PathVariable Long id,
            @RequestBody ProfissionalRequestUpdate dto) {

        return service.update(id, dto)
            .map(p -> ResponseEntity.ok(new ProfissionalResponse().toDto(p)))
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