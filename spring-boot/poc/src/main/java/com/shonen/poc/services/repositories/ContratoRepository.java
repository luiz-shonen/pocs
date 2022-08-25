package com.shonen.poc.services.repositories;

import com.shonen.poc.models.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Long>, JpaSpecificationExecutor<Contrato> {
    @Query("""
            SELECT c
            FROM Contrato c
            JOIN FETCH c.empreendimento
            """)
    List<Contrato> getContratosFetchEmpreendimentos();
}
