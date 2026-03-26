package com.example.sistema.automotivo.controller;

import com.example.sistema.automotivo.dto.UsuarioRequestDTO;
import com.example.sistema.automotivo.dto.UsuarioResponseDTO;
import com.example.sistema.automotivo.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {
    @Autowired
    private UsuarioService service;

    @PostMapping
    public ResponseEntity<Map<String, Object>> registrarUsuario(@Valid  @RequestBody UsuarioRequestDTO request) {
        service.criarUsuario(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("message", "Usuario criado", "success",  true));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }
}
