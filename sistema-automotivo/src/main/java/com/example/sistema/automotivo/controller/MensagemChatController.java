package com.example.sistema.automotivo.controller;

import com.example.sistema.automotivo.dto.MensagemChatRequestDTO;
import com.example.sistema.automotivo.dto.MensagemChatResponseDTO;
import com.example.sistema.automotivo.service.MensagemChatService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/chat")
@CrossOrigin(origins = "*")
public class MensagemChatController {

    @Autowired
    private MensagemChatService service;

    // Endpoint para enviar uma nova mensagem
    @PostMapping
    public ResponseEntity<Map<String, Object>> enviarMensagem(@Valid  @RequestBody MensagemChatRequestDTO request) {
        service.enviarMensagem(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("message", "Mensagem enviado", "success", true));
    }

    // Endpoint para carregar o histórico de uma OS específica
    @GetMapping("/historico/{ordemServicoId}")
    public ResponseEntity<List<MensagemChatResponseDTO>> carregarHistorico(@PathVariable Long ordemServicoId) {
        return ResponseEntity.ok(service.obterHistoricoChat(ordemServicoId));
    }
}
