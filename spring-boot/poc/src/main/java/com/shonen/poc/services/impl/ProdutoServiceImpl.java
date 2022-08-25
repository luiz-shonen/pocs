package com.shonen.poc.services.impl;

import com.shonen.poc.models.Produto;
import com.shonen.poc.resources.requests.ProdutoRequest;
import com.shonen.poc.resources.responses.ProdutoResponse;
import com.shonen.poc.services.ProdutoService;
import com.shonen.poc.services.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl extends BaseServiceImpl<Produto, ProdutoRequest, ProdutoResponse> implements ProdutoService {
    private final ProdutoRepository repository;

    public ProdutoServiceImpl(ProdutoRepository repository) {
        super(Produto.class, ProdutoRequest.class, ProdutoResponse.class, repository);
        this.repository = repository;
    }

    @Override
    public List<Produto> getAllFetchCategoria() {
        return repository.getProdutosFetchCategoria();
    }
}
