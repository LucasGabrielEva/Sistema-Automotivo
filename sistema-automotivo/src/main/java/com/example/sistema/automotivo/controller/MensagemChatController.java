package com.example.sistema.automotivo.controller;

import com.example.sistema.automotivo.dto.MensagemChatRequestDTO;
import com.example.sistema.automotivo.dto.MensagemChatResponseDTO;
import com.example.sistema.automotivo.service.MensagemChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chat")
@CrossOrigin(origins = "*")
public class MensagemChatController {

    @Autowired 
    private MensagemChatService service;

    // Endpoint para enviar uma nova mensagem
    @PostMapping
    public ResponseEntity<MensagemChatResponseDTO> enviarMensagem(@RequestBody MensagemChatRequestDTO request) {
        return ResponseEntity.ok(service.enviarMensagem(request));
    }

    // Endpoint para carregar o histórico de uma OS específica
    @GetMapping("/historico/{ordemServicoId}")
    public ResponseEntity<List<MensagemChatResponseDTO>> carregarHistorico(@PathVariable Long ordemServicoId) {
        return ResponseEntity.ok(service.obterHistoricoChat(ordemServicoId));
    }
}
