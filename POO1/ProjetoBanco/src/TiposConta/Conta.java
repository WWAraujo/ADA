package TiposConta;

public interface Conta {

    public abstract void Depositar(double depositar, int tipoConta);

    public abstract void Sacar(double sacar);

    public abstract void ExibirSaldo();

    public abstract void Tranaferir();


}
