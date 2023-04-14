package br.com.ada.poo2;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Estoque extends Produto{

    public Map<String,Produto> estoque;

    public Map<String,Produto> adicionarEstoque(Produto produto){

        if (estoque == null) {
            estoque = new HashMap<>();
        }
        estoque.put(produto.getNome(),produto);
        return estoque;
    }

    public void mostrarIntensnoEstoque(){
        int contador = 1;
        for (String pdt : estoque.keySet())
            System.out.println(contador+" - "+pdt);
        contador++;
    }

    public Produto procurarItem(String nome){

        Produto pdt = estoque.get(nome);

        if (pdt == null){
            System.out.println("Produto não encontrado");
        } else {
            return pdt;
        }
        return null;
    }

    public void removerEstoque(String nome, int qtd){
        int novoQtd = estoque.get(nome).getQtdEstoque() - qtd;

        Produto novoProduto = estoque.get(nome);
        novoProduto.setQtdEstoque(novoQtd);

        estoque.remove(nome);
        estoque.put(novoProduto.getNome(), novoProduto);
    }

    public Map<String, Produto> retornoEstoque(){
        return estoque;
    }

    public Map<String, Produto> iniciarEstoqueTeste(){

        if (estoque == null){
            estoque = new HashMap<>();
        }
        estoque.put("Arroz",( new CadastrarProduto().cadastrarProduto("Arroz",10, BigDecimal.valueOf(21.10))));
        estoque.put("Feijão",( new CadastrarProduto().cadastrarProduto("Feijão",15, BigDecimal.valueOf(21.10))));
        estoque.put("Macarrão",( new CadastrarProduto().cadastrarProduto("Macarrão",20, BigDecimal.valueOf(21.10))));

        return estoque;
    }
}
