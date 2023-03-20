import TiposCliente.PessoaFisisca;
import TiposCliente.PessoaJuridica;

import java.util.Locale;
import java.util.Scanner;

public class Aplicacao {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Imprimir("===================================" +
                    " Seja bem vindo ao baco do Wallace " +
                    "===================================");

        Imprimir("Qual o seu nome? ");
        String nome = scanner.nextLine();

        Imprimir("===================================");
        System.out.println("Olá "+nome);

        Imprimir("Qual conta quer abrir ? \n" +
                "1) Pessoa Fisica \n" +
                "2) Pessoa Jurídica");

        int numeroConta =0;

        boolean validarConta = true;
        while (validarConta){
            int numeroConta = AbrirConta();
            if (numeroConta == 1 || numeroConta == 2){
                validarConta = false;
                break;
            }
        }

        if (numeroConta == 1 ){
            PessoaFisisca pf = new PessoaFisisca();
            System.out.println("1) Conta Poupanca \n" +
                    "2) Conta Investimento \n" +
                    "3) Conta Corrente");
        } else if (numeroConta == 2 ){
            PessoaJuridica pj = new PessoaJuridica();
            System.out.println("1) Voce não pode ter conta poroanca \n" +
                    "2) Conta Investimento \n" +
                    "3) COnta Corrente");
        } else {
            System.out.println("Erro ao validar o tipo da conta");

        }

        int conta

        boolean continuar = true;

        System.out.println("");

        do {
            if (conta == 1) {
                System.out.println("1) Sacar Conta Corrente \n" +
                        "2) Depositar Conta Poupança \n" +
                        "3) Mostrar Saldo");
                int tipoCOnta = Integer.parseInt(scanner.nextLine());
                if (tipoCOnta == 1) {
                    cc.sacar(entradaValor());
                    cc.exibirSaldo();
                } else if (tipoCOnta == 2) {
                    cc.depositar(entradaValor());
                    cc.exibirSaldo();
                } else if (tipoCOnta == 3 ){
                    cc.exibirSaldo();
                } else {
                    System.out.println("Escolha 1, 2 ou 3");
                }
            } else if (conta == 2) {
                System.out.println("1) Sacar Conta Poupança\n" +
                        "2) Depositar Conta Poupança \n" +
                        "3) Mostrar Saldo");
                int tipoOperacao = Integer.parseInt(scanner.nextLine());
                if (tipoOperacao == 1) {
                    cp.sacar(entradaValor());
                    cp.exibirSaldo();
                } else if (tipoOperacao == 2) {
                    cp.depositar(entradaValor());
                    cp.exibirSaldo();
                } else if (tipoOperacao == 3) {
                    cp.exibirSaldo();
                }
            }
            System.out.println("Deseja continuar na mesma conta ? S ou N ");
            String ctnMesmaConta = scanner.nextLine().toUpperCase(Locale.ROOT);
            while (ctnMesmaConta.equals("N")) {
                System.out.println("Deseja troca de conta? S ou N");
                String ctnOutraConta = scanner.nextLine().toUpperCase(Locale.ROOT);
                if (ctnOutraConta.equals("N")) {
                    continuar = false;
                    break;
                }else if (ctnOutraConta.equals("S")){
                    System.out.println("Qual conta quer usar ? \n" +
                            "1) Conta Corrente \n" +
                            "2) Conta Poupança");
                    conta = Integer.parseInt(scanner.nextLine());
                    break;
                }
            }
        } while (continuar);
        System.out.println("Até logo "+ nome+" !");


    }

    public static void Imprimir(String s){
        System.out.println(s);
    }
    private static int AbrirConta(){
        Scanner scanner = new Scanner(System.in);

        Imprimir("Qual conta quer abrir ? \n" +
                            "1) Pessoa Fisica \n" +
                            "2) Pessoa Jurídica");

        int conta = Integer.parseInt(scanner.nextLine());

        if (conta == 1 ){
            return 1;
//            PessoaFisisca pf = new PessoaFisisca();
        } else if (conta == 2 ){
            return 2;
//            PessoaJuridica pj = new PessoaJuridica();
        } else {
//            Imprimir("Digite:\n 1) Para Pessoa Fisica \n 2) Para Pessoa Jurídica ");
            AbrirConta();
        }
        return 0;
    }
    public static double EntradaValor(){
        Scanner scanner = new Scanner(System.in);
        Imprimir("Digite o valor: ");
        double valorDigitado = Double.parseDouble(scanner.nextLine());
        return valorDigitado;
    }


//        boolean continuar = true;
//        do {
//            if (conta == 1) {
//                System.out.println("1) Sacar Conta Corrente \n" +
//                        "2) Depositar Conta Poupança \n" +
//                        "3) Mostrar Saldo");
//                int tipoCOnta = Integer.parseInt(scanner.nextLine());
//                if (tipoCOnta == 1) {
//                    cc.sacar(entradaValor());
//                    cc.exibirSaldo();
//                } else if (tipoCOnta == 2) {
//                    cc.depositar(entradaValor());
//                    cc.exibirSaldo();
//                } else if (tipoCOnta == 3 ){
//                    cc.exibirSaldo();
//                } else {
//                    System.out.println("Escolha 1, 2 ou 3");
//                }
//            } else if (conta == 2) {
//                System.out.println("1) Sacar Conta Poupança\n" +
//                        "2) Depositar Conta Poupança \n" +
//                        "3) Mostrar Saldo");
//                int tipoOperacao = Integer.parseInt(scanner.nextLine());
//                if (tipoOperacao == 1) {
//                    cp.sacar(entradaValor());
//                    cp.exibirSaldo();
//                } else if (tipoOperacao == 2) {
//                    cp.depositar(entradaValor());
//                    cp.exibirSaldo();
//                } else if (tipoOperacao == 3) {
//                    cp.exibirSaldo();
//                }
//            }
//            System.out.println("Deseja continuar na mesma conta ? S ou N ");
//            String ctnMesmaConta = scanner.nextLine().toUpperCase(Locale.ROOT);
//            while (ctnMesmaConta.equals("N")) {
//                System.out.println("Deseja troca de conta? S ou N");
//                String ctnOutraConta = scanner.nextLine().toUpperCase(Locale.ROOT);
//                if (ctnOutraConta.equals("N")) {
//                    continuar = false;
//                    break;
//                }else if (ctnOutraConta.equals("S")){
//                    System.out.println("Qual conta quer usar ? \n" +
//                            "1) Conta Corrente \n" +
//                            "2) Conta Poupança");
//                    conta = Integer.parseInt(scanner.nextLine());
//                    break;
//                }
//            }
//        } while (continuar);
//        System.out.println("Até logo "+ nome+" !");
}
