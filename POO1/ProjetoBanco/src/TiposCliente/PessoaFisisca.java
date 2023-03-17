package TiposCliente;

import TiposConta.Conta;

public class PessoaFisisca extends Cliente implements Conta {


    @Override
    public void depositar(double depositar) {
        double saldoAnterior = getSaldoConta();
        double novoSaldo = saldoAnterior + depositar;
        setSaldoConta(novoSaldo);
        if (saldoAnterior != getSaldoConta()){
            System.out.println("## Deposito realizado com sucesso! ##");
        } else {
            System.out.println("## Operação de deposito falhou.##");
        }
    }

    @Override
    public void sacar(double sacar) {

    }

    @Override
    public void exibirSaldo() {

    }
}
