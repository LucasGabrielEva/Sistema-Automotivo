package com.example.sistema.automotivo.service;

import com.example.sistema.automotivo.dto.OrdemServicoRequestDTO;
import com.example.sistema.automotivo.dto.OrdemServicoResponseDTO;
import com.example.sistema.automotivo.model.OrdemServicoModel;
import com.example.sistema.automotivo.model.StatusOrdem;
import com.example.sistema.automotivo.repository.OrdemServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrdemServicoService {
    @Autowired
    private OrdemServicoRepository repository;

    public OrdemServicoResponseDTO criarOrdem(OrdemServicoRequestDTO request) {
        OrdemServicoModel ordem = new OrdemServicoModel();
        ordem.setClienteId(request.getClienteId());
        ordem.setModeloVeiculo(request.getModeloVeiculo());
        ordem.setDescricaoProblema(request.getDescricaoProblema());

        ordem = repository.save(ordem);
        return mapearParaResponse(ordem);
    }

    public List<OrdemServicoResponseDTO> listarTodas() {
        return repository.findAll()
                .stream()
                .map(this::mapearParaResponse)
                .collect(Collectors.toList());
    }

    public OrdemServicoResponseDTO atualizarStatus(Long id, StatusOrdem novoStatus) {
        OrdemServicoModel ordem = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("OS não encontrada com id: " + id));

        ordem.setStatus(novoStatus);
        ordem = repository.save(ordem);
        return mapearParaResponse(ordem);
    }

    private OrdemServicoResponseDTO mapearParaResponse(OrdemServicoModel ordem) {
        OrdemServicoResponseDTO response = new OrdemServicoResponseDTO();
        response.setId(ordem.getId());
        response.setClienteId(ordem.getClienteId());
        response.setModeloVeiculo(ordem.getModeloVeiculo());
        response.setDescricaoProblema(ordem.getDescricaoProblema());
        response.setStatus(ordem.getStatus());
        response.setDataCriacao(ordem.getDataCriacao());
        return response;
    }

}
