package com.example.sistema.automotivo.dto;

import com.example.sistema.automotivo.model.StatusOrdem;

import java.time.LocalDateTime;

public class OrdemServicoResponseDTO {
    private Long id;
    private UsuarioResponseDTO cliente;
    private OficinaParceiroResponseDTO oficina;
    private String modeloVeiculo;
    private String descricaoProblema;
    private StatusOrdem status;
    private LocalDateTime dataCriacao;

    public OrdemServicoResponseDTO() {
    }

    public OrdemServicoResponseDTO(Long id, UsuarioResponseDTO cliente, OficinaParceiroResponseDTO oficina, String modeloVeiculo, String descricaoProblema, StatusOrdem status, LocalDateTime dataCriacao) {
        this.id = id;
        this.cliente = cliente;
        this.oficina = oficina;
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

    public UsuarioResponseDTO getCliente() {
        return cliente;
    }

    public void setCliente(UsuarioResponseDTO cliente) {
        this.cliente = cliente;
    }

    public OficinaParceiroResponseDTO getOficina() {
        return oficina;
    }

    public void setOficina(OficinaParceiroResponseDTO oficina) {
        this.oficina = oficina;
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
}
