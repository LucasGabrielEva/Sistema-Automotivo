package com.example.sistema.automotivo.mapper;

import com.example.sistema.automotivo.dto.OrdemServicoResponseDTO;
import com.example.sistema.automotivo.model.OrdemServicoModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-26T09:58:35-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 24.0.2 (Oracle Corporation)"
)
@Component
public class OrdemServicoMapperImpl implements OrdemServicoMapper {

    @Override
    public OrdemServicoResponseDTO toResponseDto(OrdemServicoModel ordemServicoModel) {
        if ( ordemServicoModel == null ) {
            return null;
        }

        OrdemServicoResponseDTO ordemServicoResponseDTO = new OrdemServicoResponseDTO();

        ordemServicoResponseDTO.setId( ordemServicoModel.getId() );
        ordemServicoResponseDTO.setModeloVeiculo( ordemServicoModel.getModeloVeiculo() );
        ordemServicoResponseDTO.setDescricaoProblema( ordemServicoModel.getDescricaoProblema() );
        ordemServicoResponseDTO.setStatus( ordemServicoModel.getStatus() );
        ordemServicoResponseDTO.setDataCriacao( ordemServicoModel.getDataCriacao() );

        return ordemServicoResponseDTO;
    }
}
