package com.example.sistema.automotivo.model;

public enum StatusAgendamento {
    PEDENTE("Pedente"),
    CONFIRMADO("Confirmado"),
    CANCELADO("Cancelado"),
    CONCLUIDO("Concluido");

    private String texto;
    private StatusAgendamento(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }
}
