package com.example.sistema.automotivo.dto;

public class OficinaParceiroRequestDTO {
    private String nome;
    private double latitude;
    private double longitude;
    private String endereco;

    public OficinaParceiroRequestDTO() {
    }

    public OficinaParceiroRequestDTO(String nome, double latitude, double longitude, String endereco) {
        this.nome = nome;
        this.latitude = latitude;
        this.longitude = longitude;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
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
        return "OficinaParceiroRequestDTO{" +
                "nome='" + nome + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}
