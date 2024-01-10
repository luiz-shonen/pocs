package com.shonen.poc.resources.responses;

import java.io.Serial;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
public class SituacaoFichaResponse implements Serializable {
    @Serial
    private static final long serialVersionUID = -1675588144476629454L;

    @JsonAlias("codigo")
    private Integer codigo;

    @JsonAlias("descricao")
    private String descricao;
}
