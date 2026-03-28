package com.example.sistema.automotivo.controller;

import com.example.sistema.automotivo.dto.OrdemServicoRequestDTO;
import com.example.sistema.automotivo.dto.OrdemServicoResponseDTO;
import com.example.sistema.automotivo.model.StatusOrdem;
import com.example.sistema.automotivo.service.OrdemServicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/OS")

public class OrdemServiceController {
    @Autowired
    private OrdemServicoService service;


    @PostMapping
    public ResponseEntity<Map<String, Object>> criarOrdem(@Valid  @RequestBody OrdemServicoRequestDTO request) {
      service.criarOrdemServico(request);
      return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("message", "Ordem Serviço criado", "success", true));
    }

    @GetMapping
    public ResponseEntity<List<OrdemServicoResponseDTO>> listarTodas() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Map<String, Object>> atualizarStatus(@PathVariable Long id, @RequestBody StatusOrdem status) {
        service.atualizarOrdemServico(id, status);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("message", "Ordem Service atualizada", "success", true));
    }


}
