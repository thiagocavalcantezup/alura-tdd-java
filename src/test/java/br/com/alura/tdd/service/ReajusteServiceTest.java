package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteServiceTest {

    private ReajusteService reajusteService;
    private Funcionario funcionario;

    @BeforeEach
    void setUp() {
        System.out.println("ANTES DO TESTE.");
        reajusteService = new ReajusteService();
        funcionario = new Funcionario("Thiago", LocalDate.now(), new BigDecimal("10000.00"));
    }

    @AfterEach
    void end() {
        System.out.println("DEPOIS DO TESTE.");
    }

    @BeforeAll
    static void setUpAll() {
        System.out.println("ANTES DOS TESTES.");
    }

    @AfterAll
    static void endAll() {
        System.out.println("DEPOIS DOS TESTES.");
    }

    @Test
    void reajusteDeveSerTrêsPorcentoParaDesempenhoADesejar() {
        reajusteService.concederReajuste(funcionario, Desempenho.A_DESEJAR);

        assertEquals(new BigDecimal("10300.00"), funcionario.getSalario());
    }

    @Test
    void reajusteDeveSerQuinzePorcentoParaDesempenhoBom() {
        reajusteService.concederReajuste(funcionario, Desempenho.BOM);

        assertEquals(new BigDecimal("11500.00"), funcionario.getSalario());
    }

    @Test
    void reajusteDeveSerVintePorcentoParaDesempenhoOtimo() {
        reajusteService.concederReajuste(funcionario, Desempenho.OTIMO);

        assertEquals(new BigDecimal("12000.00"), funcionario.getSalario());
    }

}
