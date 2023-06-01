package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.utils.Utils;

public class ReajusteService {
    public void concederReajuste(Funcionario funcionario, Desempenho desempenho) {
        final var percentual = desempenho.percentualReajuste();
        final var reajuste = funcionario.getSalario().multiply(percentual);
        funcionario.reajustarSalario(Utils.escalaDuasCasasDecimais(reajuste));
    }
}
