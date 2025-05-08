package br.com.fiap.checkpoint2.dto.Profissional;

import java.time.LocalDateTime;
import java.math.BigDecimal;
import br.com.fiap.checkpoint2.model.Profissional;

public class ProfissionalResponse {

    private Long id;
    private String nome;
    private String especialidade;
    private BigDecimal valorHora;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ProfissionalResponse toDto(Profissional p) {
        this.id = p.getId();
        this.nome = p.getNome();
        this.especialidade = p.getEspecialidade();
        this.valorHora = p.getValorHora();
        this.createdAt = p.getCreatedAt();
        this.updatedAt = p.getUpdatedAt();
        return this;
    }

    // Getters
    public Long getId() { return id; }
    public String getNome() { return nome; }
    public String getEspecialidade() { return especialidade; }
    public BigDecimal getValorHora() { return valorHora; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
}