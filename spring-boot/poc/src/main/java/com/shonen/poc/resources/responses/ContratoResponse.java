package com.shonen.poc.resources.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class ContratoResponse {
    private Long id;

    private String nome;

    private Long empreendimentoId;

    private EmpreendimentoResponse empreendimento;
}
