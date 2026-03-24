package com.example.sistema.automotivo.service;

import com.example.sistema.automotivo.dto.UsuarioRequestDTO;
import com.example.sistema.automotivo.dto.UsuarioResponseDTO;
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

    public UsuarioResponseDTO criarUsuario(UsuarioRequestDTO request) {
        if (repository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Este e-mail já está cadastrado.");
        }

        UsuarioModel usuario = new UsuarioModel();
        usuario.setNome(request.getNome());
        usuario.setEmail(request.getEmail());
        usuario.setSenha(request.getSenha());
        usuario.setPerfil(request.getPerfil());

        usuario = repository.save(usuario);
        return mapearParaResponseDTO(usuario);
    }

    public List<UsuarioResponseDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(this::mapearParaResponseDTO)
                .collect(Collectors.toList());
    }

    private UsuarioResponseDTO mapearParaResponseDTO(UsuarioModel usuario) {
        UsuarioResponseDTO response = new UsuarioResponseDTO();
        response.setId(usuario.getId());
        response.setNome(usuario.getNome());
        response.setEmail(usuario.getEmail());
        response.setPerfil(usuario.getPerfil());
        response.setDataCriacao(usuario.getDataCriacao().toLocalDate());
        return response;

    }

}

