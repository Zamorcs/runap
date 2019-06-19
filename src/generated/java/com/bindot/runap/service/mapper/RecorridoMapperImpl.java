package com.bindot.runap.service.mapper;

import com.bindot.runap.model.Recorrido;
import com.bindot.runap.service.dto.RecorridoDTO;
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
public class RecorridoMapperImpl implements RecorridoMapper {

    @Override
    public Recorrido toEntity(RecorridoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Recorrido recorrido = new Recorrido();

        recorrido.setDescripcion( dto.getDescripcion() );
        recorrido.setEnabled( dto.getEnabled() );
        recorrido.setId( dto.getId() );

        return recorrido;
    }

    @Override
    public RecorridoDTO toDto(Recorrido entity) {
        if ( entity == null ) {
            return null;
        }

        RecorridoDTO recorridoDTO = new RecorridoDTO();

        recorridoDTO.setDescripcion( entity.getDescripcion() );
        recorridoDTO.setEnabled( entity.getEnabled() );
        recorridoDTO.setId( entity.getId() );

        return recorridoDTO;
    }

    @Override
    public List<Recorrido> toEntity(List<RecorridoDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Recorrido> list = new ArrayList<Recorrido>( dtoList.size() );
        for ( RecorridoDTO recorridoDTO : dtoList ) {
            list.add( toEntity( recorridoDTO ) );
        }

        return list;
    }

    @Override
    public List<RecorridoDTO> toDto(List<Recorrido> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<RecorridoDTO> list = new ArrayList<RecorridoDTO>( entityList.size() );
        for ( Recorrido recorrido : entityList ) {
            list.add( toDto( recorrido ) );
        }

        return list;
    }
}
