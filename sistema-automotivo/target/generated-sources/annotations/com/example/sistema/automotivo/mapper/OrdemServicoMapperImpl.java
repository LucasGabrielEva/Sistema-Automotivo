package com.example.sistema.automotivo.mapper;

import com.example.sistema.automotivo.dto.OficinaParceiroResponseDTO;
import com.example.sistema.automotivo.dto.OrdemServicoResponseDTO;
import com.example.sistema.automotivo.model.OficinaParceiraModel;
import com.example.sistema.automotivo.model.OrdemServicoModel;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-01T20:02:01-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 24.0.2 (Oracle Corporation)"
)
@Component
public class OrdemServicoMapperImpl implements OrdemServicoMapper {

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Override
    public OrdemServicoResponseDTO toResponseDto(OrdemServicoModel ordemServicoModel) {
        if ( ordemServicoModel == null ) {
            return null;
        }

        OrdemServicoResponseDTO ordemServicoResponseDTO = new OrdemServicoResponseDTO();

        ordemServicoResponseDTO.setId( ordemServicoModel.getId() );
        ordemServicoResponseDTO.setCliente( usuarioMapper.toResponseDto( ordemServicoModel.getCliente() ) );
        ordemServicoResponseDTO.setOficina( oficinaParceiraModelToOficinaParceiroResponseDTO( ordemServicoModel.getOficina() ) );
        ordemServicoResponseDTO.setModeloVeiculo( ordemServicoModel.getModeloVeiculo() );
        ordemServicoResponseDTO.setDescricaoProblema( ordemServicoModel.getDescricaoProblema() );
        ordemServicoResponseDTO.setStatus( ordemServicoModel.getStatus() );
        ordemServicoResponseDTO.setDataCriacao( ordemServicoModel.getDataCriacao() );

        return ordemServicoResponseDTO;
    }

    protected OficinaParceiroResponseDTO oficinaParceiraModelToOficinaParceiroResponseDTO(OficinaParceiraModel oficinaParceiraModel) {
        if ( oficinaParceiraModel == null ) {
            return null;
        }

        OficinaParceiroResponseDTO oficinaParceiroResponseDTO = new OficinaParceiroResponseDTO();

        oficinaParceiroResponseDTO.setId( oficinaParceiraModel.getId() );
        oficinaParceiroResponseDTO.setNome( oficinaParceiraModel.getNome() );
        oficinaParceiroResponseDTO.setLatitude( oficinaParceiraModel.getLatitude() );
        oficinaParceiroResponseDTO.setLongitude( oficinaParceiraModel.getLongitude() );
        oficinaParceiroResponseDTO.setEndereco( oficinaParceiraModel.getEndereco() );

        return oficinaParceiroResponseDTO;
    }
}
