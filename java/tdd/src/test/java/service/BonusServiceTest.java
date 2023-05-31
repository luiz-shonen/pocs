package service;

import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.BonusService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

class BonusServiceTest {
    @Test
    void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
        final var service = new BonusService();
        final var bonus = service.calcularBonus(new Funcionario("Jéssica", LocalDate.now(), BigDecimal.valueOf(25000)));

        Assertions.assertEquals(BigDecimal.ZERO.setScale(2, RoundingMode.FLOOR), bonus);
    }

    @Test
    void bonusDeveriaSer10PorCentoDoSalario() {
        final var service = new BonusService();
        final var bonus = service.calcularBonus(new Funcionario("Jéssica", LocalDate.now(), BigDecimal.valueOf(2500)));

        Assertions.assertEquals(BigDecimal.valueOf(250).setScale(2, RoundingMode.FLOOR), bonus);
    }

    @Test
    void bonusDeveriaSer10PorCentoParaSalarioDeExatamente10000() {
        final var service = new BonusService();
        final var bonus = service.calcularBonus(new Funcionario("Jéssica", LocalDate.now(), BigDecimal.valueOf(10000)));

        Assertions.assertEquals(BigDecimal.valueOf(1000).setScale(2, RoundingMode.FLOOR), bonus);
    }
}
