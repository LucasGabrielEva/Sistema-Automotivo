package com.example.sistema.automotivo.dto;

import java.time.LocalDateTime;

public class AgendamentoRequestDTO {

    private Long clienteId;
    private LocalDateTime dataAgendamento;
    private String tipoServico;

    public AgendamentoRequestDTO() {
    }

    public AgendamentoRequestDTO(Long clienteId, LocalDateTime dataAgendamento, String tipoServico) {
        this.clienteId = clienteId;
        this.dataAgendamento = dataAgendamento;
        this.tipoServico = tipoServico;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public LocalDateTime getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(LocalDateTime dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    @Override
    public String toString() {
        return "AgendamentoRequestDTO{" +
                "clienteId=" + clienteId +
                ", dataAgendamento=" + dataAgendamento +
                ", tipoServico='" + tipoServico + '\'' +
                '}';
    }


}
