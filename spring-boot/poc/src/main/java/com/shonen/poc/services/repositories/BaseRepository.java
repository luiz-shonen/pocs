package com.shonen.poc.services.repositories;

import com.shonen.poc.models.Base;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseRepository<T extends Base> extends JpaRepository<T, Long>, JpaSpecificationExecutor<T> {
}
