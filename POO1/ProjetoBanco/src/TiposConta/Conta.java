package TiposConta;

public interface Conta {

    public abstract void Depositar(double depositar, int tipoConta);

    public abstract void Sacar(double sacar, int tipoConta);

    public abstract void ExibirSaldo(int tipoConta);

    public abstract void Transferir(double transferir, int tipoConta);

}
