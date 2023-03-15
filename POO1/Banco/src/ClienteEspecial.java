public class ClienteEspecial extends Conta{
    public void depositar(double depositar) {
        double saldoInicial = saldo;
        this.saldo += (depositar*1.05);
        if (saldoInicial != saldo){
            System.out.println("Deposito feito com sucesso!");
        }
    }
    @Override
    public void sacar(double sacar) {
        double limite = saldo + 100;
        if (sacar <= limite){
            this.saldo -= sacar;
            System.out.println("Saque feito com sucesso!");
        }else {
            System.out.println("Não tem saldo suficiente");
        }
    }

    @Override
    public void exibirSaldo () {
        System.out.println("O saldo da conta poupança é " + saldo);
    }
}
