package com.example.sistema.automotivo.controller;

import com.example.sistema.automotivo.dto.OficinaParceiroRequestDTO;
import com.example.sistema.automotivo.dto.OficinaParceiroResponseDTO;
import com.example.sistema.automotivo.service.OficinaParceiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/oficinas")
@CrossOrigin(origins = "*")
public class OficinaParceiraController {
    @Autowired
    private OficinaParceiroService service;

    @PostMapping
    public ResponseEntity<OficinaParceiroResponseDTO> cadastrarOficina(@RequestBody OficinaParceiroRequestDTO request) {
        return ResponseEntity.ok(service.cadastrarOficina(request));
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
