package com.example.sistema.automotivo.dto;

public class OficinaParceiroResponseDTO {
    private Long id;
    private String nome;
    private Double latitude;
    private Double longitude;
    private String endereco;

    public OficinaParceiroResponseDTO() {
    }

    public OficinaParceiroResponseDTO(Long id, String nome, Double latitude, Double longitude, String endereco) {
        this.id = id;
        this.nome = nome;
        this.latitude = latitude;
        this.longitude = longitude;
        this.endereco = endereco;
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

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "OficinaParceiroResponseDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", endereco='" + endereco + '\'' +
                '}';
    }


}
