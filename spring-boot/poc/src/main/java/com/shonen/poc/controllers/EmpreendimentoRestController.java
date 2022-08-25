package com.shonen.poc.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shonen.poc.models.Empreendimento;
import com.shonen.poc.resources.requests.EmpreendimentoRequest;
import com.shonen.poc.resources.responses.EmpreendimentoResponse;
import com.shonen.poc.services.EmpreendimentoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("empreendimentos")
public class EmpreendimentoRestController extends BaseRestController<Empreendimento, EmpreendimentoRequest, EmpreendimentoResponse> {
    private final EmpreendimentoService service;
    private final ObjectMapper objectMapper;

    public EmpreendimentoRestController(EmpreendimentoService service, ObjectMapper objectMapper) {
        super(service);
        this.service = service;
        this.objectMapper = objectMapper;
    }

    @GetMapping("contratos")
    public List<EmpreendimentoResponse> getAllContratos() {
        return service.getAllFetchContratos()
                .stream()
                .map(empreendimento -> objectMapper.convertValue(empreendimento, EmpreendimentoResponse.class))
                .toList();
    }
}
