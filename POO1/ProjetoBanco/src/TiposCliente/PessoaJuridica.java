package TiposCliente;

import TiposConta.Conta;

public class PessoaJuridica extends Cliente implements Conta{
    @Override
    public void Depositar(double depositar, int tipoConta) {
        if(tipoConta == 1) {
            System.out.println("Voce não tem conta poupanca");
        } else if(tipoConta == 2) {
//            Conta Investimento
//            Rende 2% a mais
//            double novoValor = getSaldoContaInvestimento() + depositar;
//            double depositoComRendimento = depositar * 1.02 ;

            super.setSaldoContaInvestimento(getSaldoContaInvestimento() + (depositar * 1.02));
        } else if(tipoConta == 3) {

//            Conta Corrente
//            double novoValor = getSaldoContaCorrente() + depositar;
            super.setSaldoContaCorrente(getSaldoContaCorrente() + depositar);
        } else {
            System.out.println("Não entendi o numero da conta!");
        }
    }
    @Override
    public void Sacar(double sacar, int tipoConta) {

        double valorSacarComJuros = sacar * 1.005 ;

        if(tipoConta == 2) {
            if (getSaldoContaInvestimento() >= valorSacarComJuros) {

//                double valorAtual = super.getSaldoContaInvestimento();
//                double novoValor = super.getSaldoContaInvestimento() - valorSacarComJuros;
                super.setSaldoContaInvestimento(super.getSaldoContaInvestimento() - valorSacarComJuros);
                System.out.println("Tranferencia feita com sucesso! ");
            } else {
                System.out.println("Não tem saldo suficiente");
            }
        } else if (tipoConta == 3) {

            if (getSaldoContaCorrente() >= valorSacarComJuros) {
//                double valorAtual = super.getSaldoContaCorrente();
//                double novoValor = super.getSaldoContaCorrente() - valorSacarComJuros;
                super.setSaldoContaCorrente(super.getSaldoContaCorrente() - valorSacarComJuros);
                System.out.println("Tranferencia feita com sucesso! ");
            } else {
                System.out.println("Não tem saldo suficiente");
            }
        }
    }
    @Override
    public void Transferir(double transferir, int tipoConta) {

        double valorTransferirComJuros = transferir * 1.005 ;

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
            System.out.println("Voce não tem conta poupanca");
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
