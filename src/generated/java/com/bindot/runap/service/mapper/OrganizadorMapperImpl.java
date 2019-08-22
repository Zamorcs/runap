package com.bindot.runap.service.mapper;

import com.bindot.runap.model.Organizador;
import com.bindot.runap.service.dto.OrganizadorDTO;
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
public class OrganizadorMapperImpl implements OrganizadorMapper {

    @Override
    public Organizador toEntity(OrganizadorDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Organizador organizador = new Organizador();

        organizador.setDescripcion( dto.getDescripcion() );
        organizador.setEnabled( dto.getEnabled() );
        organizador.setId( dto.getId() );
        organizador.setWebpage( dto.getWebpage() );

        return organizador;
    }

    @Override
    public OrganizadorDTO toDto(Organizador entity) {
        if ( entity == null ) {
            return null;
        }

        OrganizadorDTO organizadorDTO = new OrganizadorDTO();

        organizadorDTO.setDescripcion( entity.getDescripcion() );
        organizadorDTO.setEnabled( entity.getEnabled() );
        organizadorDTO.setId( entity.getId() );
        organizadorDTO.setWebpage( entity.getWebpage() );

        return organizadorDTO;
    }

    @Override
    public List<Organizador> toEntity(List<OrganizadorDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Organizador> list = new ArrayList<Organizador>( dtoList.size() );
        for ( OrganizadorDTO organizadorDTO : dtoList ) {
            list.add( toEntity( organizadorDTO ) );
        }

        return list;
    }

    @Override
    public List<OrganizadorDTO> toDto(List<Organizador> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<OrganizadorDTO> list = new ArrayList<OrganizadorDTO>( entityList.size() );
        for ( Organizador organizador : entityList ) {
            list.add( toDto( organizador ) );
        }

        return list;
    }
}
