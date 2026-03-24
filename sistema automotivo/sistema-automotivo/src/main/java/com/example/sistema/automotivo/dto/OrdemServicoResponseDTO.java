package com.example.sistema.automotivo.dto;

import com.example.sistema.automotivo.model.StatusOrdem;

import java.time.LocalDateTime;

public class OrdemServicoResponseDTO {
    private Long id;
    private Long clienteId;
    private String modeloVeiculo;
    private String descricaoProblema;
    private StatusOrdem status;
    private LocalDateTime dataCriacao;

    public OrdemServicoResponseDTO() {
    }

    public OrdemServicoResponseDTO(Long id, Long clienteId, String modeloVeiculo, String descricaoProblema, StatusOrdem status, LocalDateTime dataCriacao) {
        this.id = id;
        this.clienteId = clienteId;
        this.modeloVeiculo = modeloVeiculo;
        this.descricaoProblema = descricaoProblema;
        this.status = status;
        this.dataCriacao = dataCriacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public StatusOrdem getStatus() {
        return status;
    }

    public void setStatus(StatusOrdem status) {
        this.status = status;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    @Override
    public String toString() {
        return "OrdemServicoResponseDTO{" +
                "id=" + id +
                ", clienteId=" + clienteId +
                ", modeloVeiculo='" + modeloVeiculo + '\'' +
                ", descricaoProblema='" + descricaoProblema + '\'' +
                ", status=" + status +
                ", dataCriacao=" + dataCriacao +
                '}';
    }
}
