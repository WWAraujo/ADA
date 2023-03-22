package TiposCliente;

import TiposConta.Conta;

public class PessoaJuridica extends Cliente implements Conta{
    @Override
    public void depositar(double depositar, int tipoConta) {
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
    public void sacar(double sacar, int tipoConta) {

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
    public void transferir(double transferir, int tipoContaOrigem, int tipoContaDestino) {

        double valorTransferirComJuros = transferir * 1.005 ;

        if(tipoContaOrigem == 2) {
            if (getSaldoContaInvestimento() >= valorTransferirComJuros) {

//                double valorAtual = super.getSaldoContaInvestimento();
//                double novoValor = super.getSaldoContaInvestimento() - valorSacarComJuros;
                super.setSaldoContaInvestimento(super.getSaldoContaInvestimento() - valorTransferirComJuros);
                System.out.println("Tranferencia feita com sucesso! ");
            } else {
                System.out.println("Não tem saldo suficiente");
            }
        } else if (tipoContaOrigem == 3) {

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

        String[] mostrarSaldoArray = new String[3];
//        mostrarSaldoArray[0] ="Saldo Conta Poupança    R$ "+ getSaldoContaPoupanca();
        mostrarSaldoArray[1] ="Saldo Conta Ivestimento R$ "+ getSaldoContaInvestimento();
        mostrarSaldoArray[2] ="Saldo Conta Corrente    R$ "+ getSaldoContaCorrente();

        for ( String i : mostrarSaldoArray) {
            System.out.println(i);
        }

    }
}
