package com.shonen.poc.services.repositories;

import com.shonen.poc.models.Empreendimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpreendimentoRepository extends JpaRepository<Empreendimento, Long>, JpaSpecificationExecutor<Empreendimento> {
    @Query("""
            SELECT e
            FROM Empreendimento e
            JOIN FETCH e.contratos
            """)
    List<Empreendimento> getEmpreendimentosFetchContratos();
}
