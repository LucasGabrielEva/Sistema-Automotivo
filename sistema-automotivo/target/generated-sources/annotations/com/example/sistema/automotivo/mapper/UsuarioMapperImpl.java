package com.example.sistema.automotivo.mapper;

import com.example.sistema.automotivo.dto.UsuarioResponseDTO;
import com.example.sistema.automotivo.model.UsuarioModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-01T20:02:01-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 24.0.2 (Oracle Corporation)"
)
@Component
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public UsuarioResponseDTO toResponseDto(UsuarioModel usuarioModel) {
        if ( usuarioModel == null ) {
            return null;
        }

        UsuarioResponseDTO usuarioResponseDTO = new UsuarioResponseDTO();

        usuarioResponseDTO.setId( usuarioModel.getId() );
        usuarioResponseDTO.setNome( usuarioModel.getNome() );
        usuarioResponseDTO.setEmail( usuarioModel.getEmail() );
        usuarioResponseDTO.setSenha( usuarioModel.getSenha() );
        usuarioResponseDTO.setPerfil( usuarioModel.getPerfil() );
        if ( usuarioModel.getDataCriacao() != null ) {
            usuarioResponseDTO.setDataCriacao( usuarioModel.getDataCriacao().toLocalDate() );
        }

        return usuarioResponseDTO;
    }
}
