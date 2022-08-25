package com.shonen.poc.services.impl;

import com.shonen.poc.models.Empreendimento;
import com.shonen.poc.services.EmpreendimentoService;
import com.shonen.poc.services.repositories.EmpreendimentoRepository;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpreendimentoServiceImpl implements EmpreendimentoService {
    private final EmpreendimentoRepository empreendimentoRepository;

    public EmpreendimentoServiceImpl(EmpreendimentoRepository empreendimentoRepository) {
        this.empreendimentoRepository = empreendimentoRepository;
    }

    @Override
    public List<Empreendimento> getAll() {
        return empreendimentoRepository.findAll();
    }

    @Override
    public List<Empreendimento> getAllFetchContratos() {
        return empreendimentoRepository.getEmpreendimentosFetchContratos();
    }

    @Override
    public Empreendimento buscarPorId(@NonNull Long id) {
        return empreendimentoRepository.findById(id).orElse(null);
    }
}
