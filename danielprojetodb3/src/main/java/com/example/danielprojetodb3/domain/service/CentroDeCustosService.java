package com.example.danielprojetodb3.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.danielprojetodb3.domain.dto.centrodecusto.CentroDeCustoRequestDTO;
import com.example.danielprojetodb3.domain.dto.centrodecusto.CentroDeCustoResponseDTO;

@Service
public class CentroDeCustosService 
implements ICrudService<CentroDeCustoRequestDTO, CentroDeCustoResponseDTO>{

    @Override
    public List<CentroDeCustoResponseDTO> obterTodos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obterTodos'");
    }

    @Override
    public CentroDeCustoResponseDTO obterPorId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obterPorId'");
    }

    @Override
    public CentroDeCustoResponseDTO cadastrar(CentroDeCustoRequestDTO dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cadastrar'");
    }

    @Override
    public CentroDeCustoResponseDTO atualizar(Long id, CentroDeCustoRequestDTO dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
    }

    @Override
    public void deletar(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletar'");
    }
    
}
