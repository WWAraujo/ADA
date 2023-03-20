package TiposCliente;

public abstract class Cliente {

    private String nomeCliente;
    private int numConta;
    private double saldoContaPoupanca;

    private double saldoContaInvestimento;

    private double saldoContaCorrente;


    public double getSaldoContaCorrente() {
        return saldoContaCorrente;
    }

    public void setSaldoContaCorrente(double saldoContaCorrente) {
        this.saldoContaCorrente = saldoContaCorrente;
    }

    public double getSaldoContaInvestimento() {
        return saldoContaInvestimento;
    }

    public void setSaldoContaInvestimento(double saldoContaInvestimento) {
        this.saldoContaInvestimento = saldoContaInvestimento;
    }

    public double getSaldoContaPoupanca() {
        return saldoContaPoupanca;
    }

    public void setSaldoContaPoupanca(double saldoContaPoupanca) {
        this.saldoContaPoupanca = saldoContaPoupanca;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public abstract void ExibirSaldo(int tipoConta);

//    public double getSaldoConta() {
//        return saldoContaPoupanca;
//    }
//
//    public void setSaldoConta(double saldoConta) {
//        this.saldoContaPoupanca = saldoConta;
//    }
}
