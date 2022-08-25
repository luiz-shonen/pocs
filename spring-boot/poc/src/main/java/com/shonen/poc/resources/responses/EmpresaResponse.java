package com.shonen.poc.resources.responses;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class EmpresaResponse extends BaseResponse {
    private String nome;

    private Long setorId;

    private SetorResponse setor;
}
