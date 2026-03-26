package com.example.sistema.automotivo.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class AgendamentoRequestDTO {
    @NotNull(message = "O ID do cliente é obrigatório")
    private Long clienteId;


    @NotNull(message = "A data de agendamento é obrigatória")
    @FutureOrPresent(message = "A data de agendamento deve ser no presente ou no futuro")
    private LocalDateTime dataAgendamento;

    @NotBlank(message = "O tipo de serviço é obrigatório e não pode estar em branco")
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




}
