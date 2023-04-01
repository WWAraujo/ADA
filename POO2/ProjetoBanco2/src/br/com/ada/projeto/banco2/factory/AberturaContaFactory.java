package br.com.ada.projeto.banco2.factory;

import br.com.ada.projeto.banco2.entity.ContaCorrente;
import br.com.ada.projeto.banco2.entity.ContaInvestimento;
import br.com.ada.projeto.banco2.entity.ContaPoupanca;
import br.com.ada.projeto.banco2.service.abrirconta.AberturaConta;
import br.com.ada.projeto.banco2.service.abrirconta.AberturaContaCorrente;
import br.com.ada.projeto.banco2.service.abrirconta.AberturaContaInvestimento;
import br.com.ada.projeto.banco2.service.abrirconta.AberturaContaPoupanca;

public class AberturaContaFactory {

    public static AberturaConta getAberturaContaFactory(String tipo){
        AberturaConta aberturaConta = null;

        if ("CC".equals(tipo)){
            aberturaConta = new AberturaContaCorrente();
        } else if ("CP".equals(tipo)){
            aberturaConta = new AberturaContaPoupanca();
        } else if ("CI".equals(tipo)){
            aberturaConta = new AberturaContaInvestimento();
        }

        return aberturaConta;
    }
}
