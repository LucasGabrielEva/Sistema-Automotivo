package com.example.sistema.automotivo.controller;

import com.example.sistema.automotivo.dto.OrdemServicoRequestDTO;
import com.example.sistema.automotivo.dto.OrdemServicoResponseDTO;
import com.example.sistema.automotivo.model.StatusOrdem;
import com.example.sistema.automotivo.service.OrdemServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/OS")
@CrossOrigin(origins = "*")
public class OrdemServiceController {
    @Autowired
    private OrdemServicoService service;

    @PostMapping
    public ResponseEntity<OrdemServicoResponseDTO> criarOS(@RequestBody OrdemServicoRequestDTO request) {
        return ResponseEntity.ok(service.criarOrdem(request));
    }

    @GetMapping
    public ResponseEntity<List<OrdemServicoResponseDTO>> listarTodas() {
        return ResponseEntity.ok(service.listarTodas());
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<OrdemServicoResponseDTO> alterarStatus(
            @PathVariable Long id,
            @RequestParam StatusOrdem status) {
        return ResponseEntity.ok(service.atualizarStatus(id, status));
    }
}
