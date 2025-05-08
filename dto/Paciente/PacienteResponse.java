package br.com.fiap.checkpoint2.dto.Paciente;

import java.time.LocalDate;
import java.time.LocalDateTime;
import br.com.fiap.checkpoint2.model.Paciente;

public class PacienteResponse {

    private Long id;
    private String nome;
    private String endereco;
    private String bairro;
    private String email;
    private String telefone_completo;
    private LocalDate dataNascimento;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public PacienteResponse toDto(Paciente p) {
        this.id = p.getId();
        this.nome = p.getNome();
        this.endereco = p.getEndereco();
        this.bairro = p.getBairro();
        this.email = p.getEmail();
        this.telefone_completo = p.getTelefone_completo();
        this.dataNascimento = p.getDataNascimento();
        this.createdAt = p.getCreatedAt();
        this.updatedAt = p.getUpdatedAt();
        return this;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public String getNome() { return nome; }
    public String getEndereco() { return endereco; }
    public String getBairro() { return bairro; }
    public String getEmail() { return email; }
    public String getTelefone_completo() { return telefone_completo; }
    public LocalDate getDataNascimento() { return dataNascimento; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
}