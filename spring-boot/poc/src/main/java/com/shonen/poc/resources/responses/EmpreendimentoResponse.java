package com.shonen.poc.resources.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class EmpreendimentoResponse {
    private Long id;

    private String nome;

    private List<ContratoResponse> contratos;
}
