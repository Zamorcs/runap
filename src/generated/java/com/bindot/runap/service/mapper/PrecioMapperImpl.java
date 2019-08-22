package com.bindot.runap.service.mapper;

import com.bindot.runap.model.Precio;
import com.bindot.runap.service.dto.PrecioDTO;
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
public class PrecioMapperImpl implements PrecioMapper {

    @Override
    public Precio toEntity(PrecioDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Precio precio = new Precio();

        precio.setDescripcion( dto.getDescripcion() );
        precio.setFechaInicio( dto.getFechaInicio() );
        precio.setFechaFin( dto.getFechaFin() );
        precio.setMoneda( dto.getMoneda() );
        precio.setMonto( dto.getMonto() );
        precio.setEnabled( dto.getEnabled() );
        precio.setId( dto.getId() );

        return precio;
    }

    @Override
    public PrecioDTO toDto(Precio entity) {
        if ( entity == null ) {
            return null;
        }

        PrecioDTO precioDTO = new PrecioDTO();

        precioDTO.setDescripcion( entity.getDescripcion() );
        precioDTO.setFechaInicio( entity.getFechaInicio() );
        precioDTO.setFechaFin( entity.getFechaFin() );
        precioDTO.setMoneda( entity.getMoneda() );
        precioDTO.setMonto( entity.getMonto() );
        precioDTO.setEnabled( entity.getEnabled() );
        precioDTO.setId( entity.getId() );

        return precioDTO;
    }

    @Override
    public List<Precio> toEntity(List<PrecioDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Precio> list = new ArrayList<Precio>( dtoList.size() );
        for ( PrecioDTO precioDTO : dtoList ) {
            list.add( toEntity( precioDTO ) );
        }

        return list;
    }

    @Override
    public List<PrecioDTO> toDto(List<Precio> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<PrecioDTO> list = new ArrayList<PrecioDTO>( entityList.size() );
        for ( Precio precio : entityList ) {
            list.add( toDto( precio ) );
        }

        return list;
    }
}
