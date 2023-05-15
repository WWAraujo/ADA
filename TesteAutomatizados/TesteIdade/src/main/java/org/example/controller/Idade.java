package org.example.controller;

public class Idade {

    private int anoAtual = 2023;
    public int anosDeVida(int anoNacimento){
        if (anoNacimento < 1923 || anoNacimento > 2023){
            throw new RuntimeException("Ano invalido.");
        }
        return anoAtual - anoNacimento;
    }
}
