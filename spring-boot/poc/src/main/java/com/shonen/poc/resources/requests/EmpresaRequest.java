package com.shonen.poc.resources.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmpresaRequest extends BaseRequest {
    private String nome;

    private Long setorId;

    private SetorRequest setor;
}
