package com.example.sistema.automotivo.mapper;

import com.example.sistema.automotivo.dto.AgendamentoResponseDTO;
import com.example.sistema.automotivo.model.AgendamentoModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AgendamentoMapper {

    AgendamentoResponseDTO toResponseDto(AgendamentoModel agendamentoModel);
}
