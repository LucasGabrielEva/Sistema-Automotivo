package com.example.sistema.automotivo.mapper;

import com.example.sistema.automotivo.dto.AgendamentoResponseDTO;
import com.example.sistema.automotivo.model.AgendamentoModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-26T09:57:22-0300",
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
        agendamentoResponseDTO.setDataHoraAgendamento( agendamentoModel.getDataHoraAgendamento() );
        agendamentoResponseDTO.setTipoServico( agendamentoModel.getTipoServico() );
        agendamentoResponseDTO.setStatus( agendamentoModel.getStatus() );
        agendamentoResponseDTO.setDataCriacao( agendamentoModel.getDataCriacao() );

        return agendamentoResponseDTO;
    }
}
