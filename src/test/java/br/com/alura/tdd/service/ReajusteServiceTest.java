package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteServiceTest {

    private ReajusteService reajusteService;
    private Funcionario funcionario;

    private static Stream<Arguments> desempenhoParaSalario() {
        return Stream.of(
            arguments(Desempenho.A_DESEJAR, new BigDecimal("10300.00")),
            arguments(Desempenho.BOM, new BigDecimal("11500.00")),
            arguments(Desempenho.OTIMO, new BigDecimal("12000.00"))
        );
    }

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

    @ParameterizedTest(name = "Desempenho {0} recebe um salário reajustado para R${1}")
    @MethodSource("desempenhoParaSalario")
    void reajusteDeveSerXPorcentoParaDesempenhoY(Desempenho desempenho, BigDecimal salario) {
        reajusteService.concederReajuste(funcionario, desempenho);

        assertEquals(salario, funcionario.getSalario());
    }

}
