package com.example.sistema.automotivo.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "tab_agendametos")
@EntityListeners(AuditingEntityListener.class)
public class AgendamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private UsuarioModel cliente;

    @ManyToOne
    @JoinColumn(name = "oficina_id", nullable = false)
    private OficinaParceiraModel oficina;


    @Column(name = "data_hora_agendamento", nullable = false)
    private LocalDateTime dataHoraAgendamento;

    @Column(name = "tipo_servico", nullable = false)
    private String tipoServico;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusAgendamento status;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime dataCriacao;

    public AgendamentoModel() {
    }

    public AgendamentoModel(Long id, UsuarioModel cliente, OficinaParceiraModel oficina, LocalDateTime dataHoraAgendamento, String tipoServico, StatusAgendamento status, LocalDateTime dataCriacao) {
        this.id = id;
        this.cliente = cliente;
        this.oficina = oficina;
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

    public UsuarioModel getCliente() {
        return cliente;
    }

    public void setCliente(UsuarioModel cliente) {
        this.cliente = cliente;
    }

    public OficinaParceiraModel getOficina() {
        return oficina;
    }

    public void setOficina(OficinaParceiraModel oficina) {
        this.oficina = oficina;
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
