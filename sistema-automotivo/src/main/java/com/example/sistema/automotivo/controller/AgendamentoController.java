package com.example.sistema.automotivo.controller;

import com.example.sistema.automotivo.dto.AgendamentoRequestDTO;
import com.example.sistema.automotivo.dto.AgendamentoResponseDTO;
import com.example.sistema.automotivo.model.StatusAgendamento;
import com.example.sistema.automotivo.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
@CrossOrigin(origins = "*")
public class AgendamentoController {

    @Autowired
    private AgendamentoService service;

    @PostMapping
    public ResponseEntity<AgendamentoResponseDTO> criarAgendamento(@RequestBody AgendamentoRequestDTO request) {
        return ResponseEntity.ok(service.criarAgendamento(request));
    }

    @GetMapping
    public ResponseEntity<List<AgendamentoResponseDTO>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<AgendamentoResponseDTO> alterarStatus(
            @PathVariable Long id,
            @RequestParam StatusAgendamento status) {
        return ResponseEntity.ok(service.atualizarStatus(id, status));
    }
}
