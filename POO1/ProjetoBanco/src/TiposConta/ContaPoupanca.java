package TiposConta;

import TiposCliente.Cliente;

public class ContaPoupanca extends Cliente {

    @Override
    public String toString() {
        return "ContaCorrente{" +
                "nomeCliente='" + getNomeCliente() + '\'' +
                ", numConta=" + getNumConta() +
                ", saldoConta=" + getSaldoContaPoupanca() +
                '}';
    }
    @Override
    public void ExibirSaldo(int tipoConta) {
        System.out.println(super.getSaldoContaPoupanca());
    }
}
