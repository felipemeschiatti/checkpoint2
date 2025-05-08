package br.com.fiap.checkpoint2.dto.Paciente;

import java.time.LocalDate;
import br.com.fiap.checkpoint2.model.Paciente;

public class PacienteRequestCreate {

    private String nome;
    private String endereco;
    private String bairro;
    private String email;
    private String telefone_completo;
    private LocalDate dataNascimento;

    public Paciente toModel() {
        Paciente p = new Paciente();
        p.setNome(nome);
        p.setEndereco(endereco);
        p.setBairro(bairro);
        p.setEmail(email);
        p.setTelefone_completo(telefone_completo);
        p.setDataNascimento(dataNascimento);
        return p;
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public String getBairro() { return bairro; }
    public void setBairro(String bairro) { this.bairro = bairro; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefone_completo() { return telefone_completo; }
    public void setTelefone_completo(String telefone_completo) {
        this.telefone_completo = telefone_completo;
    }

    public LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}