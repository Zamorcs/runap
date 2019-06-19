package com.bindot.runap.service.mapper;

import com.bindot.runap.model.TipoDireccion;
import com.bindot.runap.service.dto.TipoDireccionDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-06-12T01:56:16-0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_171 (Oracle Corporation)"
)
@Component
public class TipoDireccionMapperImpl implements TipoDireccionMapper {

    @Override
    public TipoDireccion toEntity(TipoDireccionDTO dto) {
        if ( dto == null ) {
            return null;
        }

        TipoDireccion tipoDireccion = new TipoDireccion();

        tipoDireccion.setDescripcion( dto.getDescripcion() );
        tipoDireccion.setEnabled( dto.getEnabled() );
        tipoDireccion.setId( dto.getId() );

        return tipoDireccion;
    }

    @Override
    public TipoDireccionDTO toDto(TipoDireccion entity) {
        if ( entity == null ) {
            return null;
        }

        TipoDireccionDTO tipoDireccionDTO = new TipoDireccionDTO();

        tipoDireccionDTO.setDescripcion( entity.getDescripcion() );
        tipoDireccionDTO.setEnabled( entity.getEnabled() );
        tipoDireccionDTO.setId( entity.getId() );

        return tipoDireccionDTO;
    }

    @Override
    public List<TipoDireccion> toEntity(List<TipoDireccionDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<TipoDireccion> list = new ArrayList<TipoDireccion>( dtoList.size() );
        for ( TipoDireccionDTO tipoDireccionDTO : dtoList ) {
            list.add( toEntity( tipoDireccionDTO ) );
        }

        return list;
    }

    @Override
    public List<TipoDireccionDTO> toDto(List<TipoDireccion> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<TipoDireccionDTO> list = new ArrayList<TipoDireccionDTO>( entityList.size() );
        for ( TipoDireccion tipoDireccion : entityList ) {
            list.add( toDto( tipoDireccion ) );
        }

        return list;
    }
}
