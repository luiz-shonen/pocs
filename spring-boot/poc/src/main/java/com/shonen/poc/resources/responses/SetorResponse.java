package com.shonen.poc.resources.responses;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class SetorResponse extends BaseResponse {
    private String nome;
}
