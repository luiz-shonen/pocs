package com.shonen.poc.services;

import com.shonen.poc.models.Produto;
import com.shonen.poc.resources.requests.ProdutoRequest;
import com.shonen.poc.resources.responses.ProdutoResponse;

import java.util.List;

public interface ProdutoService extends BaseService<Produto, ProdutoRequest, ProdutoResponse> {
    List<Produto> getAllFetchCategoria();
}
