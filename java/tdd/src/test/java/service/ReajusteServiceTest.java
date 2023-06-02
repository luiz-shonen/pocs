package service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.ReajusteService;
import br.com.alura.tdd.utils.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

class ReajusteServiceTest {

    private ReajusteService service;
    private Funcionario funcionario;

    @BeforeEach
    void init() {
        service = new ReajusteService();
        funcionario = new Funcionario("Jéssica", LocalDate.now(), BigDecimal.valueOf(1000));
    }

    @Test
    void reajusteDeveriaSerDeTresPorCentoQuandoDesempenhoForADesejar() {
        service.concederReajuste(funcionario, Desempenho.A_DESEJAR);

        Assertions.assertEquals(Utils.escalaDuasCasasDecimais(BigDecimal.valueOf(1030)), funcionario.getSalario());
    }

    @Test
    void reajusteDeveriaSerDeQuinzePorCentoQuandoDesempenhoForBom() {
        service.concederReajuste(funcionario, Desempenho.BOM);

        Assertions.assertEquals(Utils.escalaDuasCasasDecimais(BigDecimal.valueOf(1150)), funcionario.getSalario());
    }

    @Test
    void reajusteDeveriaSerDeQuinzePorCentoQuandoDesempenhoForOtimo() {
        service.concederReajuste(funcionario, Desempenho.OTIMO);

        Assertions.assertEquals(Utils.escalaDuasCasasDecimais(BigDecimal.valueOf(1200)), funcionario.getSalario());
    }
}
