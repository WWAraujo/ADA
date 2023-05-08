package br.com.ada.poo2;

import org.jetbrains.annotations.Nullable;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static br.com.ada.poo2.Menu.qtdVendida;
import static br.com.ada.poo2.Menu.scanner;

public class Estoque extends Produto {

    public static Map<String, Produto> estoque;

    public void adicionarEstoque(Produto produto) {

        if (produto != null) {
            if (estoque == null) {
                estoque = new HashMap<>();
            }
            estoque.put(produto.getNome(), produto);
            System.out.println("Adicionado ao estoque com sucesso!");
        }
        System.out.println("Erro produto vazio");
    }

    public static void mostrarIntensnoEstoque() {
        for (Map.Entry<String, Produto> entry : estoque.entrySet()) {
            System.out.println(entry.getValue().getQtdEstoque() + ":" + entry.getKey());
        }
    }

    public static Produto procurarProduto(String nome) {

        Produto pdt = estoque.get(nome);

        if (pdt == null) {
            System.out.println("Produto não encontrado");
        } else {
            return pdt;
        }
        return null;
    }

    public static void removerEstoque(String nome, int qtd) {
        int novoQtd = estoque.get(nome).getQtdEstoque() - qtd;

        Produto novoProduto = estoque.get(nome);
        novoProduto.setQtdEstoque(novoQtd);

        estoque.put(novoProduto.getNome(), novoProduto);
    }

    /**
     *
      * @return null não tem estoque suficiente
     */
    private static @Nullable Produto controlarEstoque() {

        mostrarIntensnoEstoque();

        System.out.println("Digite o nome do produto que deseja inserir.");
        String keyProduto = scanner();

        Produto produto = procurarProduto(keyProduto);

        int menuerro = 0;

        if (produto == null) {
            System.out.println("Produto não encontrado, o que deseja fazer? \n" +
                    "1 - Mostrar estoque novamente? \n" +
                    "2 - Tentar procurar outro produto? \n" +
                    "3 - Sair");
            menuerro = Integer.parseInt(scanner());
        }

        switch (menuerro) {
            case 1:
                mostrarIntensnoEstoque();
                break;
            case 2:
                controlarEstoque();
                break;
            case 3:
                System.out.println("Saindo..");
                break;
            default:
                System.out.println("Produto encontrado");
                break;
        }

        System.out.println("Qual a quantidade de produto?");
        int qtdVendida = Menu.entradaNumero();
        int qtdEstoque = produto.getQtdEstoque();
        if ((qtdEstoque - qtdVendida) >= 0) {

            estoque.put(produto.getNome(), produto);

            produto.setQtdEstoque(qtdVendida);

            return produto;

        } else {
            System.out.println("Não tem estoque suficiente.");
            mostrarIntensnoEstoque();
        }
        System.out.println("Não tem estoque suficiente");
        return null;
    }

    public static Produto pedirItenEstoque () {
        Produto produto = controlarEstoque();
        return produto;
    }

    public Map<String, Produto> iniciarEstoqueTeste() {

        if (estoque == null) {
            estoque = new HashMap<>();
        }
        estoque.put("Arroz", (new CadastrarProduto().cadastrarProduto("Arroz", 10, BigDecimal.valueOf(21.10))));
        estoque.put("Feijão", (new CadastrarProduto().cadastrarProduto("Feijão", 15, BigDecimal.valueOf(11.50))));
        estoque.put("Macarrão", (new CadastrarProduto().cadastrarProduto("Macarrão", 20, BigDecimal.valueOf(6.90))));

        return estoque;
    }
}
