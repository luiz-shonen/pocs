package com.shonen.poc.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shonen.poc.resources.responses.ContratoResponse;
import com.shonen.poc.resources.responses.EmpreendimentoResponse;
import com.shonen.poc.services.ContratoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("contratos")
public class ContratoRestController {
    private final ObjectMapper objectMapper;
    private final ContratoService contratoService;

    public ContratoRestController(ContratoService contratoService, ObjectMapper objectMapper) {
        this.contratoService = contratoService;
        this.objectMapper = objectMapper;
    }

    @GetMapping
    public List<ContratoResponse> getAll() {
        return contratoService.getAll()
                .stream()
                .map(contrato -> objectMapper.convertValue(contrato, ContratoResponse.class))
                .toList();
    }

    @GetMapping("empreendimentos")
    public List<ContratoResponse> getAllEmpreendimentos() {
        return contratoService.getAllFetchEmpreendimentos()
                .stream()
                .map(contrato -> {
                    final var res = objectMapper.convertValue(contrato, ContratoResponse.class);
                    res.setEmpreendimento(objectMapper.convertValue(contrato.getEmpreendimento(), EmpreendimentoResponse.class));
                    return res;
                })
                .toList();
    }
}
