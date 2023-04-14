package br.com.ada.poo2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListaCarrinhoCompra extends Produto{
    private Map<String,Produto> carrinhoDeCompra;

    public void adicionarLista(Produto produto){
        Produto novoProduto = new Produto();

        if (carrinhoDeCompra == null){
            carrinhoDeCompra = new HashMap<>();
            carrinhoDeCompra.put(produto.getNome(),produto);
        } else {
            carrinhoDeCompra.put(produto.getNome(),produto);
        }
    }
}
