package com.shonen.poc.services.repositories;

import com.shonen.poc.models.Empreendimento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpreendimentoRepository extends BaseRepository<Empreendimento> {
    @Query("""
            SELECT e
            FROM Empreendimento e
            JOIN FETCH e.contratos
            """)
    List<Empreendimento> getEmpreendimentosFetchContratos();
}
