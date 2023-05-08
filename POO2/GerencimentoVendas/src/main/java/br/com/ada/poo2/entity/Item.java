package br.com.ada.poo2.entity;

import br.com.ada.poo2.Produto;


public class Item {

    private Produto produto;

    private int qtsVenda;

    public int getQtsVenda() {
        return qtsVenda;
    }

    public void setQtsVenda(int qtsVenda) {
        this.qtsVenda = qtsVenda;
    }
}
