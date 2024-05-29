package com.example.danielprojetodb3.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.danielprojetodb3.domain.model.Titulo;
import com.example.danielprojetodb3.domain.model.Usuario;

import java.util.List;


public interface TituloRepository extends JpaRepository<Titulo,Long>{
    List<Titulo> findByUsuario(Usuario usuario);
}
