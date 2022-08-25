package com.shonen.poc.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shonen.poc.models.Produto;
import com.shonen.poc.resources.requests.ProdutoRequest;
import com.shonen.poc.resources.responses.ProdutoResponse;
import com.shonen.poc.resources.responses.Response;
import com.shonen.poc.services.ProdutoService;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProdutoRestController extends BaseRestController<Produto, ProdutoRequest, ProdutoResponse> {
    private final ProdutoService service;
    private final ObjectMapper objectMapper;

    public ProdutoRestController(ProdutoService service, ObjectMapper objectMapper) {
        super(service);
        this.service = service;
        this.objectMapper = objectMapper;
    }

    @Override
    public Response findAllPageSort(Integer page, Integer size, String sort, Sort.Direction direction) {
        return service.findAll();
    }

    @GetMapping("categorias")
    public List<ProdutoResponse> getAllCategorias() {
        return service.getAllFetchCategoria()
                .stream()
                .map(produto -> objectMapper.convertValue(produto, ProdutoResponse.class))
                .toList();
    }
}
