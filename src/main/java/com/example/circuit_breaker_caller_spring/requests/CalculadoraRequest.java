package com.example.circuit_breaker_caller_spring.requests;

public class CalculadoraRequest {

    private int numeroUm;

    private int numeroDois;

    public CalculadoraRequest() {
    }

    public CalculadoraRequest(int numeroUm, int numeroDois) {
        this.numeroUm = numeroUm;
        this.numeroDois = numeroDois;
    }

    public int getNumeroUm() {
        return numeroUm;
    }

    public void setNumeroUm(int numeroUm) {
        this.numeroUm = numeroUm;
    }

    public int getNumeroDois() {
        return numeroDois;
    }

    public void setNumeroDois(int numeroDois) {
        this.numeroDois = numeroDois;
    }
}
