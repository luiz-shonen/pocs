package com.shonen.poc.models;

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
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String observacao;

    @Column(name = "categoria_id", insertable = false, updatable = false)
    private Long categoriaId;

    @ManyToOne(fetch = FetchType.LAZY)
    private Categoria categoria;
}
