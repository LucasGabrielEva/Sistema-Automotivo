package com.example.sistema.automotivo.controller;

import com.example.sistema.automotivo.dto.OficinaParceiroRequestDTO;
import com.example.sistema.automotivo.dto.OficinaParceiroResponseDTO;
import com.example.sistema.automotivo.service.OficinaParceiroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(name = "/oficinas")
@CrossOrigin(origins = "*")
public class OficinaParceiraController {
    @Autowired
    private OficinaParceiroService service;

    @PostMapping
    public ResponseEntity<Map<String, Object>> cadastrarOficina(@Valid @RequestBody OficinaParceiroRequestDTO request) {
        service.cadastrarOficina(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("message", "Oficina cadastrada", "success", true));
    }

    @GetMapping
    public ResponseEntity<List<OficinaParceiroResponseDTO>> listarTodas() {
        return ResponseEntity.ok(service.listarTodas());
    }

    // Exemplo de uso na URL: /api/oficinas/proximas?lat=-23.5505&lng=-46.6333&raio=20
    @GetMapping("/proximas")
    public ResponseEntity<List<OficinaParceiroResponseDTO>> buscarOficinasProximas(
            @RequestParam Double lat,
            @RequestParam Double lng,
            @RequestParam(defaultValue = "20.0") Double raio) {
        return ResponseEntity.ok(service.buscarProximas(lat, lng, raio));
    }


}
