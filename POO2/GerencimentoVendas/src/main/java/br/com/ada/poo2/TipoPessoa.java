package br.com.ada.poo2;

import java.util.Scanner;

import static br.com.ada.poo2.Menu.scanner;

public class TipoPessoa extends Pessoa {
    private int escolha;
    public Pessoa escolhaTipoPessoa () {
        Pessoa pessoa = null;

        System.out.println("########################\n" +
                "Escolha o tipo de pessa \n" +
                "1 - Pessoa Fisíca \n" +
                "2 - Pessoa Jurídica \n" +
                "######################## ");

        escolha = Integer.parseInt(scanner());

        if ( escolha == 1 ) {
            pessoa = new PessoaFisica();
        } else if ( escolha == 2 ) {
            pessoa = new PessoaJuridica();
        } else {
            System.out.println("Opção invalida!");
            escolhaTipoPessoa();
        }

        super.setNome(nomePesso());

        return pessoa;
    }

    private String nomePesso(){

        System.out.println("Digite seu nome:");
        super.setNome(scanner());
        if (super.getNome().length() < 3){
            System.out.println("Digite um nome com pelo menos 3 letras");
            nomePesso();
        }
        return super.getNome();
    }
}
