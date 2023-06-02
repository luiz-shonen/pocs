package service;

import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.BonusService;
import br.com.alura.tdd.utils.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class BonusServiceTest {
    @Test
    void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
        final var service = new BonusService();
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> service.calcularBonus(new Funcionario("Jéssica", LocalDate.now(), Utils.novoBigDecimalEscalaDuasCasasDecimais(25000))));

        /*try {
            service.calcularBonus(new Funcionario("Jéssica", LocalDate.now(), Utils.novoBigDecimalEscalaDuasCasasDecimais(25000)));
            Assertions.fail("Não deu a Exception.");
        } catch (Exception e) {
            Assertions.assertEquals("Funcionário com salário maior do que R$10.000,00 não pode receber bônus.", e.getMessage());
        }*/
    }

    @Test
    void bonusDeveriaSer10PorCentoDoSalario() {
        final var service = new BonusService();
        final var bonus = service.calcularBonus(new Funcionario("Jéssica", LocalDate.now(), Utils.novoBigDecimalEscalaDuasCasasDecimais(2500)));

        Assertions.assertEquals(Utils.novoBigDecimalEscalaDuasCasasDecimais(250), bonus);
    }

    @Test
    void bonusDeveriaSer10PorCentoParaSalarioDeExatamente10000() {
        final var service = new BonusService();
        final var bonus = service.calcularBonus(new Funcionario("Jéssica", LocalDate.now(), Utils.novoBigDecimalEscalaDuasCasasDecimais(10000)));

        Assertions.assertEquals(Utils.novoBigDecimalEscalaDuasCasasDecimais(1000), bonus);
    }
}
