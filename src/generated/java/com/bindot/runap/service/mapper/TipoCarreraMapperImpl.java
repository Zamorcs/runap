package com.bindot.runap.service.mapper;

import com.bindot.runap.model.TipoCarrera;
import com.bindot.runap.service.dto.TipoCarreraDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-08-27T05:19:55-0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_171 (Oracle Corporation)"
)
@Component
public class TipoCarreraMapperImpl implements TipoCarreraMapper {

    @Override
    public TipoCarrera toEntity(TipoCarreraDTO dto) {
        if ( dto == null ) {
            return null;
        }

        TipoCarrera tipoCarrera = new TipoCarrera();

        tipoCarrera.setDescripcion( dto.getDescripcion() );
        tipoCarrera.setEnabled( dto.getEnabled() );
        tipoCarrera.setId( dto.getId() );

        return tipoCarrera;
    }

    @Override
    public TipoCarreraDTO toDto(TipoCarrera entity) {
        if ( entity == null ) {
            return null;
        }

        TipoCarreraDTO tipoCarreraDTO = new TipoCarreraDTO();

        tipoCarreraDTO.setDescripcion( entity.getDescripcion() );
        tipoCarreraDTO.setEnabled( entity.getEnabled() );
        tipoCarreraDTO.setId( entity.getId() );

        return tipoCarreraDTO;
    }

    @Override
    public List<TipoCarrera> toEntity(List<TipoCarreraDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<TipoCarrera> list = new ArrayList<TipoCarrera>( dtoList.size() );
        for ( TipoCarreraDTO tipoCarreraDTO : dtoList ) {
            list.add( toEntity( tipoCarreraDTO ) );
        }

        return list;
    }

    @Override
    public List<TipoCarreraDTO> toDto(List<TipoCarrera> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<TipoCarreraDTO> list = new ArrayList<TipoCarreraDTO>( entityList.size() );
        for ( TipoCarrera tipoCarrera : entityList ) {
            list.add( toDto( tipoCarrera ) );
        }

        return list;
    }
}
