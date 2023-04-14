package br.com.ada.poo2;

import java.math.BigDecimal;

public class Produto {

    private String nome;

    private BigDecimal preco ;

    private int qtdEstoque;

    public int getQtdEstoque() { return qtdEstoque; }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public String getNome() {return nome; }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() { return preco; }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Produto criarProduto(String nome, BigDecimal preco, int qtd){
        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setPreco(preco);
        produto.setQtdEstoque(qtd);

        return produto;
    }

}
