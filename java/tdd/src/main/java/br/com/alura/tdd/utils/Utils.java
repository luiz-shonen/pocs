package br.com.alura.tdd.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class Utils {
    private Utils() {
    }

    public static BigDecimal novoBigDecimalEscalaDuasCasasDecimais(int value) {
        return escalaDuasCasasDecimais(BigDecimal.valueOf(value));
    }

    public static BigDecimal escalaDuasCasasDecimais(BigDecimal value) {
        return value.setScale(2, RoundingMode.FLOOR);
    }
}
