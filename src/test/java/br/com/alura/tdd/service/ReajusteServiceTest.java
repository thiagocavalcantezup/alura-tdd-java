package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteServiceTest {

    @Test
    void reajusteDeveSerTrêsPorcentoParaDesempenhoADesejar() {
        ReajusteService reajusteService = new ReajusteService();
        Funcionario funcionario = new Funcionario(
            "Thiago", LocalDate.now(), new BigDecimal("10000.00")
        );

        reajusteService.concederReajuste(funcionario, Desempenho.A_DESEJAR);

        assertEquals(new BigDecimal("10300.00"), funcionario.getSalario());
    }

    @Test
    void reajusteDeveSerQuinzePorcentoParaDesempenhoBom() {
        ReajusteService reajusteService = new ReajusteService();
        Funcionario funcionario = new Funcionario(
            "Thiago", LocalDate.now(), new BigDecimal("10000.00")
        );

        reajusteService.concederReajuste(funcionario, Desempenho.BOM);

        assertEquals(new BigDecimal("11500.00"), funcionario.getSalario());
    }

    @Test
    void reajusteDeveSerVintePorcentoParaDesempenhoOtimo() {
        ReajusteService reajusteService = new ReajusteService();
        Funcionario funcionario = new Funcionario(
            "Thiago", LocalDate.now(), new BigDecimal("10000.00")
        );

        reajusteService.concederReajuste(funcionario, Desempenho.OTIMO);

        assertEquals(new BigDecimal("12000.00"), funcionario.getSalario());
    }

}
