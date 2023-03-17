package TiposCliente;

public abstract class Cliente {

    protected String nomeCliente;
    protected int numConta;
    protected double saldoConta;

    public abstract void depositar(double depositar);

    public abstract void sacar(double sacar);

    public abstract void exibirSaldo ();

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

    public double getSaldoConta() {
        return saldoConta;
    }

    public void setSaldoConta(double saldoConta) {
        this.saldoConta = saldoConta;
    }
}
