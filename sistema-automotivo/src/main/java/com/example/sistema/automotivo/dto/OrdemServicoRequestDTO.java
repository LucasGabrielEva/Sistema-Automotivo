package com.example.sistema.automotivo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class OrdemServicoRequestDTO {
    @NotNull(message = "O ID do cliente é obrigatório")
    private Long clienteId;

    @NotNull(message = "O ID da oficina é obrigatório")
    private Long oficinaId;


    @NotBlank(message = "O modelo do veículo é obrigatório")
    private String modeloVeiculo;

    @NotBlank(message = "A descrição do problema é obrigatória e não pode estar vazia")
    private String descricaoProblema;

    public OrdemServicoRequestDTO() {
    }

    public OrdemServicoRequestDTO(Long clienteId, Long oficinaId, String modeloVeiculo, String descricaoProblema) {
        this.clienteId = clienteId;
        this.oficinaId = oficinaId;
        this.modeloVeiculo = modeloVeiculo;
        this.descricaoProblema = descricaoProblema;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getOficinaId() {
        return oficinaId;
    }

    public void setOficinaId(Long oficinaId) {
        this.oficinaId = oficinaId;
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
}
