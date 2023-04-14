package br.com.ada.poo2;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

public class FinalizarVenda {

    private LocalDateTime data;

    public static void finalizar(Map<String,Produto> listaItens, Pessoa cliente) {

        System.out.println("Nome do cliente: "+cliente.getNome());

        BigDecimal valorTotal = BigDecimal.valueOf(0);

        for (Map.Entry<String,Produto> produtoEntry : listaItens.entrySet()) {

            BigDecimal qtd = BigDecimal.valueOf(produtoEntry.getValue().getQtdEstoque());
            BigDecimal valor = produtoEntry.getValue().getPreco();
            BigDecimal total = null;
            try {
                total = valor.multiply(qtd);
            } catch (Exception exception){
                System.out.println(exception + " No calculo do "+ produtoEntry.getValue().getNome());
            }

            System.out.println(
                    " "+produtoEntry.getValue().getNome()+" " +
                    "Qtd: "+produtoEntry.getValue().getQtdEstoque()+" " +
                    "Unid R$: "+ produtoEntry.getValue().getPreco()+" " +
                    "Total item R$"+ total);

            valorTotal = valorTotal.add(total);
        }

        System.out.println("Toal da compra R$ "+valorTotal);
    }

    public static void iterateUsingEntrySet(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        // mapIdade.forEach((key, value) -> {
        //            System.out.println(key);
        //            System.out.println(value);
        //        });
    }
}
