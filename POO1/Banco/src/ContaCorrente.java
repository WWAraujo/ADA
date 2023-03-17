public class ContaCorrente extends Conta {

    @Override
    public void depositar(double depositar) {
        double saldoInicial = saldo;
        this.saldo = this.saldo + depositar;
        if (saldoInicial != saldo) {
            System.out.println("Deposito feito com sucesso!");
        }
    }

    @Override
    public void sacar(double sacar) {
        if (sacar <= saldo) {
            this.saldo -= sacar;
            System.out.println("Saque feito com sucesso!");
        } else {
            System.out.println("Não tem saldo");
        }
    }

    @Override
    public void exibirSaldo() {
        System.out.println("O saldo da conta corrente é " + saldo);
    }
}