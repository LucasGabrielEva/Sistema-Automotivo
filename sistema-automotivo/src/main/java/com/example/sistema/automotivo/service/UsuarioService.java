package com.example.sistema.automotivo.service;

import com.example.sistema.automotivo.dto.UsuarioRequestDTO;
import com.example.sistema.automotivo.dto.UsuarioResponseDTO;
import com.example.sistema.automotivo.mapper.UsuarioMapper;
import com.example.sistema.automotivo.model.UsuarioModel;
import com.example.sistema.automotivo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private UsuarioMapper usuarioMapper;


    public UsuarioModel criarUsuario(UsuarioRequestDTO request) {
        if (repository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Este e-mail já está cadastrado.");
        }

        UsuarioModel usuario = new UsuarioModel();
        usuario.setNome(request.getNome());
        usuario.setEmail(request.getEmail());
        usuario.setSenha(request.getSenha());
        usuario.setPerfil(request.getPerfil());

        return repository.save(usuario);

    }

    public List<UsuarioResponseDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(usuarioMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    public UsuarioModel buscarUsuarioPorId (Long id){
        UsuarioModel usuario = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado!"));
        return usuario;
    }

}

