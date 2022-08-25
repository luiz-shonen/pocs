package com.shonen.poc.services.repositories;

import com.shonen.poc.models.Produto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends BaseRepository<Produto> {
    @Query("""
            SELECT p
            FROM Produto p
            JOIN FETCH p.categoria
            """)
    List<Produto> getProdutosFetchCategoria();
}
