package TiposConta;

import TiposCliente.Cliente;

public class ContaCorrente extends Cliente {

    @Override
    public String toString() {
        return "ContaCorrente{" +
                "nomeCliente='" + nomeCliente + '\'' +
                ", numConta=" + numConta +
                ", saldoConta=" + saldoConta +
                '}';
    }
}
