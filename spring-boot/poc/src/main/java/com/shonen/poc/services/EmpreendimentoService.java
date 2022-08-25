package com.shonen.poc.services;

import com.shonen.poc.models.Empreendimento;
import lombok.NonNull;

import java.util.List;

public interface EmpreendimentoService {
    List<Empreendimento> getAll();

    List<Empreendimento> getAllFetchContratos();

    Empreendimento buscarPorId(@NonNull Long id);
}
