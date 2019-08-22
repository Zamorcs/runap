package com.bindot.runap.service.mapper;

import com.bindot.runap.model.Distancia;
import com.bindot.runap.service.dto.DistanciaDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-08-22T02:21:29-0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_171 (Oracle Corporation)"
)
@Component
public class DistanciaMapperImpl implements DistanciaMapper {

    @Override
    public Distancia toEntity(DistanciaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Distancia distancia = new Distancia();

        distancia.setDescripcion( dto.getDescripcion() );
        distancia.setEnabled( dto.getEnabled() );
        distancia.setId( dto.getId() );

        return distancia;
    }

    @Override
    public DistanciaDTO toDto(Distancia entity) {
        if ( entity == null ) {
            return null;
        }

        DistanciaDTO distanciaDTO = new DistanciaDTO();

        distanciaDTO.setDescripcion( entity.getDescripcion() );
        distanciaDTO.setEnabled( entity.getEnabled() );
        distanciaDTO.setId( entity.getId() );

        return distanciaDTO;
    }

    @Override
    public List<Distancia> toEntity(List<DistanciaDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Distancia> list = new ArrayList<Distancia>( dtoList.size() );
        for ( DistanciaDTO distanciaDTO : dtoList ) {
            list.add( toEntity( distanciaDTO ) );
        }

        return list;
    }

    @Override
    public List<DistanciaDTO> toDto(List<Distancia> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<DistanciaDTO> list = new ArrayList<DistanciaDTO>( entityList.size() );
        for ( Distancia distancia : entityList ) {
            list.add( toDto( distancia ) );
        }

        return list;
    }
}
