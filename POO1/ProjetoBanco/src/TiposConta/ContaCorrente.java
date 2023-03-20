package TiposConta;

import TiposCliente.Cliente;

public class ContaCorrente extends Cliente {

    @Override
    public String toString() {
        return "ContaCorrente{" +
                "nomeCliente='" + getNomeCliente() + '\'' +
                ", numConta=" + getNumConta() +
                ", saldoConta=" + getSaldoContaCorrente() +
                '}';
    }

    @Override
    public void exibirSaldo(int tipoConta) {
        System.out.println(getSaldoContaCorrente());
    }
}
