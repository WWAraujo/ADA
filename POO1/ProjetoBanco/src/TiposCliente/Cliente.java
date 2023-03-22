package TiposCliente;

public abstract class Cliente {

    private String nomeCliente;
    private int numConta;
    private double saldoContaPoupanca;

    private double saldoContaInvestimento;

    private double saldoContaCorrente;


    protected double getSaldoContaCorrente() {
        return saldoContaCorrente;
    }

    protected void setSaldoContaCorrente(double saldoContaCorrente) {

        this.saldoContaCorrente = saldoContaCorrente;
    }

    protected double getSaldoContaInvestimento() {
        return saldoContaInvestimento;
    }

    protected void setSaldoContaInvestimento(double saldoContaInvestimento) {
        this.saldoContaInvestimento = saldoContaInvestimento;
    }

    protected double getSaldoContaPoupanca() {
        return saldoContaPoupanca;
    }

    protected void setSaldoContaPoupanca(double saldoContaPoupanca) {
        this.saldoContaPoupanca = saldoContaPoupanca ;
    }

    protected String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    protected int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    protected abstract void exibirSaldo(int tipoConta);

}
