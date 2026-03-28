package com.example.sistema.automotivo.dto;

import java.time.LocalDateTime;

public class MensagemChatResponseDTO {
    private Long id;
    private Long ordemServicoId;
    private UsuarioResponseDTO remetente;
    private String mensagem;
    private LocalDateTime dataEnvio;

    public MensagemChatResponseDTO() {
    }

    public MensagemChatResponseDTO(Long id, Long ordemServicoId, UsuarioResponseDTO remetente, String mensagem, LocalDateTime dataEnvio) {
        this.id = id;
        this.ordemServicoId = ordemServicoId;
        this.remetente = remetente;
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

    public UsuarioResponseDTO getRemetente() {
        return remetente;
    }

    public void setRemetente(UsuarioResponseDTO remetente) {
        this.remetente = remetente;
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
}
