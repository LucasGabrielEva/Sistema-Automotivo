package com.example.sistema.automotivo.controller;

import com.example.sistema.automotivo.dto.UsuarioRequestDTO;
import com.example.sistema.automotivo.dto.UsuarioResponseDTO;
import com.example.sistema.automotivo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {
    @Autowired
    private UsuarioService service;

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> registrarUsuario(@RequestBody UsuarioRequestDTO request) {
        return ResponseEntity.ok(service.criarUsuario(request));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }
}
