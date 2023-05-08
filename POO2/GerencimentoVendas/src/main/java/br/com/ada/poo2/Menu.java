package br.com.ada.poo2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {

    public static String scanner (){
        Scanner scanner = new Scanner(System.in);
        String entrada = scanner.nextLine();
        return entrada;
    }

    public static Integer entradaNumero () {
        int numero = 0 ;
        try {
            numero = Integer.parseInt(scanner());
        }catch (Exception exception){
            System.out.println("Digite apenas numero.");
            entradaNumero();
        }
        return numero;
    }

    public static Integer qtdVendida () {
        System.out.println("Digite a quantidade para colocar no carrinho.");
        int quantidadeVendida = entradaNumero();
        return quantidadeVendida;
    }

    public static Integer incluirItenListaCarrinho () {
        System.out.println("Deseja iserir mais itens no carrinho? \n" +
                "1 - SIM \n" +
                "2 - Finalizar Venda.");
        int finalizarVenda = entradaNumero();
        return finalizarVenda;
    }

    public static void menu(){

        TipoPessoa pessoa = new TipoPessoa();
        pessoa.escolhaTipoPessoa();

        /*
        Craindo um banco de dados para o estoque
         */
        Estoque estoque = new Estoque();

        int usarEstoque = usarEstoque();
        int continuar;

        if (usarEstoque == 1 ){
            estoque.iniciarEstoqueTeste();
        } else {
            estoque.adicionarEstoque(new CadastrarProduto().cadastrarNovoProdutoConsole());
            System.out.println("Deseja cadastrar mais iten no estoque? \n" +
                    "1 - SIM \n" +
                    "2 - Não");
            continuar = Integer.parseInt(scanner());
            while (continuar == 1){
                estoque.adicionarEstoque(new CadastrarProduto().cadastrarNovoProdutoConsole());
                System.out.println("Deseja cadastrar mais iten no estoque? \n" +
                        "1 - SIM \n" +
                        "2 - Não");
                continuar = Integer.parseInt(scanner());
            }
        }

        /*
        Usando o carrinho
         */

        System.out.println("Bem vindo "+pessoa.getNome()+". ");

        Map<String,Produto> listaItensVenda = new HashMap<>();
        Produto produto;

        do {
            produto =  estoque.pedirItenEstoque();
        } while (produto == null);

        listaItensVenda.put(produto.getNome(), produto);

        while (incluirItenListaCarrinho() == 1){
            produto =  estoque.pedirItenEstoque();
            listaItensVenda.put(produto.getNome(), produto);
            System.out.println("Deseja iserir mais itens no carrinho? \n" +
                    "1 - SIM \n" +
                    "2 - Finalizar Venda. \n");
        }

        Carrinho.finalizarVenda(listaItensVenda,pessoa);
    }

    public static int usarEstoque (){
        System.out.println("Deseja usar o estoque pre instalado? \n" +
                "1 - SIM \n" +
                "2 - NA0, quero inserir manualmente.");
        int resp = Integer.parseInt(scanner());
        if (resp <1 || resp > 2){
            usarEstoque();
        }
        return resp;
    }



}








