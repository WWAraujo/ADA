import TiposCliente.PessoaFisisca;
import TiposCliente.PessoaJuridica;

import java.util.Locale;
import java.util.Scanner;

public class Aplicacao {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        imprimir("===================================" +
                    " Seja bem vindo ao baco do Wallace " +
                    "===================================");

        imprimir("     Qual o seu nome?           ");
        String nome = scanner.nextLine();

        imprimir("===================================");
        System.out.println("    Olá, "+nome);
        imprimir("===================================");

        int numeroConta =0;

        boolean validarConta = true;
        while (validarConta){
            numeroConta = abrirConta();
            // 1 - Pessoa Fisica
            // 2 - Pessoa Juridica
            if (numeroConta == 1 || numeroConta == 2){
                validarConta = false;
                break;
            }
        }

        imprimir("Qual conta quer usar?");
        if (numeroConta == 1 ){
            System.out.println("1) Conta Poupanca \n" +
                    "2) Conta Investimento \n" +
                    "3) Conta Corrente");
        } else if (numeroConta == 2 ){
            System.out.println("1) Voce não tem conta poupanca \n" +
                    "2) Conta Investimento \n" +
                    "3) COnta Corrente");
        } else {
            System.out.println("Erro ao validar o tipo da conta");

        }

        int conta = Integer.parseInt(scanner.nextLine());

        if (conta < 1 || conta > 3){
            boolean saida = true;
            do {
                conta = Integer.parseInt(entradaValor() +"");
                saida = false;
                break;
            } while (saida);
        }

        boolean continuar = true;

        System.out.println("");

        PessoaFisisca pf = new PessoaFisisca();
        PessoaJuridica pj = new PessoaJuridica();

        do {
            if (numeroConta == 1){
                // Conta Pessoa fisica

                imprimir("Qual operação deseja fazer? \n" +
                        "1) Depositar \n" +
                        "2) Sacar \n" +
                        "3) Transferir \n" +
                        "4) Exibir Extrato");

                //Metodo para validar a operação desejada
                int odf = Integer.parseInt(scanner.nextLine());
                if (odf < 1 || odf > 4){
                    boolean saida = true;
                    do {
                        odf = Integer.parseInt(entradaValor() +"");
                        saida = false;
                        break;
                    } while (saida);

                }

                // Conta = 1 poupanca
                // Conta = 2 investimento
                // Conta = 3 corrente
                if (conta == 1 ){
                    // Tipo da conta Poupanca
                    // 1) depositar
                    // 2) sacar
                    // 3) transferir
                    // 4) Exibir extrato
                    if (odf == 1){
                        // Tipo da conta Poupanca
                        imprimir("Digite o valor que deseja depositar.");
                        double x = entradaValor();
                        pf.depositar(x,conta);
                    } else if (odf == 2 ){
                        imprimir("Digite o valor que deseja sacar.");
                        double x = entradaValor();
                        pf.sacar(x,conta);
                    } else if (odf == 3 ) {
                        imprimir("Digite o valor que deseja transferir.");
                        double x = entradaValor();
                        pf.transferir(x, conta);
                    } else {
                        pf.exibirSaldo(conta);
                    }

                } else if (conta == 2 ) {
                    // Tipo da conta Investimento
                    if (odf == 1){
                        imprimir("Digite o valor que deseja depositar.");
                        double x = entradaValor();
                        pf.depositar(x,conta);
                    } else if (odf == 2 ){
                        imprimir("Digite o valor que deseja sacar.");
                        double x = entradaValor();
                        pf.sacar(x,conta);
                    } else if (odf == 3 ) {
                        imprimir("Digite o valor que deseja transferir.");
                        double x = entradaValor();
                        pf.transferir(x, conta);
                    } else {
                        pf.exibirSaldo(conta);
                    }

                } else if (conta == 3 ) {
                   // Tipo da conta Corrente
                    if (odf == 1){
                        imprimir("Digite o valor que deseja depositar.");
                        double x = entradaValor();
                        pf.depositar(x,conta);
                    } else if (odf == 2 ){
                        imprimir("Digite o valor que deseja sacar.");
                        double x = entradaValor();
                        pf.sacar(x,conta);
                    } else if (odf == 3 ) {
                        imprimir("Digite o valor que deseja transferir.");
                        double x = entradaValor();
                        pf.transferir(x, conta);
                    } else {
                        pf.exibirSaldo(conta);
                    }
                }

            } else if (numeroConta == 2){
                // Conta Pessoa Juridica

                imprimir("Qual operação deseja fazer? \n" +
                        "1) Depositar \n" +
                        "2) Sacar \n" +
                        "3) Transferir \n" +
                        "4) Exibir Saldo");

                int odf = Integer.parseInt(scanner.nextLine());

                if (odf < 1 || odf > 4){
                    boolean saida = true;
                    do {
                        odf = Integer.parseInt(entradaValor() +"");
                        saida = false;
                        break;
                    } while (saida);
                }

                if (conta == 1 ){
                    // Tipo da conta Poupanca
                    System.out.println("Você não tem conta Poupança");

                } else if (conta == 2 ) {

                    // Tipo da conta Investimento
                    if (odf == 1){
                        imprimir("Digite o valor que deseja depositar.");
                        double x = entradaValor();
                        pj.depositar(x,conta);
                    } else if (odf == 2 ){
                        imprimir("Digite o valor que deseja sacar.");
                        double x = entradaValor();
                        pj.sacar(x,conta);
                    } else if (odf == 3 ) {
                        imprimir("Digite o valor que deseja transferir.");
                        double x = entradaValor();
                        pj.transferir(x, conta);
                    } else {
                        pj.exibirSaldo(conta);
                    }
                } else if (conta == 3 ) {

                    // Tipo da conta Corrente
                    if (odf == 1){
                        imprimir("Digite o valor que deseja depositar.");
                        double x = entradaValor();
                        pj.depositar(x,conta);
                    } else if (odf == 2 ){
                        imprimir("Digite o valor que deseja sacar.");
                        double x = entradaValor();
                        pj.sacar(x,conta);
                    } else if (odf == 3 ) {
                        imprimir("Digite o valor que deseja transferir.");
                        double x = entradaValor();
                        pj.transferir(x, conta);
                    } else {
                        pj.exibirSaldo(conta);
                    }
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
                            "1) Conta Pupança \n" +
                            "2) Conta Ivestimento \n" +
                            "3) Conta Corrente");
                    conta = Integer.parseInt(scanner.nextLine());
                    break;
                }
            }
        } while (continuar);
        System.out.println("Até logo "+ nome+" !");


    }

    public static void imprimir(String s){
        System.out.println(s);
    }
    private static int abrirConta(){
        Scanner scanner = new Scanner(System.in);

        imprimir("Qual conta quer abrir ? \n" +
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
            abrirConta();
        }
        return 0;
    }
    public static double entradaValor(){
        Scanner scanner = new Scanner(System.in);
        imprimir("Digite o valor: ");
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
