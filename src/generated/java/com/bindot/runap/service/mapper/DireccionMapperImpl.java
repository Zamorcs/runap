package com.bindot.runap.service.mapper;

import com.bindot.runap.model.Direccion;
import com.bindot.runap.model.TipoDireccion;
import com.bindot.runap.service.dto.DireccionDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-08-27T05:19:56-0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_171 (Oracle Corporation)"
)
@Component
public class DireccionMapperImpl implements DireccionMapper {

    @Autowired
    private TipoDireccionMapper tipoDireccionMapper;

    @Override
    public List<Direccion> toEntity(List<DireccionDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Direccion> list = new ArrayList<Direccion>( dtoList.size() );
        for ( DireccionDTO direccionDTO : dtoList ) {
            list.add( toEntity( direccionDTO ) );
        }

        return list;
    }

    @Override
    public List<DireccionDTO> toDto(List<Direccion> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<DireccionDTO> list = new ArrayList<DireccionDTO>( entityList.size() );
        for ( Direccion direccion : entityList ) {
            list.add( toDto( direccion ) );
        }

        return list;
    }

    @Override
    public DireccionDTO toDto(Direccion entity) {
        if ( entity == null ) {
            return null;
        }

        DireccionDTO direccionDTO = new DireccionDTO();

        Long id = entityTipoDireccionId( entity );
        if ( id != null ) {
            direccionDTO.setTipoDireccionId( id );
        }
        direccionDTO.setId( entity.getId() );
        direccionDTO.setCalle( entity.getCalle() );
        direccionDTO.setNumero( entity.getNumero() );
        direccionDTO.setLocalidad( entity.getLocalidad() );
        direccionDTO.setCodigoPostal( entity.getCodigoPostal() );
        direccionDTO.setProvincia( entity.getProvincia() );
        direccionDTO.setPais( entity.getPais() );
        direccionDTO.setNotas( entity.getNotas() );
        direccionDTO.setEnabled( entity.getEnabled() );

        return direccionDTO;
    }

    @Override
    public Direccion toEntity(DireccionDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Direccion direccion = new Direccion();

        direccion.setTipoDireccion( tipoDireccionMapper.fromLong( dto.getTipoDireccionId() ) );
        direccion.setCalle( dto.getCalle() );
        direccion.setNumero( dto.getNumero() );
        direccion.setLocalidad( dto.getLocalidad() );
        direccion.setCodigoPostal( dto.getCodigoPostal() );
        direccion.setProvincia( dto.getProvincia() );
        direccion.setPais( dto.getPais() );
        direccion.setNotas( dto.getNotas() );
        direccion.setEnabled( dto.getEnabled() );
        direccion.setId( dto.getId() );

        return direccion;
    }

    private Long entityTipoDireccionId(Direccion direccion) {
        if ( direccion == null ) {
            return null;
        }
        TipoDireccion tipoDireccion = direccion.getTipoDireccion();
        if ( tipoDireccion == null ) {
            return null;
        }
        Long id = tipoDireccion.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
