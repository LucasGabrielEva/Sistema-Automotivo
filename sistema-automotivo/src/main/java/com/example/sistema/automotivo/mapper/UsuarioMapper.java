package com.example.sistema.automotivo.mapper;

import com.example.sistema.automotivo.dto.UsuarioResponseDTO;
import com.example.sistema.automotivo.model.UsuarioModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioResponseDTO toResponseDto(UsuarioModel usuarioModel);
}
