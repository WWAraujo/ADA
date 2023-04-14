package br.com.ada.poo2;

import java.util.*;

import static br.com.ada.poo2.FinalizarVenda.finalizar;


public class Carrinho {

    private Map<String,Produto> item;
    private Pessoa cliente;

    public Map<String, Produto> getItem() {
        return item;
    }

    public void setItem(Map<String, Produto> item) {
        this.item = item;
    }

    public void icluirListaCarrinho(Pessoa pessoa, Map<String, Produto> vendaInicial){
        cliente = pessoa;
        if (item == null){
            item = new HashMap<>();
            item.putAll(vendaInicial);
        } else {
            item.putAll(vendaInicial);
        }
    }

    public Map<String,Produto> incluirProdutosCarrinho (Produto produto) {
        String key = produto.getNome();
        int qtdVendida = produto.getQtdEstoque();
        int sqtEstoque = item.get(key).getQtdEstoque();
        int novoQtdEstoque = sqtEstoque - qtdVendida;

        if (item == null){
            item = new HashMap<>();
            item.put(produto.getNome(),produto);
        } else {
            if (item.containsKey(key)){
                item.get(key).setQtdEstoque(novoQtdEstoque);
            }
            item.put(produto.getNome(),produto);
        }
        return item;
    }

    public void finalizarVenda(){
        finalizar(item , cliente);
    }
}
