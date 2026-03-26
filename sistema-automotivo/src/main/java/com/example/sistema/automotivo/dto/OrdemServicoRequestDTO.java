package com.example.sistema.automotivo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class OrdemServicoRequestDTO {
    @NotNull(message = "O ID do cliente é obrigatório")
    private Long clienteId;

    @NotBlank(message = "O modelo do veículo é obrigatório")
    private String modeloVeiculo;

    @NotBlank(message = "A descrição do problema é obrigatória e não pode estar vazia")
    private String descricaoProblema;

    public OrdemServicoRequestDTO() {
    }

    public OrdemServicoRequestDTO(Long clienteId, String modeloVeiculo, String descricaoProblema) {
        this.clienteId = clienteId;
        this.modeloVeiculo = modeloVeiculo;
        this.descricaoProblema = descricaoProblema;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public String getModeloVeiculo() {
        return modeloVeiculo;
    }

    public void setModeloVeiculo(String modeloVeiculo) {
        this.modeloVeiculo = modeloVeiculo;
    }

    public String getDescricaoProblema() {
        return descricaoProblema;
    }

    public void setDescricaoProblema(String descricaoProblema) {
        this.descricaoProblema = descricaoProblema;
    }

    @Override
    public String toString() {
        return "OrdemServicoRequestDTO{" +
                "clienteId=" + clienteId +
                ", modeloVeiculo='" + modeloVeiculo + '\'' +
                ", descricaoProblema='" + descricaoProblema + '\'' +
                '}';
    }
}
