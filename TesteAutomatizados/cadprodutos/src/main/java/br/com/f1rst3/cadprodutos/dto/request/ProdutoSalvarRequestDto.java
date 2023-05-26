package br.com.f1rst3.cadprodutos.dto.request;

public class ProdutoSalvarRequestDto {

    private String nome;
    private int quantidade;

    public String getNome() {
        return nome;
    }

    public ProdutoSalvarRequestDto setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public ProdutoSalvarRequestDto setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        return this;
    }
}
