package com.example.sistema.automotivo.mapper;

import com.example.sistema.automotivo.dto.MensagemChatResponseDTO;
import com.example.sistema.automotivo.model.MensagemChatModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UsuarioMapper.class})
public interface MensagemChatMapper {

    MensagemChatResponseDTO toResponseDto(MensagemChatModel mensagemChatModel);
}
