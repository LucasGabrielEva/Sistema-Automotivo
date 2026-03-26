package com.example.sistema.automotivo.dto;

import java.time.LocalDateTime;

public class MensagemChatResponseDTO {
    private Long id;
    private Long ordemServicoId;
    private Long remetenteId;
    private String mensagem;
    private LocalDateTime dataEnvio;

    public MensagemChatResponseDTO() {
    }

    public MensagemChatResponseDTO(Long id, Long ordemServicoId, Long remetenteId, String mensagem, LocalDateTime dataEnvio) {
        this.id = id;
        this.ordemServicoId = ordemServicoId;
        this.remetenteId = remetenteId;
        this.mensagem = mensagem;
        this.dataEnvio = dataEnvio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrdemServicoId() {
        return ordemServicoId;
    }

    public void setOrdemServicoId(Long ordemServicoId) {
        this.ordemServicoId = ordemServicoId;
    }

    public Long getRemetenteId() {
        return remetenteId;
    }

    public void setRemetenteId(Long remetenteId) {
        this.remetenteId = remetenteId;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public LocalDateTime getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(LocalDateTime dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    @Override
    public String toString() {
        return "MensagemChatResponseDTO{" +
                "id=" + id +
                ", ordemServicoId=" + ordemServicoId +
                ", remetenteId=" + remetenteId +
                ", mensagem='" + mensagem + '\'' +
                ", dataEnvio=" + dataEnvio +
                '}';
    }
}
