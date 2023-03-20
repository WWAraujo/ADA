package TiposConta;

import TiposCliente.Cliente;
import TiposCliente.PessoaFisisca;

public class ContaInvestimento extends Cliente{

    PessoaFisisca pf = new PessoaFisisca();

    public String toString() {
        return "ContaCorrente{" +
                "nomeCliente='" + getNomeCliente() + '\'' +
                ", numConta=" + getNumConta() +
                ", saldoConta=" + getSaldoContaInvestimento() +
                '}';
    }

    @Override
    public void ExibirSaldo(int tipoConta) {
        System.out.println(super.getSaldoContaInvestimento());
    }
}
