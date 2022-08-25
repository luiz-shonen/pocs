package com.shonen.poc.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shonen.poc.resources.responses.EmpreendimentoResponse;
import com.shonen.poc.services.EmpreendimentoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("empreendimentos")
public class EmpreendimentoRestController {
    private final EmpreendimentoService empreendimentoService;
    private final ObjectMapper objectMapper;

    public EmpreendimentoRestController(EmpreendimentoService empreendimentoService, ObjectMapper objectMapper) {
        this.empreendimentoService = empreendimentoService;
        this.objectMapper = objectMapper;
    }

    @GetMapping
    public List<EmpreendimentoResponse> getAll() {
        return empreendimentoService.getAll()
                .stream()
                .map(empreendimento -> objectMapper.convertValue(empreendimento, EmpreendimentoResponse.class))
                .toList();
    }

    @GetMapping("contratos")
    public List<EmpreendimentoResponse> getAllContratos() {
        return empreendimentoService.getAllFetchContratos()
                .stream()
                .map(empreendimento -> objectMapper.convertValue(empreendimento, EmpreendimentoResponse.class))
                .toList();
    }
}
