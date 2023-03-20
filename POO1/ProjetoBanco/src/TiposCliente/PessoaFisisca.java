package TiposCliente;

import TiposConta.Conta;

public class PessoaFisisca extends Cliente implements Conta {
    @Override
    public void Depositar(double depositar, int tipoConta) {
        if(tipoConta == 1) {
            double novoValor = getSaldoContaPoupanca() + depositar;
            super.setSaldoContaPoupanca(getSaldoContaPoupanca());
        } else if(tipoConta == 2) {
            double novoValor = getSaldoContaInvestimento() + depositar;
            super.setSaldoContaInvestimento(getSaldoContaInvestimento());
        } else if(tipoConta == 3) {
            double novoValor = getSaldoContaCorrente() + depositar;
            super.setSaldoContaInvestimento(getSaldoContaCorrente());
        } else {
            System.out.println("Erro no tipo da conta");
        }
    }
    @Override
    public void Sacar(double sacar, int tipoConta) {

        double valorSacarComJuros = sacar ; //Não tem juros.

        if(tipoConta == 2) {
            if (getSaldoContaInvestimento() >= valorSacarComJuros) {

//                double valorAtual = super.getSaldoContaInvestimento();
//                double novoValor = super.getSaldoContaInvestimento() - valorSacarComJuros;
                super.setSaldoContaInvestimento(super.getSaldoContaInvestimento() - valorSacarComJuros);
            } else {
                System.out.println("Não tem saldo suficiente");
            }
        } else if (tipoConta == 3) {

            if (getSaldoContaCorrente() >= valorSacarComJuros) {
//                double valorAtual = super.getSaldoContaCorrente();
//                double novoValor = super.getSaldoContaCorrente() - valorSacarComJuros;
                super.setSaldoContaCorrente(super.getSaldoContaCorrente() - valorSacarComJuros);
            } else {
                System.out.println("Não tem saldo suficiente");
            }
        }
    }
    @Override
    public void Transferir(double transferir, int tipoConta) {

        double valorTransferirComJuros = transferir ;

        if(tipoConta == 2) {
            if (getSaldoContaInvestimento() >= valorTransferirComJuros) {

//                double valorAtual = super.getSaldoContaInvestimento();
//                double novoValor = super.getSaldoContaInvestimento() - valorSacarComJuros;
                super.setSaldoContaInvestimento(super.getSaldoContaInvestimento() - valorTransferirComJuros);
                System.out.println("Tranferencia feita com sucesso! ");
            } else {
                System.out.println("Não tem saldo suficiente");
            }
        } else if (tipoConta == 3) {

            if (getSaldoContaCorrente() >= valorTransferirComJuros) {
//                double valorAtual = super.getSaldoContaCorrente();
//                double novoValor = super.getSaldoContaCorrente() - valorSacarComJuros;
                super.setSaldoContaCorrente(super.getSaldoContaCorrente() - valorTransferirComJuros);
                System.out.println("Tranferencia feita com sucesso! ");
            } else {
                System.out.println("Não tem saldo suficiente");
            }
        }
    }
    @Override
    public void ExibirSaldo(int tipoConta) {

        if(tipoConta == 1) {
            System.out.println(super.getSaldoContaPoupanca());
        } else if(tipoConta == 2) {
            //            Conta Investimento
            System.out.println(super.getSaldoContaInvestimento());
        } else if(tipoConta == 3) {
            //            Conta Corrente
            System.out.println(getSaldoContaCorrente());
        } else {
            System.out.println("Não entendi o numero da conta!");
        }

    }
}
