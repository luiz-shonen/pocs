package com.shonen.poc.services.impl;

import com.shonen.poc.models.Categoria;
import com.shonen.poc.resources.requests.CategoriaRequest;
import com.shonen.poc.resources.responses.CategoriaResponse;
import com.shonen.poc.services.CategoriaService;
import com.shonen.poc.services.repositories.CategoriaRepository;
import org.springframework.stereotype.Service;


@Service
public class CategoriaServiceImpl extends BaseServiceImpl<Categoria, CategoriaRequest, CategoriaResponse>
        implements CategoriaService {
    private final CategoriaRepository repository;

    public CategoriaServiceImpl(CategoriaRepository repository) {
        super(Categoria.class, CategoriaRequest.class, CategoriaResponse.class, repository);
        this.repository = repository;
    }
}
