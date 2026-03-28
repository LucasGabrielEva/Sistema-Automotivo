package com.example.sistema.automotivo.mapper;

import com.example.sistema.automotivo.dto.OrdemServicoResponseDTO;
import com.example.sistema.automotivo.model.OrdemServicoModel;
import com.example.sistema.automotivo.model.UsuarioModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UsuarioMapper.class})
public interface OrdemServicoMapper {
    OrdemServicoResponseDTO toResponseDto(OrdemServicoModel ordemServicoModel);
}
