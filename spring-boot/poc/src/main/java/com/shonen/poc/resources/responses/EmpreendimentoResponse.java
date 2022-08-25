package com.shonen.poc.resources.responses;

import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class EmpreendimentoResponse extends BaseResponse {
    private String nome;

    private List<ContratoResponse> contratos;
}
