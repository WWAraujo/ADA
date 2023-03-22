import TiposCliente.PessoaFisisca;
import TiposCliente.PessoaJuridica;

import java.util.Locale;
import java.util.Scanner;

public class Aplicacao {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        imprimir("===================================\n" +
                    " Seja bem vindo ao baco do Wallace \n" +
                    "===================================");

        imprimir("     Qual o seu nome?           ");
        String nome = scanner.nextLine();

        imprimir("===================================");
        System.out.println("    Olá, "+nome);
        imprimir("===================================");


        int numeroConta = abrirConta();

        // Conta = 1 poupanca
        // Conta = 2 investimento
        // Conta = 3 corrente
        int conta = tipoConta(numeroConta);

        boolean continuar = true;

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

                int odf = escolhaMenu(1,4);

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
                        imprimir("Valor que deseja transferir.");
                        double x = entradaValor();
                        imprimir("Qual conta deseja transferir? \n" +
                                "2) Conta Investimento \n" +
                                "3) Conta Corrente");
                        int novaContaTransferir = escolhaMenu(2,3);
                        pf.transferir(x, conta, novaContaTransferir);
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
                        imprimir("Valor que deseja transferir.");
                        double x = entradaValor();
                        imprimir("Qual conta deseja transferir? \n" +
                                "1) Conta Poupanca \n" +
                                "2) Conta Corrente");
                        int novaContaTransferir = escolhaMenu(1,2);
                        pf.transferir(x, conta, novaContaTransferir);
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
                        imprimir("Valor que deseja transferir.");
                        double x = entradaValor();
                        imprimir("Qual conta deseja transferir? \n" +
                                "1) Conta Poupanca \n" +
                                "2) Conta Investimento ");
                        int novaContaTransferir = escolhaMenu(1,2);
                        pf.transferir(x, conta, novaContaTransferir);
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

                int odf = escolhaMenu(1,4);

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

                        imprimir("Qual conta deseja transferir? \n" +
                                "1) Conta Corrente \n");
                        int novaContaTransferir = escolhaMenu(1,1);
                        pf.transferir(x, conta, novaContaTransferir);
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
                        imprimir("Qual conta deseja transferir? \n" +
                                "2) Conta Investimento ");
                        int novaContaTransferir = escolhaMenu(2,2);
                        pf.transferir(x, conta, novaContaTransferir);
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
        } else if (conta == 2 ){
            return 2;
        } else {
            abrirConta();
        }
        return 0;
    }

    public static double entradaValor(){
        try {
            Scanner scanner = new Scanner(System.in);
            imprimir("Digite o valor: ");
            double valorDigitado = Double.parseDouble(scanner.nextLine());
            return valorDigitado;
        } catch (Exception exception){
            System.out.println("ERRO - Valor digitado nao é um numero!");
        }
        return 0;
    }

    public static int escolhaMenu(int menor, int maior){

        Scanner scanner = new Scanner(System.in);
        int conta = 0;
        try {
            conta = Integer.parseInt(scanner.nextLine());
            while (conta < menor || conta > maior){
                conta = Integer.parseInt(entradaValor() +"");
                break;
            }
        } catch (Exception exception){
            System.out.println("ERRO - Valor digitado nao é um numero! \n");
        }
        return conta;
    }

    public static int tipoConta(int numeroConta){

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

        int conta = escolhaMenu(1,3);

        return conta;
    }
}
