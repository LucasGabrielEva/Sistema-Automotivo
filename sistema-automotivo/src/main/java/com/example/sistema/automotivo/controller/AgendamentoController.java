package com.example.sistema.automotivo.controller;

import com.example.sistema.automotivo.dto.AgendamentoRequestDTO;
import com.example.sistema.automotivo.dto.AgendamentoResponseDTO;
import com.example.sistema.automotivo.model.StatusAgendamento;
import com.example.sistema.automotivo.service.AgendamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/agendamentos")

public class AgendamentoController {

    @Autowired
    private AgendamentoService service;

    @PostMapping
    public ResponseEntity<Map<String, Object>> criarAgendamento(@Valid @RequestBody AgendamentoRequestDTO request) {
       service.criarAgendamento(request);
       return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("message", "Agendamento criado", "success", true));
    }

    @GetMapping
    public ResponseEntity<List<AgendamentoResponseDTO>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Map<String, Object>> alterarStatus(@PathVariable Long id, @RequestParam StatusAgendamento status) {
        service.atualizarStatus(id, status);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("message", "Agendamento atualizado", "success", true));
    }
}
