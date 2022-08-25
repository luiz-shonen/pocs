package com.shonen.poc.services.impl;

import com.shonen.poc.models.Contrato;
import com.shonen.poc.resources.requests.ContratoRequest;
import com.shonen.poc.resources.responses.ContratoResponse;
import com.shonen.poc.services.ContratoService;
import com.shonen.poc.services.repositories.ContratoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContratoServiceImpl extends BaseServiceImpl<Contrato, ContratoRequest, ContratoResponse> implements ContratoService {
    private final ContratoRepository repository;

    public ContratoServiceImpl(ContratoRepository repository) {
        super(Contrato.class, ContratoRequest.class, ContratoResponse.class, repository);
        this.repository = repository;
    }

    @Override
    public List<Contrato> getAllFetchEmpreendimentos() {
        return repository.getContratosFetchEmpreendimentos();
    }
}
