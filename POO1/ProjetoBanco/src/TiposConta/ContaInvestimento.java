package TiposConta;

import TiposCliente.Cliente;

public class ContaInvestimento extends Cliente{

    public String toString() {
        return "ContaCorrente{" +
                "nomeCliente='" + getNomeCliente() + '\'' +
                ", numConta=" + getNumConta() +
                ", saldoConta=" + getSaldoContaInvestimento() +
                '}';
    }

    @Override
    public void exibirSaldo(int tipoConta) {
        System.out.println(super.getSaldoContaInvestimento());
    }
}
