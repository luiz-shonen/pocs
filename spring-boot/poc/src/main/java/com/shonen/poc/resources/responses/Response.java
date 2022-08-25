package com.shonen.poc.resources.responses;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.domain.Page;

@Builder
@Getter
@Setter
@ToString
public class Response {
    private Object data;
    private Page<?> pagination;
    private Long totalElements;
}
