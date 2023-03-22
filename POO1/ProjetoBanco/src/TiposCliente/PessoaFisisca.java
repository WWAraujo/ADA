package TiposCliente;

import TiposConta.Conta;

public class PessoaFisisca extends Cliente implements Conta {
    @Override
    public void depositar(double depositar, int tipoConta) {
        if(tipoConta == 1) {
            // poupaca
            super.setSaldoContaPoupanca(depositar);
            System.out.println("Deposito na conta poupança feito com sucesso!");
            System.out.println("Seu saldo é R$ "+getSaldoContaPoupanca());
        } else if(tipoConta == 2) {
            // investimento
            double novoValor = getSaldoContaInvestimento() + depositar;
            super.setSaldoContaInvestimento(novoValor);
            System.out.println("Deposito na conta investimento feito com sucesso!");
            System.out.println("Seu saldo é R$ "+getSaldoContaInvestimento());
        } else if(tipoConta == 3) {
            //conta corrente
            double novoValor = getSaldoContaCorrente() + depositar;
            super.setSaldoContaCorrente(novoValor);
            System.out.println("Deposito na conta Corrente feito com sucesso!");
            System.out.println("Seu saldo é R$ "+getSaldoContaCorrente());
        }


    }
    @Override
    public void sacar(double sacar, int tipoConta) {

        double valorSacarComJuros = sacar ; //Não tem juros.

        if (tipoConta == 1){
            if (getSaldoContaPoupanca() >= valorSacarComJuros) {

//                double valorAtual = super.getSaldoContaInvestimento();
//                double novoValor = super.getSaldoContaInvestimento() - valorSacarComJuros;
                super.setSaldoContaPoupanca(super.getSaldoContaPoupanca() - valorSacarComJuros);
            } else {
                System.out.println("Não tem saldo suficiente na conta poupanca!");
                System.out.println("Seu saldo é: ");
                exibirSaldo(1);
            }
        }else if(tipoConta == 2) {
            if (getSaldoContaInvestimento() >= valorSacarComJuros) {

//                double valorAtual = super.getSaldoContaInvestimento();
//                double novoValor = super.getSaldoContaInvestimento() - valorSacarComJuros;
                super.setSaldoContaInvestimento(super.getSaldoContaInvestimento() - valorSacarComJuros);
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
            } else {
                System.out.println("Não tem saldo suficiente na conta corrente!");
                System.out.println("Seu saldo é: ");
                exibirSaldo(1);
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

        String[] mostrarSaldoArray = new String[3];
        mostrarSaldoArray[0] ="Saldo Conta Poupança    R$ "+ getSaldoContaPoupanca();
        mostrarSaldoArray[1] ="Saldo Conta Ivestimento R$ "+ getSaldoContaInvestimento();
        mostrarSaldoArray[2] ="Saldo Conta Corrente    R$ "+ getSaldoContaCorrente();

        for ( String i : mostrarSaldoArray) {
            System.out.println(i);
        }

    }
}
