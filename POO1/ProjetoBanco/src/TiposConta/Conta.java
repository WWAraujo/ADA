package TiposConta;

public interface Conta {

    public abstract void depositar(double depositar, int tipoConta);

    public abstract void sacar(double sacar, int tipoConta);

    public abstract void exibirSaldo(int tipoConta);

    public abstract void transferir(double transferir, int tipoContaOrigem, int tipoContaDestino);

}
