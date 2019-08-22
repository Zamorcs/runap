package com.bindot.runap.service.mapper;

import com.bindot.runap.model.Documentacion;
import com.bindot.runap.service.dto.DocumentacionDTO;
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
public class DocumentacionMapperImpl implements DocumentacionMapper {

    @Override
    public Documentacion toEntity(DocumentacionDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Documentacion documentacion = new Documentacion();

        documentacion.setDescripcion( dto.getDescripcion() );
        documentacion.setObligatorio( dto.getObligatorio() );
        documentacion.setEnabled( dto.getEnabled() );
        documentacion.setId( dto.getId() );

        return documentacion;
    }

    @Override
    public DocumentacionDTO toDto(Documentacion entity) {
        if ( entity == null ) {
            return null;
        }

        DocumentacionDTO documentacionDTO = new DocumentacionDTO();

        documentacionDTO.setDescripcion( entity.getDescripcion() );
        documentacionDTO.setObligatorio( entity.getObligatorio() );
        documentacionDTO.setEnabled( entity.getEnabled() );
        documentacionDTO.setId( entity.getId() );

        return documentacionDTO;
    }

    @Override
    public List<Documentacion> toEntity(List<DocumentacionDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Documentacion> list = new ArrayList<Documentacion>( dtoList.size() );
        for ( DocumentacionDTO documentacionDTO : dtoList ) {
            list.add( toEntity( documentacionDTO ) );
        }

        return list;
    }

    @Override
    public List<DocumentacionDTO> toDto(List<Documentacion> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<DocumentacionDTO> list = new ArrayList<DocumentacionDTO>( entityList.size() );
        for ( Documentacion documentacion : entityList ) {
            list.add( toDto( documentacion ) );
        }

        return list;
    }
}
