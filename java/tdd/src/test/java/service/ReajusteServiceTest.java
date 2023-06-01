package service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.ReajusteService;
import br.com.alura.tdd.utils.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

class ReajusteServiceTest {
    @Test
    void reajusteDeveriaSerDeTresPorCentoQuandoDesempenhoForADesejar() {
        final var service = new ReajusteService();
        final var funcionario = new Funcionario("Jéssica", LocalDate.now(), BigDecimal.valueOf(1000));

        service.concederReajuste(funcionario, Desempenho.A_DESEJAR);

        Assertions.assertEquals(Utils.escalaDuasCasasDecimais(BigDecimal.valueOf(1030)), funcionario.getSalario());
    }

    @Test
    void reajusteDeveriaSerDeQuinzePorCentoQuandoDesempenhoForBom() {
        final var service = new ReajusteService();
        final var funcionario = new Funcionario("Jéssica", LocalDate.now(), BigDecimal.valueOf(1000));

        service.concederReajuste(funcionario, Desempenho.BOM);

        Assertions.assertEquals(Utils.escalaDuasCasasDecimais(BigDecimal.valueOf(1150)), funcionario.getSalario());
    }

    @Test
    void reajusteDeveriaSerDeQuinzePorCentoQuandoDesempenhoForOtimo() {
        final var service = new ReajusteService();
        final var funcionario = new Funcionario("Jéssica", LocalDate.now(), BigDecimal.valueOf(1000));

        service.concederReajuste(funcionario, Desempenho.OTIMO);

        Assertions.assertEquals(Utils.escalaDuasCasasDecimais(BigDecimal.valueOf(1200)), funcionario.getSalario());
    }
}
