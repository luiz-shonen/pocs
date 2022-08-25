package com.shonen.poc.services;

import com.shonen.poc.models.Contrato;

import java.util.List;

public interface ContratoService {
    List<Contrato> getAll();

    List<Contrato> getAllFetchEmpreendimentos();
}
