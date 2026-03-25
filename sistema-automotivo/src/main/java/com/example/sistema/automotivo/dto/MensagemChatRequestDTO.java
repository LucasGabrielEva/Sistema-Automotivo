package com.example.sistema.automotivo.dto;

public class MensagemChatRequestDTO {
    private Long ordemServicoId;
    private Long remetenteId;
    private String mensagem;

    public MensagemChatRequestDTO() {
    }

    public MensagemChatRequestDTO(Long ordemServicoId, Long remetenteId, String mensagem) {
        this.ordemServicoId = ordemServicoId;
        this.remetenteId = remetenteId;
        this.mensagem = mensagem;
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

    @Override
    public String toString() {
        return "MensagemChatRequestDTO{" +
                "ordemServicoId=" + ordemServicoId +
                ", remetenteId=" + remetenteId +
                ", mensagem='" + mensagem + '\'' +
                '}';
    }
}
