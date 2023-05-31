import br.com.alura.tdd.Calculadora;

/**
 * Abordagem incorreta de testes, utilizada apenas para exemplificação
 */
public class CalculadoraTestes {
    public static void main(String[] args) {
        final var calculadora = new Calculadora();
        int soma = calculadora.somar(3, 7);
        System.out.println(soma);

        soma = calculadora.somar(3, 0);
        System.out.println(soma);

        soma = calculadora.somar(0, 0);
        System.out.println(soma);

        soma = calculadora.somar(3, -1);
        System.out.println(soma);
    }
}
