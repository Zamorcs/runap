package com.bindot.runap.service.mapper;

import com.bindot.runap.model.TipoCorredor;
import com.bindot.runap.service.dto.TipoCorredorDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-08-22T02:21:30-0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_171 (Oracle Corporation)"
)
@Component
public class TipoCorredorMapperImpl implements TipoCorredorMapper {

    @Override
    public TipoCorredor toEntity(TipoCorredorDTO dto) {
        if ( dto == null ) {
            return null;
        }

        TipoCorredor tipoCorredor = new TipoCorredor();

        tipoCorredor.setDescripcion( dto.getDescripcion() );
        tipoCorredor.setEnabled( dto.getEnabled() );
        tipoCorredor.setId( dto.getId() );

        return tipoCorredor;
    }

    @Override
    public TipoCorredorDTO toDto(TipoCorredor entity) {
        if ( entity == null ) {
            return null;
        }

        TipoCorredorDTO tipoCorredorDTO = new TipoCorredorDTO();

        tipoCorredorDTO.setDescripcion( entity.getDescripcion() );
        tipoCorredorDTO.setEnabled( entity.getEnabled() );
        tipoCorredorDTO.setId( entity.getId() );

        return tipoCorredorDTO;
    }

    @Override
    public List<TipoCorredor> toEntity(List<TipoCorredorDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<TipoCorredor> list = new ArrayList<TipoCorredor>( dtoList.size() );
        for ( TipoCorredorDTO tipoCorredorDTO : dtoList ) {
            list.add( toEntity( tipoCorredorDTO ) );
        }

        return list;
    }

    @Override
    public List<TipoCorredorDTO> toDto(List<TipoCorredor> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<TipoCorredorDTO> list = new ArrayList<TipoCorredorDTO>( entityList.size() );
        for ( TipoCorredor tipoCorredor : entityList ) {
            list.add( toDto( tipoCorredor ) );
        }

        return list;
    }
}
