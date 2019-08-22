package com.bindot.runap.service.mapper;

import com.bindot.runap.model.Formato;
import com.bindot.runap.service.dto.FormatoDTO;
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
public class FormatoMapperImpl implements FormatoMapper {

    @Override
    public Formato toEntity(FormatoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Formato formato = new Formato();

        formato.setDescripcion( dto.getDescripcion() );
        formato.setEnabled( dto.getEnabled() );
        formato.setId( dto.getId() );

        return formato;
    }

    @Override
    public FormatoDTO toDto(Formato entity) {
        if ( entity == null ) {
            return null;
        }

        FormatoDTO formatoDTO = new FormatoDTO();

        formatoDTO.setDescripcion( entity.getDescripcion() );
        formatoDTO.setEnabled( entity.getEnabled() );
        formatoDTO.setId( entity.getId() );

        return formatoDTO;
    }

    @Override
    public List<Formato> toEntity(List<FormatoDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Formato> list = new ArrayList<Formato>( dtoList.size() );
        for ( FormatoDTO formatoDTO : dtoList ) {
            list.add( toEntity( formatoDTO ) );
        }

        return list;
    }

    @Override
    public List<FormatoDTO> toDto(List<Formato> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<FormatoDTO> list = new ArrayList<FormatoDTO>( entityList.size() );
        for ( Formato formato : entityList ) {
            list.add( toDto( formato ) );
        }

        return list;
    }
}
