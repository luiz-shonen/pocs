import br.com.alura.tdd.Calculadora;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculadoraTest {

    @Test
    void deveriaSomarDoisNumerosPositivos() {
        final var calculadora = new Calculadora();
        int soma = calculadora.somar(3, 7);

        Assertions.assertEquals(10, soma);
    }

}
