package com.example.sistema.automotivo.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tab_mensagemchat")
public class MensagemChatModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ordem_servico_id", nullable = false)
    private Long ordemServicoId;

    @Column(name = "remetente_id", nullable = false)
    private Long remetenteId; // Pode ser o ID do Cliente ou do Operador N1, N2, N3

    @Column(nullable = false, columnDefinition = "TEXT")
    private String mensagem;

    @Column(name = "data_envio", updatable = false)
    private LocalDateTime dataEnvio;

    public MensagemChatModel() {
    }

    public MensagemChatModel(Long id, Long ordemServicoId, Long remetenteId, String mensagem, LocalDateTime dataEnvio) {
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
        return "MensagemChatModel{" +
                "id=" + id +
                ", ordemServicoId=" + ordemServicoId +
                ", remetenteId=" + remetenteId +
                ", mensagem='" + mensagem + '\'' +
                ", dataEnvio=" + dataEnvio +
                '}';
    }
}
