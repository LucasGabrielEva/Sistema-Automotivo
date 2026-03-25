package com.example.sistema.automotivo.service;

import com.example.sistema.automotivo.dto.AgendamentoRequestDTO;
import com.example.sistema.automotivo.dto.AgendamentoResponseDTO;
import com.example.sistema.automotivo.model.AgendamentoModel;
import com.example.sistema.automotivo.model.StatusAgendamento;
import com.example.sistema.automotivo.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository repository;

    public AgendamentoResponseDTO criarAgendamento(AgendamentoRequestDTO request) {
        AgendamentoModel agendamento = new AgendamentoModel();
        agendamento.setClienteId(request.getClienteId());
        agendamento.setDataHoraAgendamento(request.getDataAgendamento());
        agendamento.setTipoServico(request.getTipoServico());

        agendamento = repository.save(agendamento);
        return mapearParaResponse(agendamento);
    }

    public List<AgendamentoResponseDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(this::mapearParaResponse)
                .collect(Collectors.toList());
    }

    public AgendamentoResponseDTO atualizarStatus(Long id, StatusAgendamento novoStatus) {
        AgendamentoModel agendamento = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Agendamento não encontrado com id: " + id));


        agendamento.setStatus(novoStatus);
        agendamento = repository.save(agendamento);
        return mapearParaResponse(agendamento);
    }

    // Método auxiliar para converter Model em Response DTO
    private AgendamentoResponseDTO mapearParaResponse(AgendamentoModel agendamento) {
        AgendamentoResponseDTO response = new AgendamentoResponseDTO();
        response.setId(agendamento.getId());
        response.setClienteId(agendamento.getClienteId());
        response.setDataHoraAgendamento(agendamento.getDataHoraAgendamento());
        response.setTipoServico(agendamento.getTipoServico());
        response.setStatus(agendamento.getStatus());
        response.setDataCriacao(agendamento.getDataCriacao());
        return response;
    }

}
