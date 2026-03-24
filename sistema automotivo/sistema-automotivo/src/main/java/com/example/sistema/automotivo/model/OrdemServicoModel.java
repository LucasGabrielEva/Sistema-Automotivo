package com.example.sistema.automotivo.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "ordens_servico")
public class OrdemServicoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cliente_id", nullable = false)
    private Long clienteId;

    @Column(name = "modelo_veiculo", nullable = false)
    private String modeloVeiculo;

    @Column(name = "descricao_problema", nullable = false, columnDefinition = "TEXT")
    private String descricaoProblema;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusOrdem status;

    @Column(name = "data_criacao", updatable = false)
    private LocalDateTime dataCriacao;

    public OrdemServicoModel() {
    }

    public OrdemServicoModel(Long id, Long clienteId, String modeloVeiculo, String descricaoProblema, StatusOrdem status, LocalDateTime dataCriacao) {
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
        return "OndemServicoModel{" +
                "id=" + id +
                ", clienteId=" + clienteId +
                ", modeloVeiculo='" + modeloVeiculo + '\'' +
                ", descricaoProblema='" + descricaoProblema + '\'' +
                ", status=" + status +
                ", dataCriacao=" + dataCriacao +
                '}';
    }
}
