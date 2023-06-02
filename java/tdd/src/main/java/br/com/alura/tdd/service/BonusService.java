package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.utils.Utils;

import java.math.BigDecimal;

public class BonusService {

    public BigDecimal calcularBonus(Funcionario funcionario) {
        var valor = funcionario.getSalario().multiply(BigDecimal.valueOf(0.1));

        if (valor.compareTo(Utils.novoBigDecimalEscalaDuasCasasDecimais(1000)) > 0) {
            throw new IllegalArgumentException("Funcionário com salário maior do que R$10.000,00 não pode receber bônus.");
        }

        return Utils.escalaDuasCasasDecimais(valor);
    }

}
