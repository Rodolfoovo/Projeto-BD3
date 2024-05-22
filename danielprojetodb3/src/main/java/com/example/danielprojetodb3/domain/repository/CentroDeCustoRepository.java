package com.example.danielprojetodb3.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.danielprojetodb3.domain.model.CentroDeCusto;
import com.example.danielprojetodb3.domain.model.Usuario;

import java.util.List;


public interface CentroDeCustoRepository extends JpaRepository<CentroDeCusto, Long>{
    List<CentroDeCusto> findByUsuario(Usuario usuario);
    
}
