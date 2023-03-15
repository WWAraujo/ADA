import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.println("Digite o numero da conta: ");
        int numeroConta = Integer.parseInt(scanner.nextLine());

        System.out.println("Qual conta quer abrir ? \n" +
                            "1) Conta Corrente \n" +
                            "2) Conta Poupança");
        ContaCorrente cc = new ContaCorrente();
        ContaPoupanca cp = new ContaPoupanca();
        int conta = Integer.parseInt(scanner.nextLine());
        boolean continuar = true;
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
    public static double entradaValor(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o valor: ");
        double valorDigitado = Double.parseDouble(scanner.nextLine());
        return valorDigitado;
    }
}

