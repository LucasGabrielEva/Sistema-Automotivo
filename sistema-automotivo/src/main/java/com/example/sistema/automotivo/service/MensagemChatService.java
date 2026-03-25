package com.example.sistema.automotivo.service;

import com.example.sistema.automotivo.dto.MensagemChatRequestDTO;
import com.example.sistema.automotivo.dto.MensagemChatResponseDTO;
import com.example.sistema.automotivo.model.MensagemChatModel;
import com.example.sistema.automotivo.repository.MensagemChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MensagemChatService {
    @Autowired
    private MensagemChatRepository repository;

    public MensagemChatResponseDTO enviarMensagem(MensagemChatRequestDTO request) {
        MensagemChatModel mensagemChat = new MensagemChatModel();
        mensagemChat.setOrdemServicoId(request.getOrdemServicoId());
        mensagemChat.setRemetenteId(request.getRemetenteId());
        mensagemChat.setMensagem(request.getMensagem());

        mensagemChat = repository.save(mensagemChat);
        return mapearParaResponse(mensagemChat);
    }

    public List<MensagemChatResponseDTO> obterHistoricoChat(Long ordemServicoId) {
        return repository.findByOrdemServicoIdOrderByDataEnvioAsc(ordemServicoId)
                .stream()
                .map(this::mapearParaResponse)
                .collect(Collectors.toList());
    }

    private MensagemChatResponseDTO mapearParaResponse(MensagemChatModel mensagemChat) {
        MensagemChatResponseDTO response = new MensagemChatResponseDTO();
        response.setId(mensagemChat.getId());
        response.setOrdemServicoId(mensagemChat.getOrdemServicoId());
        response.setRemetenteId(mensagemChat.getRemetenteId());
        response.setMensagem(mensagemChat.getMensagem());
        response.setDataEnvio(mensagemChat.getDataEnvio());
        return response;
    }
}
