package com.example.sistema.automotivo.service;

import com.example.sistema.automotivo.dto.MensagemChatRequestDTO;
import com.example.sistema.automotivo.dto.MensagemChatResponseDTO;
import com.example.sistema.automotivo.mapper.MensagemChatMapper;
import com.example.sistema.automotivo.model.MensagemChatModel;
import com.example.sistema.automotivo.model.UsuarioModel;
import com.example.sistema.automotivo.repository.MensagemChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MensagemChatService {
    @Autowired
    private MensagemChatRepository repository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private MensagemChatMapper mensagemChatMapper;

    public MensagemChatModel enviarMensagem(MensagemChatRequestDTO request) {
        UsuarioModel remetente = usuarioService.buscarUsuarioPorId(request.getRemetenteId());
        MensagemChatModel mensagemChat = new MensagemChatModel();
        mensagemChat.setOrdemServicoId(request.getOrdemServicoId());
        mensagemChat.setRemetente(remetente);
        mensagemChat.setMensagem(request.getMensagem());

        return  repository.save(mensagemChat);
    }

    public List<MensagemChatResponseDTO> obterHistoricoChat(Long ordemServicoId) {
        return repository.findByOrdemServicoIdOrderByDataEnvioAsc(ordemServicoId)
                .stream()
                .map(mensagemChatMapper::toResponseDto)
                .collect(Collectors.toList());
    }


}
