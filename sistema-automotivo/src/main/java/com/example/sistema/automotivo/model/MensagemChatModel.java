package com.example.sistema.automotivo.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tab_mensagemchat")
public class MensagemChatModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ordem_servico_id", nullable = false)
    private OrdemServicoModel ordemServico;

    @ManyToOne
    @JoinColumn(name = "remetente_id", nullable = false)
    private UsuarioModel remetente; // Pode ser o ID do Cliente ou do Operador N1, N2, N3

    @Column(nullable = false, columnDefinition = "TEXT")
    private String mensagem;

    @Column(name = "data_envio", updatable = false)
    private LocalDateTime dataEnvio;

    public MensagemChatModel() {
    }

    public MensagemChatModel(Long id, OrdemServicoModel ordemServico, UsuarioModel remetente, String mensagem, LocalDateTime dataEnvio) {
        this.id = id;
        this.ordemServico = ordemServico;
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

    public OrdemServicoModel getOrdemServico() {
        return ordemServico;
    }

    public void setOrdemServico(OrdemServicoModel ordemServico) {
        this.ordemServico = ordemServico;
    }

    public UsuarioModel getRemetente() {
        return remetente;
    }

    public void setRemetente(UsuarioModel remetente) {
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
