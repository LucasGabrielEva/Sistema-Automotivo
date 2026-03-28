package com.example.sistema.automotivo.service;

import com.example.sistema.automotivo.dto.AgendamentoRequestDTO;
import com.example.sistema.automotivo.dto.AgendamentoResponseDTO;
import com.example.sistema.automotivo.mapper.AgendamentoMapper;
import com.example.sistema.automotivo.model.AgendamentoModel;
import com.example.sistema.automotivo.model.OficinaParceiraModel;
import com.example.sistema.automotivo.model.StatusAgendamento;
import com.example.sistema.automotivo.model.UsuarioModel;
import com.example.sistema.automotivo.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository repository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private AgendamentoMapper agendamentoMapper;

    @Autowired
    private OficinaParceiroService oficinaParceiroService;


    public AgendamentoModel criarAgendamento(AgendamentoRequestDTO request) {
        UsuarioModel cliente = usuarioService.buscarUsuarioPorId(request.getOficinaId());
        OficinaParceiraModel oficina = oficinaParceiroService.buscarOficinaParceiraPorId(request.getOficinaId());
        AgendamentoModel agendamento = new AgendamentoModel();
        agendamento.setCliente(cliente);
        agendamento.setOficina(oficina);
        agendamento.setDataHoraAgendamento(request.getDataAgendamento());
        agendamento.setTipoServico(request.getTipoServico());
        agendamento.setStatus(StatusAgendamento.PEDENTE);

        return repository.save(agendamento);

    }

    public List<AgendamentoResponseDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(agendamentoMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    public AgendamentoModel atualizarStatus(Long id, StatusAgendamento novoStatus) {
        AgendamentoModel agendamento = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Agendamento não encontrado"));


        agendamento.setStatus(novoStatus);
       return repository.save(agendamento);

    }



}
