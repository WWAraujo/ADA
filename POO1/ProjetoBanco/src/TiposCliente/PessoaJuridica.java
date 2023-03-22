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
            System.out.println("Deposito na conta investimento feito com sucesso!");
            System.out.println("Seu saldo é R$ "+getSaldoContaInvestimento());
        } else if(tipoConta == 3) {

//            Conta Corrente
//            double novoValor = getSaldoContaCorrente() + depositar;
            super.setSaldoContaCorrente(getSaldoContaCorrente() + depositar);
            System.out.println("Deposito na conta Corrente feito com sucesso!");
            System.out.println("Seu saldo é R$ "+getSaldoContaCorrente());
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
                System.out.println("Não tem saldo suficiente na conta Investimento!");
                System.out.println("Seu saldo é: ");
                exibirSaldo(1);
            }
        } else if (tipoConta == 3) {

            if (getSaldoContaCorrente() >= valorSacarComJuros) {
//                double valorAtual = super.getSaldoContaCorrente();
//                double novoValor = super.getSaldoContaCorrente() - valorSacarComJuros;
                super.setSaldoContaCorrente(super.getSaldoContaCorrente() - valorSacarComJuros);
                System.out.println("Tranferencia feita com sucesso! ");
            } else {
                System.out.println("Não tem saldo suficiente na conta corrente!");
                System.out.println("Seu saldo é: ");
                exibirSaldo(1);
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
                depositar(valorTransferirComJuros,tipoContaDestino);
                System.out.println("Tranferencia feita com sucesso! ");
                System.out.println("Seu saldo é: "+getSaldoContaInvestimento());
            } else {
                System.out.println("Não tem saldo suficiente");
            }
        } else if (tipoContaOrigem == 3) {

            if (getSaldoContaCorrente() >= valorTransferirComJuros) {
//                double valorAtual = super.getSaldoContaCorrente();
//                double novoValor = super.getSaldoContaCorrente() - valorSacarComJuros;
                super.setSaldoContaCorrente(super.getSaldoContaCorrente() - valorTransferirComJuros);
                depositar(valorTransferirComJuros,tipoContaDestino);
                System.out.println("Tranferencia feita com sucesso! ");
                System.out.println("Seu saldo é: "+getSaldoContaCorrente());
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
