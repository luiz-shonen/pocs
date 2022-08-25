package com.shonen.poc.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shonen.poc.resources.responses.ProdutoResponse;
import com.shonen.poc.services.ProdutoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProdutoRestController {
    private final ProdutoService produtoService;
    private final ObjectMapper objectMapper;

    public ProdutoRestController(ProdutoService produtoService, ObjectMapper objectMapper) {
        this.produtoService = produtoService;
        this.objectMapper = objectMapper;
    }

    @GetMapping
    public List<ProdutoResponse> getAll() {
        return produtoService.getAll()
                .stream()
                .map(produto -> objectMapper.convertValue(produto, ProdutoResponse.class))
                .toList();
    }

    @GetMapping("categorias")
    public List<ProdutoResponse> getAllCategorias() {
        return produtoService.getAllFetchCategoria()
                .stream()
                .map(produto -> objectMapper.convertValue(produto, ProdutoResponse.class))
                .toList();
    }
}
