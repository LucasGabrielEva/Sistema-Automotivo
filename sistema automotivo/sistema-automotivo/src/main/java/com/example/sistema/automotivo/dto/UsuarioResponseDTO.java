package com.example.sistema.automotivo.dto;

import com.example.sistema.automotivo.model.Perfil;

import java.time.LocalDate;

public class UsuarioResponseDTO {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private Perfil perfil;
    private LocalDate dataCriacao;

    public UsuarioResponseDTO() {
    }

    public UsuarioResponseDTO(Long id, String nome, String email, String senha, Perfil perfil, LocalDate dataCriacao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.perfil = perfil;
        this.dataCriacao = dataCriacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    @Override
    public String toString() {
        return "UsuarioResponseDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", perfil=" + perfil +
                ", dataCriacao=" + dataCriacao +
                '}';
    }
}
