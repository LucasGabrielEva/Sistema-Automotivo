package com.example.sistema.automotivo.service;

import com.example.sistema.automotivo.dto.OrdemServicoRequestDTO;
import com.example.sistema.automotivo.dto.OrdemServicoResponseDTO;
import com.example.sistema.automotivo.mapper.OrdemServicoMapper;
import com.example.sistema.automotivo.model.OrdemServicoModel;
import com.example.sistema.automotivo.model.StatusOrdem;
import com.example.sistema.automotivo.model.UsuarioModel;
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

    @Autowired
    private UsuarioService usuarioService;




    @Autowired
    private OrdemServicoMapper ordemServicoMapper;

    public OrdemServicoModel criarOrdemServico(OrdemServicoRequestDTO request) {
        UsuarioModel cliente = usuarioService.buscarUsuarioPorId(request.getClienteId());
        OrdemServicoModel ordem = new OrdemServicoModel();
        ordem.setCliente(cliente);
        ordem.setModeloVeiculo(request.getModeloVeiculo());
        ordem.setDescricaoProblema(request.getDescricaoProblema());




        return repository.save(ordem);
    }



    public List<OrdemServicoResponseDTO>listarTodos() {
        return repository.findAll()
                .stream()
                .map(ordemServicoMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    public OrdemServicoModel atualizarOrdemServico(Long id, StatusOrdem novoStatus) {
            OrdemServicoModel ordem =  repository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("OS não encontrado com o id: " + id));


            ordem.setStatus(novoStatus);
            return repository.save(ordem);


    }

}
