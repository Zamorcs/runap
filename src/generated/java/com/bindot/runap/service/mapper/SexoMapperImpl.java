package com.bindot.runap.service.mapper;

import com.bindot.runap.model.Sexo;
import com.bindot.runap.service.dto.SexoDTO;
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
public class SexoMapperImpl implements SexoMapper {

    @Override
    public Sexo toEntity(SexoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Sexo sexo = new Sexo();

        sexo.setDescripcion( dto.getDescripcion() );
        sexo.setEnabled( dto.getEnabled() );
        sexo.setId( dto.getId() );

        return sexo;
    }

    @Override
    public SexoDTO toDto(Sexo entity) {
        if ( entity == null ) {
            return null;
        }

        SexoDTO sexoDTO = new SexoDTO();

        sexoDTO.setDescripcion( entity.getDescripcion() );
        sexoDTO.setEnabled( entity.getEnabled() );
        sexoDTO.setId( entity.getId() );

        return sexoDTO;
    }

    @Override
    public List<Sexo> toEntity(List<SexoDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Sexo> list = new ArrayList<Sexo>( dtoList.size() );
        for ( SexoDTO sexoDTO : dtoList ) {
            list.add( toEntity( sexoDTO ) );
        }

        return list;
    }

    @Override
    public List<SexoDTO> toDto(List<Sexo> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<SexoDTO> list = new ArrayList<SexoDTO>( entityList.size() );
        for ( Sexo sexo : entityList ) {
            list.add( toDto( sexo ) );
        }

        return list;
    }
}
