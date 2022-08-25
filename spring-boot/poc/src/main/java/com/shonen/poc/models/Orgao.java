package com.shonen.poc.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@Entity
public class Orgao extends Base {
    private String nome;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Orgao orgao = (Orgao) o;
        return getId() != null && Objects.equals(getId(), orgao.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
