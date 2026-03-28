package com.example.sistema.automotivo.mapper;

import com.example.sistema.automotivo.dto.MensagemChatResponseDTO;
import com.example.sistema.automotivo.model.MensagemChatModel;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-27T09:05:28-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 24.0.2 (Oracle Corporation)"
)
@Component
public class MensagemChatMapperImpl implements MensagemChatMapper {

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Override
    public MensagemChatResponseDTO toResponseDto(MensagemChatModel mensagemChatModel) {
        if ( mensagemChatModel == null ) {
            return null;
        }

        MensagemChatResponseDTO mensagemChatResponseDTO = new MensagemChatResponseDTO();

        mensagemChatResponseDTO.setId( mensagemChatModel.getId() );
        mensagemChatResponseDTO.setRemetente( usuarioMapper.toResponseDto( mensagemChatModel.getRemetente() ) );
        mensagemChatResponseDTO.setMensagem( mensagemChatModel.getMensagem() );
        mensagemChatResponseDTO.setDataEnvio( mensagemChatModel.getDataEnvio() );

        return mensagemChatResponseDTO;
    }
}
