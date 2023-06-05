package org.example;

import org.example.controller.Idade;

public class Main {
    public static void main(String[] args) {

        Idade idade = new Idade();
        int resultado = idade.anosDeVida(2000);

        if (resultado == 23){
            System.out.println("Funcionou");
        } else {
            System.out.println("Não deu bom...");
        }
    }
}