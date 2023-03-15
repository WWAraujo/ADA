public abstract class Conta {
    protected String nomeCliente;
    protected int numConta;
    protected double saldo;

    public abstract void depositar(double depositar);

    public abstract void sacar(double sacar);

    public abstract void exibirSaldo ();

    public String getNomeCliente() {return nomeCliente;}

    public void setNomeCliente(String nomeCliente) {this.nomeCliente = nomeCliente;}

    public int getNumConta() {return numConta;}

    public void setNumConta(int numConta) {this.numConta = numConta;}
}