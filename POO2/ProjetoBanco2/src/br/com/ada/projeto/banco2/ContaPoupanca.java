package br.com.ada.projeto.banco2;

public class ContaPoupanca extends Conta {

    private PessoaFisica cliente;

    @Override
    public PessoaFisica getCliente() {
        return cliente;
    }
    @Override
    public void setCliente(PessoaFisica cliente) {
        this.cliente = cliente;
    }
}
