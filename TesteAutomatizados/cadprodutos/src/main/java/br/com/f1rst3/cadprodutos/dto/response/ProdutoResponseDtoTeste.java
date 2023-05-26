package br.com.f1rst3.cadprodutos.dto.response;

public class ProdutoResponseDtoTeste {

    private Long id;
    private String nome;
    private int quantidade;

    public Long getId() {
        return id;
    }

    public ProdutoResponseDtoTeste setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public ProdutoResponseDtoTeste setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public ProdutoResponseDtoTeste setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        return this;
    }
}
