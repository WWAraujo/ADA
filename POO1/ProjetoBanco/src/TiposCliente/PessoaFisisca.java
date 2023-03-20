package TiposCliente;

import TiposConta.Conta;

public class PessoaFisisca extends Cliente implements Conta {
    @Override
    public void depositar(double depositar, int tipoConta) {
        if(tipoConta == 1) {
            // poupaca
            super.setSaldoContaPoupanca(depositar);
        } else if(tipoConta == 2) {
            // investimento
            double novoValor = getSaldoContaInvestimento() + depositar;
            super.setSaldoContaInvestimento(novoValor);
        } else if(tipoConta == 3) {
            //conta corrente
            double novoValor = getSaldoContaCorrente() + depositar;
            super.setSaldoContaInvestimento(novoValor);
        }

        System.out.println(getSaldoContaPoupanca());

    }
    @Override
    public void sacar(double sacar, int tipoConta) {

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
    public void transferir(double transferir, int tipoConta) {

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
    public void exibirSaldo(int tipoConta) {

        System.out.println("Saldo Conta Poupança "+ getSaldoContaPoupanca());
        System.out.println("Saldo Conta Ivestimento "+ getSaldoContaInvestimento());
        System.out.println("Saldo Conta Corrente "+ getSaldoContaCorrente());

    }
}
