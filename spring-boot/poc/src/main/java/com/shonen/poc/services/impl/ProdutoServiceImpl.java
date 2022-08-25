package com.shonen.poc.services.impl;

import com.shonen.poc.models.Produto;
import com.shonen.poc.services.ProdutoService;
import com.shonen.poc.services.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {
    private final ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public List<Produto> getAll() {
        return produtoRepository.findAll();
    }

    @Override
    public List<Produto> getAllFetchCategoria() {
        return produtoRepository.getProdutosFetchCategoria();
    }
}
