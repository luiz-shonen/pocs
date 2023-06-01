package br.com.alura.tdd.modelo;

import java.math.BigDecimal;

public enum Desempenho {
    A_DESEJAR {
        @Override
        public BigDecimal percentualReajuste() {
            return BigDecimal.valueOf(0.03);
        }
    },
    BOM {
        @Override
        public BigDecimal percentualReajuste() {
            return BigDecimal.valueOf(0.15);
        }
    },
    OTIMO {
        @Override
        public BigDecimal percentualReajuste() {
            return BigDecimal.valueOf(0.2);
        }
    };

    public abstract BigDecimal percentualReajuste();
}
