package com.shonen.poc.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shonen.poc.models.Contrato;
import com.shonen.poc.resources.requests.ContratoRequest;
import com.shonen.poc.resources.responses.ContratoResponse;
import com.shonen.poc.resources.responses.EmpreendimentoResponse;
import com.shonen.poc.services.ContratoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("contratos")
public class ContratoRestController extends BaseRestController<Contrato, ContratoRequest, ContratoResponse> {
    private final ObjectMapper objectMapper;
    private final ContratoService service;

    public ContratoRestController(ContratoService service, ObjectMapper objectMapper) {
        super(service);
        this.service = service;
        this.objectMapper = objectMapper;
    }

    @GetMapping("empreendimentos")
    public List<ContratoResponse> getAllEmpreendimentos() {
        return service.getAllFetchEmpreendimentos()
                .stream()
                .map(contrato -> {
                    final var res = objectMapper.convertValue(contrato, ContratoResponse.class);
                    res.setEmpreendimento(objectMapper.convertValue(contrato.getEmpreendimento(), EmpreendimentoResponse.class));
                    return res;
                })
                .toList();
    }
}
