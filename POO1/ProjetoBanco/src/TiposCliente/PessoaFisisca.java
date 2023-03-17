package TiposCliente;

public class PessoaFisisca extends Cliente {


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
