package com.bindot.runap.service.mapper;

import com.bindot.runap.model.EstadoCalendario;
import com.bindot.runap.service.dto.EstadoCalendarioDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-08-27T05:19:56-0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_171 (Oracle Corporation)"
)
@Component
public class EstadoCalendarioMapperImpl implements EstadoCalendarioMapper {

    @Override
    public EstadoCalendario toEntity(EstadoCalendarioDTO dto) {
        if ( dto == null ) {
            return null;
        }

        EstadoCalendario estadoCalendario = new EstadoCalendario();

        estadoCalendario.setDescripcion( dto.getDescripcion() );
        estadoCalendario.setEnabled( dto.getEnabled() );
        estadoCalendario.setId( dto.getId() );

        return estadoCalendario;
    }

    @Override
    public EstadoCalendarioDTO toDto(EstadoCalendario entity) {
        if ( entity == null ) {
            return null;
        }

        EstadoCalendarioDTO estadoCalendarioDTO = new EstadoCalendarioDTO();

        estadoCalendarioDTO.setDescripcion( entity.getDescripcion() );
        estadoCalendarioDTO.setEnabled( entity.getEnabled() );
        estadoCalendarioDTO.setId( entity.getId() );

        return estadoCalendarioDTO;
    }

    @Override
    public List<EstadoCalendario> toEntity(List<EstadoCalendarioDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<EstadoCalendario> list = new ArrayList<EstadoCalendario>( dtoList.size() );
        for ( EstadoCalendarioDTO estadoCalendarioDTO : dtoList ) {
            list.add( toEntity( estadoCalendarioDTO ) );
        }

        return list;
    }

    @Override
    public List<EstadoCalendarioDTO> toDto(List<EstadoCalendario> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<EstadoCalendarioDTO> list = new ArrayList<EstadoCalendarioDTO>( entityList.size() );
        for ( EstadoCalendario estadoCalendario : entityList ) {
            list.add( toDto( estadoCalendario ) );
        }

        return list;
    }
}
