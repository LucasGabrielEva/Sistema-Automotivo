package com.example.sistema.automotivo.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class OficinaParceiroRequestDTO {
    @NotBlank(message = "O nome da oficina é obrigatório")
    private String nome;

    @NotNull(message = "A latitude é obrigatória")
    @DecimalMin(value = "-90.0", message = "Latitude inválida. O valor mínimo é -90.0")
    @DecimalMax(value = "90.0", message = "Latitude inválida. O valor máximo é 90.0")
    private Double latitude;

    @NotNull(message = "A longitude é obrigatória")
    @DecimalMin(value = "-180.0", message = "Longitude inválida. O valor mínimo é -180.0")
    @DecimalMax(value = "180.0", message = "Longitude inválida. O valor máximo é 180.0")
    private Double longitude;

    @NotBlank(message = "O endereço é obrigatório")
    private String endereco;

    public OficinaParceiroRequestDTO() {
    }

    public OficinaParceiroRequestDTO(String nome, Double latitude, Double longitude, String endereco) {
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
}
