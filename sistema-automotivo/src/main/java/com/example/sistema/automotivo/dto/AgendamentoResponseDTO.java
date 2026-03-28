package com.example.sistema.automotivo.dto;

import com.example.sistema.automotivo.model.StatusAgendamento;

import java.time.LocalDateTime;

public class AgendamentoResponseDTO {
    private Long id;
    private UsuarioResponseDTO cliente;
    private LocalDateTime dataHoraAgendamento;
    private String tipoServico;
    private StatusAgendamento status;
    private LocalDateTime dataCriacao;

    public AgendamentoResponseDTO() {
    }

    public AgendamentoResponseDTO(Long id, UsuarioResponseDTO cliente, LocalDateTime dataHoraAgendamento, String tipoServico, StatusAgendamento status, LocalDateTime dataCriacao) {
        this.id = id;
        this.cliente = cliente;
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

    public UsuarioResponseDTO getCliente() {
        return cliente;
    }

    public void setCliente(UsuarioResponseDTO cliente) {
        this.cliente = cliente;
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
}
