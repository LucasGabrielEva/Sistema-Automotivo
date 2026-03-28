package com.example.sistema.automotivo.mapper;

import com.example.sistema.automotivo.dto.OficinaParceiroResponseDTO;
import com.example.sistema.automotivo.model.OficinaParceiraModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-27T09:05:28-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 24.0.2 (Oracle Corporation)"
)
@Component
public class OficinaParceiraMapperImpl implements OficinaParceiraMapper {

    @Override
    public OficinaParceiroResponseDTO toResponseDto(OficinaParceiraModel oficinaParceiraModel) {
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
