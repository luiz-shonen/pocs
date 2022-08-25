package com.shonen.poc.resources.responses;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class ContratoResponse extends BaseResponse {
    private String nome;

    private Long empreendimentoId;

    private EmpreendimentoResponse empreendimento;

    private Long empresaId;

    private EmpresaResponse empresa;
}
