package com.example.sistema.automotivo.mapper;

import com.example.sistema.automotivo.dto.OficinaParceiroResponseDTO;
import com.example.sistema.automotivo.model.OficinaParceiraModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OficinaParceiraMapper {

    OficinaParceiroResponseDTO toResponseDto(OficinaParceiraModel oficinaParceiraModel);
}
