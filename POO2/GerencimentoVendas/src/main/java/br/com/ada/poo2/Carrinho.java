package br.com.ada.poo2;

import java.util.*;

import static br.com.ada.poo2.Estoque.procurarProduto;
import static br.com.ada.poo2.FinalizarVenda.finalizar;


public class Carrinho {

    private Map<String,Produto> venda;
    private Pessoa cliente;

    public Map<String, Produto> getVenda() {
        return venda;
    }

    public void setVenda(Map<String, Produto> venda) {
        this.venda = venda;
    }


    public void icluirListaCarrinho(Pessoa pessoa, Map<String, Produto> vendaInicial){
        cliente = pessoa;
        if (venda == null){
            venda = new HashMap<>();
            venda.putAll(vendaInicial);
        } else {
            venda.putAll(vendaInicial);
        }
    }

    public Map<String,Produto> incluirProdutosCarrinho (String nome, int quantidadeVendida) {

        String key = nome;

        Produto produto = new Produto();

        int novoQtdEstoque = 0 ;

        try {
            int qtdVendida = quantidadeVendida;
            int sqtEstoque = procurarProduto(key).getQtdEstoque();
            novoQtdEstoque = sqtEstoque - qtdVendida;
        }catch (Exception exception){
            System.out.println("Erro no calculo do estoque.");
        }

        produto.setNome(nome);
        produto.setQtdEstoque(novoQtdEstoque);
        if (venda == null){
            venda = new HashMap<>();
            venda.put(key,produto);
        } else {
            if (venda.containsKey(key)){
                venda.get(key).setQtdEstoque(novoQtdEstoque);
            }
            venda.put(produto.getNome(),produto);
        }
        return venda;
    }

    public static void finalizarVenda(Map<String, Produto> lista, Pessoa pessoa){
        finalizar(lista, pessoa);
    }


}
