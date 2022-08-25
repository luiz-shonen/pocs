package com.shonen.poc.resources.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class EmpreendimentoRequest extends BaseRequest {
    private String nome;

    private List<ContratoRequest> contratos;
}
