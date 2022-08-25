package com.shonen.poc.services;

import com.shonen.poc.models.Contrato;
import com.shonen.poc.resources.requests.ContratoRequest;
import com.shonen.poc.resources.responses.ContratoResponse;

import java.util.List;

public interface ContratoService extends BaseService<Contrato, ContratoRequest, ContratoResponse> {
    List<Contrato> getAllFetchEmpreendimentos();
}
