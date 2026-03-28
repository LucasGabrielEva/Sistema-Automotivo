package com.example.sistema.automotivo.mapper;

import com.example.sistema.automotivo.dto.AgendamentoResponseDTO;
import com.example.sistema.automotivo.dto.UsuarioResponseDTO;
import com.example.sistema.automotivo.model.AgendamentoModel;
import com.example.sistema.automotivo.model.UsuarioModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-27T09:05:28-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 24.0.2 (Oracle Corporation)"
)
@Component
public class AgendamentoMapperImpl implements AgendamentoMapper {

    @Override
    public AgendamentoResponseDTO toResponseDto(AgendamentoModel agendamentoModel) {
        if ( agendamentoModel == null ) {
            return null;
        }

        AgendamentoResponseDTO agendamentoResponseDTO = new AgendamentoResponseDTO();

        agendamentoResponseDTO.setId( agendamentoModel.getId() );
        agendamentoResponseDTO.setCliente( usuarioModelToUsuarioResponseDTO( agendamentoModel.getCliente() ) );
        agendamentoResponseDTO.setDataHoraAgendamento( agendamentoModel.getDataHoraAgendamento() );
        agendamentoResponseDTO.setTipoServico( agendamentoModel.getTipoServico() );
        agendamentoResponseDTO.setStatus( agendamentoModel.getStatus() );
        agendamentoResponseDTO.setDataCriacao( agendamentoModel.getDataCriacao() );

        return agendamentoResponseDTO;
    }

    protected UsuarioResponseDTO usuarioModelToUsuarioResponseDTO(UsuarioModel usuarioModel) {
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
