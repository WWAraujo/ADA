package br.com.ada.poo2;

import java.math.BigDecimal;
import java.util.Scanner;

public class CadastrarProduto  {

    public Produto alterarValor(Produto produto, BigDecimal valor){
        produto.setPreco(valor);
        return produto;
    }

    public Produto alterarNome(Produto produto, String nome){
        produto.setNome(nome);
        return produto;
    }

    public Produto cadastrarNovoProdutoConsole () {

        Produto novoProduto = new Produto();

        try {
            Scanner scanner = new Scanner(System.in);

            String nome;
            BigDecimal valor;
            int qtd;

            System.out.println("Digite o nome do produto");
            nome = scanner.nextLine();

            System.out.println("Digite o valor unitario do " + nome);
            valor = BigDecimal.valueOf(Double.parseDouble(scanner.nextLine()));

            System.out.println("Digite a quantidade de " + nome + " para colocar no estoque");
            qtd = Integer.parseInt(scanner.nextLine());


            novoProduto.setNome(nome);
            novoProduto.setPreco(valor);
            novoProduto.setQtdEstoque(qtd);

        } catch (Exception exception){
            System.out.println("Algo deu errado. Digite novamente!");
            cadastrarNovoProdutoConsole();
        }

        return novoProduto;
    }

    public Produto cadastrarProduto(String nome, int qtd, BigDecimal valor){

        Produto novoProduto = new Produto();
        novoProduto.setNome(nome);
        novoProduto.setPreco(valor);
        novoProduto.setQtdEstoque(qtd);
        return novoProduto;
    }
}
