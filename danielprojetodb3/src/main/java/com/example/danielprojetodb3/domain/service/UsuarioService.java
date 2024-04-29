package com.example.danielprojetodb3.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.danielprojetodb3.domain.dto.usuario.UsuarioRequestDTO;
import com.example.danielprojetodb3.domain.dto.usuario.UsuarioResponseDTO;
import com.example.danielprojetodb3.domain.exception.ResourseNotFoundException;
import com.example.danielprojetodb3.domain.model.Usuario;
import com.example.danielprojetodb3.domain.repository.UsuarioRepository;



@Service
public class UsuarioService implements ICrudService 
    <UsuarioRequestDTO, UsuarioResponseDTO>{
        @Autowired
        private UsuarioRepository usuarioRepository;
        @Autowired
        private ModelMapper mapper;

    @Override
    public List<UsuarioResponseDTO> obterTodos() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(usuario ->
        mapper.map(usuario, UsuarioResponseDTO.class)).collect(Collectors.toList());
        
    }

    @Override
    public UsuarioResponseDTO obterPorId(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if(usuario.isEmpty()){
            throw new ResourseNotFoundException("não foi possível obter o usuário com o id");
        }
        return mapper.map(usuario, UsuarioResponseDTO.class);
    }

    @Override
    public UsuarioResponseDTO cadastrar(UsuarioRequestDTO dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cadastrar'");
    }

    @Override
    public UsuarioResponseDTO atualizar(Long id, UsuarioRequestDTO dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
    }

    @Override
    public void deletar(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletar'");
    }
        
    }
   
