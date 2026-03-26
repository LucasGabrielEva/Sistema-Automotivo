package com.example.sistema.automotivo.service;

import com.example.sistema.automotivo.dto.OficinaParceiroRequestDTO;
import com.example.sistema.automotivo.dto.OficinaParceiroResponseDTO;
import com.example.sistema.automotivo.mapper.OficinaParceiraMapper;
import com.example.sistema.automotivo.model.OficinaParceiraModel;
import com.example.sistema.automotivo.repository.OficinaParceiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OficinaParceiroService {
    @Autowired
    private OficinaParceiroRepository repository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private OficinaParceiraMapper oficinaParceiraMapper;


    public OficinaParceiraModel cadastrarOficina(OficinaParceiroRequestDTO request) {
        OficinaParceiraModel oficina = new OficinaParceiraModel();
        oficina.setNome(request.getNome());
        oficina.setLatitude(request.getLatitude());
        oficina.setLongitude(request.getLongitude());
        oficina.setEndereco(request.getEndereco());

        // Retorna diretamente o save, igual ao enviarMensagem
        return repository.save(oficina);
    }

    public List<OficinaParceiroResponseDTO> listarTodas() {
        return repository.findAll()
                .stream()
                // Usa o mapper injetado, igual ao obterHistoricoChat
                .map(oficinaParceiraMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    // Metodo que utiliza a busca por raio (ex: 20km)
    public List<OficinaParceiroResponseDTO> buscarProximas(Double lat, Double lng, Double raioKm) {
        return repository.buscarOficinasProximas(lat, lng, raioKm)
                .stream()
                // Usa o mapper injetado, igual ao obterHistoricoChat
                .map(oficinaParceiraMapper::toResponseDto)
                .collect(Collectors.toList());
    }



}
