package br.com.alura.tdd.service;

import java.math.BigDecimal;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteService {

    public void concederReajuste(Funcionario funcionario, Desempenho desempenho) {
        BigDecimal reajustePorcento;
        BigDecimal reajuste;

        switch (desempenho) {
            case A_DESEJAR:
                reajustePorcento = new BigDecimal("0.03");
                break;

            case BOM:
                reajustePorcento = new BigDecimal("0.15");
                break;

            case OTIMO:
                reajustePorcento = new BigDecimal("0.20");
                break;

            default:
                reajustePorcento = BigDecimal.ZERO;
                break;
        }

        reajuste = funcionario.getSalario().multiply(reajustePorcento);

        funcionario.reajustarSalario(reajuste);
    }

}
