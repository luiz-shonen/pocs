package com.shonen.poc.resources.responses;

import java.io.Serial;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// Lombok
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode(callSuper = false)
public class PesquisaCadastralDadosResponse implements Serializable {
    @Serial
    private static final long serialVersionUID = 4622288865073466801L;

    @JsonAlias("codigo_ficha")
    private Integer codigoFicha;

    @JsonAlias("data_conlcusao")
    private String dataConclusao;

    @JsonAlias("validade")
    private String validade;

    @JsonAlias("situacao_ficha")
    private SituacaoFichaResponse situacaoFicha;
}
