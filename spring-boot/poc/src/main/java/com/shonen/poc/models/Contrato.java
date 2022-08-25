package com.shonen.poc.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Contrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(name = "empreendimento_id", insertable = false, updatable = false)
    private Long empreendimentoId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Empreendimento empreendimento;
}
