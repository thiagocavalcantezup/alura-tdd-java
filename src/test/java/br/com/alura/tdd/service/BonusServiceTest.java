package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

public class BonusServiceTest {

    @Test
    void argumentoIlegalParaSalarioAcimaDoLimite() {
        BonusService bonusService = new BonusService();
        Funcionario funcionario = new Funcionario(
            "Thiago", LocalDate.now(), new BigDecimal("20000.00")
        );

        // Método 1
        // assertThrows(IllegalArgumentException.class, () ->
        // bonusService.calcularBonus(funcionario));

        // Método 2
        try {
            bonusService.calcularBonus(funcionario);
            fail("Não houve exceção de argumento ilegal.");
        } catch (IllegalArgumentException e) {
            assertEquals(
                "Funcionários com salário acima de R$10.000,00 não podem receber bônus.",
                e.getMessage()
            );
        }
    }

    @Test
    void bonusDeveSerDezPorcentoDoSalarioAbaixoDoLimite() {
        BonusService bonusService = new BonusService();
        Funcionario funcionario = new Funcionario(
            "Thiago", LocalDate.now(), new BigDecimal("2500.00")
        );

        BigDecimal bonus = bonusService.calcularBonus(funcionario);

        assertEquals(new BigDecimal("250.00"), bonus);
    }

    @Test
    void bonusDeveSerDezPorcentoDoSalarioNoLimite() {
        BonusService bonusService = new BonusService();
        Funcionario funcionario = new Funcionario(
            "Thiago", LocalDate.now(), new BigDecimal("10000.00")
        );

        BigDecimal bonus = bonusService.calcularBonus(funcionario);

        assertEquals(new BigDecimal("1000.00"), bonus);
    }

}
