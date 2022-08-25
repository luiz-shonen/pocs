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
public class Setor extends Base {
    private String nome;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Setor setor = (Setor) o;
        return getId() != null && Objects.equals(getId(), setor.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
