package com.shonen.poc.services;

import com.shonen.poc.models.Produto;

import java.util.List;

public interface ProdutoService {
    List<Produto> getAll();

    List<Produto> getAllFetchCategoria();
}
