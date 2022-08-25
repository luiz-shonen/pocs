package com.shonen.poc.services;

import com.shonen.poc.models.Empreendimento;
import com.shonen.poc.resources.requests.EmpreendimentoRequest;
import com.shonen.poc.resources.responses.EmpreendimentoResponse;

import java.util.List;

public interface EmpreendimentoService extends BaseService<Empreendimento, EmpreendimentoRequest, EmpreendimentoResponse> {
    List<Empreendimento> getAllFetchContratos();
}
