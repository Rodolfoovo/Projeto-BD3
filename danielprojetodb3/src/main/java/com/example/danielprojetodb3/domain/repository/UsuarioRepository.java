package com.example.danielprojetodb3.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.danielprojetodb3.domain.model.Usuario;

public interface UsuarioRepository extends
        JpaRepository<Usuario, Long> {


    Optional<Usuario> findByEmail(String email);
}
