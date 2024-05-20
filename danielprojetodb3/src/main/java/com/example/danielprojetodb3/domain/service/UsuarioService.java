package com.example.danielprojetodb3.domain.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.danielprojetodb3.domain.dto.usuario.UsuarioRequestDTO;
import com.example.danielprojetodb3.domain.dto.usuario.UsuarioResponseDTO;
import com.example.danielprojetodb3.domain.exception.BadRequestException;
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
        @Autowired
        private BCryptPasswordEncoder bCryptPasswordEncoder;

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
        return mapper.map(usuario.get(), UsuarioResponseDTO.class);
    }

    @Override
    public UsuarioResponseDTO cadastrar(UsuarioRequestDTO dto) {
        if(dto.getEmail() == null || dto.getSenha() == null){
            throw new BadRequestException("Email e Senhas são Obrigatórios");
        }
        Optional<Usuario> optUsuario = usuarioRepository.findByEmail(dto.getEmail());
        if(optUsuario.isPresent()){
            throw new BadRequestException("Usuário existente com este email.");
        }
        Usuario usuario = mapper.map(dto, Usuario.class);
        usuario.setDataCadastro(new Date());
        //criptografar senha
        String senha = bCryptPasswordEncoder.encode(usuario.getSenha());
        usuario.setSenha(senha);
        usuario = usuarioRepository.save(usuario);
        return mapper.map(usuario,UsuarioResponseDTO.class);
    }

    @Override
    public UsuarioResponseDTO atualizar(Long id, UsuarioRequestDTO dto) {
        UsuarioResponseDTO usuarioBanco = obterPorId(id);
        if(dto.getEmail() == null || dto.getSenha() == null){
            throw new BadRequestException("Email e Senhas são Obrigatórios");
        }
        Usuario usuario = mapper.map(dto, Usuario.class);
        //criptografar senha
        usuario.setSenha(dto.getSenha());
        usuario.setId(id);
        usuario.setDataCadastro(usuarioBanco.getDataCadastro());
        usuario.setDataInativacao(usuarioBanco.getDataInativacao());
        usuario = usuarioRepository.save(usuario);
        return mapper.map(usuario,UsuarioResponseDTO.class);
    }

    @Override
    public void deletar(Long id) {
        Optional<Usuario> optUsuario = usuarioRepository.findById(id);
        if(optUsuario.isEmpty()){
            throw new ResourseNotFoundException
            ("não foi possível obter o usuário com o id");
        }
        Usuario usuario = optUsuario.get();
        usuario.setDataInativacao(new Date());
        usuarioRepository.save(usuario);
    }   
}
   
