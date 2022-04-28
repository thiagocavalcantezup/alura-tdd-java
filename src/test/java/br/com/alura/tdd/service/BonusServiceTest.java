package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

public class BonusServiceTest {

    @Test
    void bonusDeveSerZeroParaSalarioAcimaDoLimite() {
        BonusService bonusService = new BonusService();
        Funcionario funcionario = new Funcionario(
            "Thiago", LocalDate.now(), new BigDecimal("20000.00")
        );

        BigDecimal bonus = bonusService.calcularBonus(funcionario);

        assertEquals(BigDecimal.ZERO.setScale(2), bonus);
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
