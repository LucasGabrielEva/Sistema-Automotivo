package com.example.sistema.automotivo.dto;

import com.example.sistema.automotivo.model.StatusAgendamento;

import java.time.LocalDateTime;

public class AgendamentoResponseDTO {
    private Long id;
    private Long clienteId;
    private LocalDateTime dataHoraAgendamento;
    private String tipoServico;
    private StatusAgendamento status;
    private LocalDateTime dataCriacao;

    public AgendamentoResponseDTO() {
    }

    public AgendamentoResponseDTO(Long id, Long clienteId, LocalDateTime dataHoraAgendamento, String tipoServico, StatusAgendamento status, LocalDateTime dataCriacao) {
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
        return "AgendamentoResponseDTO{" +
                "id=" + id +
                ", clienteId=" + clienteId +
                ", dataHoraAgendamento=" + dataHoraAgendamento +
                ", tipoServico='" + tipoServico + '\'' +
                ", status=" + status +
                ", dataCriacao=" + dataCriacao +
                '}';
    }
}
