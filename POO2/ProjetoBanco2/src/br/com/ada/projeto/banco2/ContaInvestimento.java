package br.com.ada.projeto.banco2;

public class ContaInvestimento extends Conta{

    private Pessoa cliente;

    @Override
    public Pessoa getCliente() {
        return cliente;
    }

    @Override
    public void setCliente(Pessoa cliente) {
        this.cliente = cliente;
    }
}
