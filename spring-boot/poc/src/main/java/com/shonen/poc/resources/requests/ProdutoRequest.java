package com.shonen.poc.resources.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class ProdutoRequest extends BaseRequest {
    private String nome;

    private String observacao;

    private Long categoriaId;

    private CategoriaRequest categoria;
}
