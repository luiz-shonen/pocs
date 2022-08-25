package com.shonen.poc.resources.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class ContratoRequest extends BaseRequest {
    private String nome;

    private Long empreendimentoId;

    private EmpreendimentoRequest empreendimento;

    private Long empresaId;

    private EmpresaRequest empresa;
}
