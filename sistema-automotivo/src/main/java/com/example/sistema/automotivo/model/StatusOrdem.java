package com.example.sistema.automotivo.model;

public enum StatusOrdem {
    ABERTA("Aberta"),
    EM_ANDAMENTO("Em andamento"),
    AGUARDANDO_PECA("Aguardando peca"),
    FECHADA("Fechada");

    private String texto;

    StatusOrdem(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }
}
