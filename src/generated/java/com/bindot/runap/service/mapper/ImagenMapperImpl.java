package com.bindot.runap.service.mapper;

import com.bindot.runap.model.Imagen;
import com.bindot.runap.service.dto.ImagenDTO;
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
public class ImagenMapperImpl implements ImagenMapper {

    @Override
    public Imagen toEntity(ImagenDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Imagen imagen = new Imagen();

        imagen.setDescripcion( dto.getDescripcion() );
        imagen.setEnabled( dto.getEnabled() );
        imagen.setId( dto.getId() );

        return imagen;
    }

    @Override
    public ImagenDTO toDto(Imagen entity) {
        if ( entity == null ) {
            return null;
        }

        ImagenDTO imagenDTO = new ImagenDTO();

        imagenDTO.setDescripcion( entity.getDescripcion() );
        imagenDTO.setEnabled( entity.getEnabled() );
        imagenDTO.setId( entity.getId() );

        return imagenDTO;
    }

    @Override
    public List<Imagen> toEntity(List<ImagenDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Imagen> list = new ArrayList<Imagen>( dtoList.size() );
        for ( ImagenDTO imagenDTO : dtoList ) {
            list.add( toEntity( imagenDTO ) );
        }

        return list;
    }

    @Override
    public List<ImagenDTO> toDto(List<Imagen> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ImagenDTO> list = new ArrayList<ImagenDTO>( entityList.size() );
        for ( Imagen imagen : entityList ) {
            list.add( toDto( imagen ) );
        }

        return list;
    }
}
