package br.com.ada.poo2;

import java.util.Scanner;

public class Menu {

    public static String scanner (){
        Scanner scanner = new Scanner(System.in);
        String entrada = scanner.nextLine();
        return entrada;
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
        Carrinho venda = new Carrinho();
        System.out.println("Bem vindo "+pessoa.getNome()+". ");

        Produto produto ;

        do {
            produto = controlarEstoque(estoque);
        } while (produto == null);
        venda.incluirProdutosCarrinho(produto);

        System.out.println("Deseja iserir mais itens no carrinho ?");
        venda.finalizarVenda();
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

    public static Produto controlarEstoque(Estoque estoque){

        estoque.mostrarIntensnoEstoque();

        System.out.println("Digite o nome do produto que deseja inserir.");
        String keyProduto = scanner();

        Produto produto = estoque.procurarItem(keyProduto);

        int menuerro = 0;
        if (produto == null){
            System.out.println("O que deseja fazer? \n" +
                    "1 - Mostrar estoque novamente? \n" +
                    "2 - Tentar Inserir novemente? \n" +
                    "3 - Sair");
            menuerro = Integer.parseInt(scanner());
        }

        switch (menuerro) {
            case 1 :
                estoque.mostrarIntensnoEstoque();
                break;
            case 2 :
                controlarEstoque(estoque);
                break;
            case 3 :
                System.out.println("Saindo..");
                break;
            default:
                System.out.println("Produto inserido com sucesso");
                break;
        }
        return produto;
    }

}








