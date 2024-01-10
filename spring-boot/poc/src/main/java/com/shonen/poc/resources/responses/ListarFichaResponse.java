package com.shonen.poc.resources.responses;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

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
public class ListarFichaResponse implements Serializable {
    @Serial
    private static final long serialVersionUID = -5052995275376595394L;

    @JsonProperty("quantidade_registros")
    private Integer quantidadeRegistros;

    @JsonAlias("dados_pesquisa_cadastral")
    @Builder.Default
    private Set<PesquisaCadastralDadosResponse> dadosPesquisaCadastral = new HashSet<>();
}