package com.shonen.poc.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Empreendimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "empreendimento", fetch = FetchType.LAZY)
    private List<Contrato> contratos;
}
