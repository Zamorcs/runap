package com.bindot.runap.service.mapper;

import com.bindot.runap.model.Direccion;
import com.bindot.runap.model.Documentacion;
import com.bindot.runap.model.RecKit;
import com.bindot.runap.service.dto.RecKitDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-06-12T01:56:16-0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_171 (Oracle Corporation)"
)
@Component
public class RecKitMapperImpl implements RecKitMapper {

    @Autowired
    private DocumentacionMapper documentacionMapper;
    @Autowired
    private DireccionMapper direccionMapper;

    @Override
    public List<RecKit> toEntity(List<RecKitDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<RecKit> list = new ArrayList<RecKit>( dtoList.size() );
        for ( RecKitDTO recKitDTO : dtoList ) {
            list.add( toEntity( recKitDTO ) );
        }

        return list;
    }

    @Override
    public List<RecKitDTO> toDto(List<RecKit> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<RecKitDTO> list = new ArrayList<RecKitDTO>( entityList.size() );
        for ( RecKit recKit : entityList ) {
            list.add( toDto( recKit ) );
        }

        return list;
    }

    @Override
    public RecKit toEntity(RecKitDTO dto) {
        if ( dto == null ) {
            return null;
        }

        RecKit recKit = new RecKit();

        recKit.setDireccion( direccionMapper.fromLong( dto.getDireccionId() ) );
        recKit.setDocumentacion( documentacionMapper.fromLong( dto.getDocumentacionId() ) );
        recKit.setDescripcion( dto.getDescripcion() );
        recKit.setFechaInicio( dto.getFechaInicio() );
        recKit.setFechaFin( dto.getFechaFin() );
        recKit.setId( dto.getId() );

        return recKit;
    }

    @Override
    public RecKitDTO toDto(RecKit entity) {
        if ( entity == null ) {
            return null;
        }

        RecKitDTO recKitDTO = new RecKitDTO();

        Long id = entityDireccionId( entity );
        if ( id != null ) {
            recKitDTO.setDireccionId( id );
        }
        Long id1 = entityDocumentacionId( entity );
        if ( id1 != null ) {
            recKitDTO.setDocumentacionId( id1 );
        }
        recKitDTO.setId( entity.getId() );
        recKitDTO.setDescripcion( entity.getDescripcion() );
        recKitDTO.setFechaInicio( entity.getFechaInicio() );
        recKitDTO.setFechaFin( entity.getFechaFin() );

        return recKitDTO;
    }

    private Long entityDireccionId(RecKit recKit) {
        if ( recKit == null ) {
            return null;
        }
        Direccion direccion = recKit.getDireccion();
        if ( direccion == null ) {
            return null;
        }
        Long id = direccion.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long entityDocumentacionId(RecKit recKit) {
        if ( recKit == null ) {
            return null;
        }
        Documentacion documentacion = recKit.getDocumentacion();
        if ( documentacion == null ) {
            return null;
        }
        Long id = documentacion.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
