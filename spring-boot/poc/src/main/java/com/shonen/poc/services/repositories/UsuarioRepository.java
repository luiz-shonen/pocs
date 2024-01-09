package com.shonen.poc.services.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shonen.poc.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
