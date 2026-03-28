package com.example.sistema.automotivo.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tab_ordemservicos")
public class OrdemServicoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private UsuarioModel cliente;

    @ManyToOne
    @JoinColumn(name = "oficina_id", nullable = false)
    private OficinaParceiraModel oficina;


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

    public OrdemServicoModel(Long id, UsuarioModel cliente, OficinaParceiraModel oficina, String modeloVeiculo, String descricaoProblema, StatusOrdem status, LocalDateTime dataCriacao) {
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

    public UsuarioModel getCliente() {
        return cliente;
    }

    public void setCliente(UsuarioModel cliente) {
        this.cliente = cliente;
    }

    public OficinaParceiraModel getOficina() {
        return oficina;
    }

    public void setOficina(OficinaParceiraModel oficina) {
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
