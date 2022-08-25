package com.shonen.poc.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@Entity
public class Empreendimento extends Base {
    private String nome;

    @Column(name = "orgao_id", insertable = false, updatable = false)
    private Long orgaoId;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Orgao orgao;

    @OneToMany(mappedBy = "empreendimento", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Contrato> contratos;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Empreendimento that = (Empreendimento) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
