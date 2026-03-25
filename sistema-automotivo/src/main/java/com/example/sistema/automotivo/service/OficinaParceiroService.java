package com.example.sistema.automotivo.service;

import com.example.sistema.automotivo.dto.OficinaParceiroRequestDTO;
import com.example.sistema.automotivo.dto.OficinaParceiroResponseDTO;
import com.example.sistema.automotivo.model.OficinaParceiraModel;
import com.example.sistema.automotivo.repository.OficinaParceiroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OficinaParceiroService {
    private OficinaParceiroRepository repository;

    public OficinaParceiroResponseDTO cadastrarOficina(OficinaParceiroRequestDTO request) {
        OficinaParceiraModel oficina = new OficinaParceiraModel();
        oficina.setNome(request.getNome());
        oficina.setLatitude(request.getLatitude());
        oficina.setLongitude(request.getLongitude());
        oficina.setEndereco(request.getEndereco());

        oficina = repository.save(oficina);
        return mapearParaResponse(oficina);
    }

    public List<OficinaParceiroResponseDTO> listarTodas() {
        return repository.findAll()
                .stream()
                .map(this::mapearParaResponse)
                .collect(Collectors.toList());
    }

    // Método que utiliza a busca por raio (ex: 20km)
    public List<OficinaParceiroResponseDTO> buscarProximas(Double lat, Double lng, Double raioKm) {
        return repository.buscarOficinasProximas(lat, lng, raioKm)
                .stream()
                .map(this::mapearParaResponse)
                .collect(Collectors.toList());
    }

    private OficinaParceiroResponseDTO mapearParaResponse(OficinaParceiraModel oficina) {
        OficinaParceiroResponseDTO response = new OficinaParceiroResponseDTO();
        response.setId(oficina.getId());
        response.setNome(oficina.getNome());
        response.setLatitude(oficina.getLatitude());
        response.setLongitude(oficina.getLongitude());
        response.setEndereco(oficina.getEndereco());
        return response;
    }



}
