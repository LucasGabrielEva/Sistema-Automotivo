package com.example.sistema.automotivo.model;

public enum Perfil {
    CLIENTE("Cliente"),
    N1("N1"),
    N2("N2"),
    N3("N3");

    private String texto;

    Perfil(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }
}
