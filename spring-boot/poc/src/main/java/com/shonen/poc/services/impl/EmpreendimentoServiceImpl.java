package com.shonen.poc.services.impl;

import com.shonen.poc.models.Empreendimento;
import com.shonen.poc.resources.requests.EmpreendimentoRequest;
import com.shonen.poc.resources.responses.EmpreendimentoResponse;
import com.shonen.poc.services.EmpreendimentoService;
import com.shonen.poc.services.repositories.EmpreendimentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpreendimentoServiceImpl extends BaseServiceImpl<Empreendimento, EmpreendimentoRequest, EmpreendimentoResponse> implements EmpreendimentoService {
    private final EmpreendimentoRepository repository;

    public EmpreendimentoServiceImpl(EmpreendimentoRepository repository) {
        super(Empreendimento.class, EmpreendimentoRequest.class, EmpreendimentoResponse.class, repository);
        this.repository = repository;
    }

    @Override
    public List<Empreendimento> getAllFetchContratos() {
        return repository.getEmpreendimentosFetchContratos();
    }
}
