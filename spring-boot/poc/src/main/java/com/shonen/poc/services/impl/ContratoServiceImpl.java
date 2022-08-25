package com.shonen.poc.services.impl;

import com.shonen.poc.models.Contrato;
import com.shonen.poc.services.ContratoService;
import com.shonen.poc.services.EmpreendimentoService;
import com.shonen.poc.services.repositories.ContratoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContratoServiceImpl implements ContratoService {
    private final ContratoRepository contratoRepository;
    private final EmpreendimentoService empreendimentoService;

    public ContratoServiceImpl(ContratoRepository contratoRepository, EmpreendimentoService empreendimentoService) {
        this.contratoRepository = contratoRepository;
        this.empreendimentoService = empreendimentoService;
    }

    @Override
    public List<Contrato> getAll() {
        return contratoRepository.findAll();
    }

    @Override
    public List<Contrato> getAllFetchEmpreendimentos() {
        return contratoRepository.getContratosFetchEmpreendimentos();
    }
}
