package com.bindot.runap.service.mapper;

import com.bindot.runap.model.Avatar;
import com.bindot.runap.service.dto.AvatarDTO;
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
public class AvatarMapperImpl implements AvatarMapper {

    @Override
    public Avatar toEntity(AvatarDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Avatar avatar = new Avatar();

        avatar.setDescripcion( dto.getDescripcion() );
        avatar.setEnabled( dto.getEnabled() );
        avatar.setId( dto.getId() );

        return avatar;
    }

    @Override
    public AvatarDTO toDto(Avatar entity) {
        if ( entity == null ) {
            return null;
        }

        AvatarDTO avatarDTO = new AvatarDTO();

        avatarDTO.setDescripcion( entity.getDescripcion() );
        avatarDTO.setEnabled( entity.getEnabled() );
        avatarDTO.setId( entity.getId() );

        return avatarDTO;
    }

    @Override
    public List<Avatar> toEntity(List<AvatarDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Avatar> list = new ArrayList<Avatar>( dtoList.size() );
        for ( AvatarDTO avatarDTO : dtoList ) {
            list.add( toEntity( avatarDTO ) );
        }

        return list;
    }

    @Override
    public List<AvatarDTO> toDto(List<Avatar> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<AvatarDTO> list = new ArrayList<AvatarDTO>( entityList.size() );
        for ( Avatar avatar : entityList ) {
            list.add( toDto( avatar ) );
        }

        return list;
    }
}
