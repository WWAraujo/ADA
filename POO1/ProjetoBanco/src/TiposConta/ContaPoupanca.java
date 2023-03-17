package TiposConta;

import TiposCliente.Cliente;

public class ContaPoupanca extends Cliente implements Conta{

    @Override
    public void depositar(double depositar) {
        double saldoInicial = saldoConta;
        this.saldoConta += depositar;
        if (saldoInicial != saldoConta){
            System.out.println("Deposito feito com sucesso!");
        }
    }

    @Override
    public void sacar(double sacar) {
        if (sacar <= saldoConta){
            this.saldoConta -= sacar;
            System.out.println("Saque feito com sucesso!");
        }else {
            System.out.println("Não tem saldo suficiente");
        }
    }

    @Override
    public void exibirSaldo () {
        System.out.println("O saldo da conta poupança é " + saldoConta);
    }
}
