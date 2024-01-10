package com.shonen.poc.controllers;

import com.shonen.poc.models.Categoria;
import com.shonen.poc.resources.requests.CategoriaRequest;
import com.shonen.poc.resources.responses.CategoriaResponse;
import com.shonen.poc.services.CategoriaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("categorias")
public class CategoriaRestController extends BaseRestController<Categoria, CategoriaRequest, CategoriaResponse> {
    private final CategoriaService service;

    public CategoriaRestController(CategoriaService service) {
        super(service);
        this.service = service;
    }
}
