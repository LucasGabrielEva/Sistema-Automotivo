package com.example.sistema.automotivo.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tab_agendametos")
public class AgendamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;

    @Column(name = "cliente_id", nullable = false)
    private Long clienteId;

    @Column(name = "data_hora_agendamento", nullable = false)
    private LocalDateTime dataHoraAgendamento;

    @Column(name = "tipo_servico", nullable = false)
    private String tipoServico;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusAgendamento status;

    @Column(name = "data_criacao", updatable = false)
    private LocalDateTime dataCriacao;

    public AgendamentoModel() {
    }

    public AgendamentoModel(Long id, Long clienteId, LocalDateTime dataHoraAgendamento, String tipoServico, StatusAgendamento status, LocalDateTime dataCriacao) {
        this.id = id;
        this.clienteId = clienteId;
        this.dataHoraAgendamento = dataHoraAgendamento;
        this.tipoServico = tipoServico;
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

    public LocalDateTime getDataHoraAgendamento() {
        return dataHoraAgendamento;
    }

    public void setDataHoraAgendamento(LocalDateTime dataHoraAgendamento) {
        this.dataHoraAgendamento = dataHoraAgendamento;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    public StatusAgendamento getStatus() {
        return status;
    }

    public void setStatus(StatusAgendamento status) {
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
        return "AgendamentoModel{" +
                "id=" + id +
                ", clienteId=" + clienteId +
                ", dataHoraAgendamento=" + dataHoraAgendamento +
                ", tipoServico='" + tipoServico + '\'' +
                ", status=" + status +
                ", dataCriacao=" + dataCriacao +
                '}';
    }
}
