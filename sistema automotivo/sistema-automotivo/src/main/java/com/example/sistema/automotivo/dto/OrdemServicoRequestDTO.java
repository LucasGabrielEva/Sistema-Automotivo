package com.example.sistema.automotivo.dto;

public class OrdemServicoRequestDTO {
    private Long clienteId;
    private String modeloVeiculo;
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
