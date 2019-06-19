package com.bindot.runap.service.mapper;

import com.bindot.runap.model.Avatar;
import com.bindot.runap.model.Corredor;
import com.bindot.runap.model.Sexo;
import com.bindot.runap.model.TipoCorredor;
import com.bindot.runap.service.dto.CorredorDTO;
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
public class CorredorMapperImpl implements CorredorMapper {

    @Autowired
    private TipoCorredorMapper tipoCorredorMapper;
    @Autowired
    private SexoMapper sexoMapper;
    @Autowired
    private AvatarMapper avatarMapper;

    @Override
    public List<Corredor> toEntity(List<CorredorDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Corredor> list = new ArrayList<Corredor>( dtoList.size() );
        for ( CorredorDTO corredorDTO : dtoList ) {
            list.add( toEntity( corredorDTO ) );
        }

        return list;
    }

    @Override
    public List<CorredorDTO> toDto(List<Corredor> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<CorredorDTO> list = new ArrayList<CorredorDTO>( entityList.size() );
        for ( Corredor corredor : entityList ) {
            list.add( toDto( corredor ) );
        }

        return list;
    }

    @Override
    public CorredorDTO toDto(Corredor corredor) {
        if ( corredor == null ) {
            return null;
        }

        CorredorDTO corredorDTO = new CorredorDTO();

        Long id = corredorSexoId( corredor );
        if ( id != null ) {
            corredorDTO.setSexoId( id );
        }
        corredorDTO.setRunningTeamId( corredor.getRunningTeam() );
        Long id1 = corredorTipoCorredorId( corredor );
        if ( id1 != null ) {
            corredorDTO.setTipoCorredorId( id1 );
        }
        Long id2 = corredorAvatarId( corredor );
        if ( id2 != null ) {
            corredorDTO.setAvatarId( id2 );
        }
        corredorDTO.setFriendlistId( corredor.getFriendlist() );
        corredorDTO.setId( corredor.getId() );
        corredorDTO.setNombre( corredor.getNombre() );
        corredorDTO.setApellido( corredor.getApellido() );
        corredorDTO.setFechaNacimiento( corredor.getFechaNacimiento() );
        corredorDTO.setSocial( corredor.getSocial() );
        corredorDTO.setEmail( corredor.getEmail() );
        corredorDTO.setFechaRegistro( corredor.getFechaRegistro() );
        corredorDTO.setFechaUltimoLogin( corredor.getFechaUltimoLogin() );
        corredorDTO.setEnabled( corredor.getEnabled() );

        return corredorDTO;
    }

    @Override
    public Corredor toEntity(CorredorDTO corredorDTO) {
        if ( corredorDTO == null ) {
            return null;
        }

        Corredor corredor = new Corredor();

        corredor.setTipoCorredor( tipoCorredorMapper.fromLong( corredorDTO.getTipoCorredorId() ) );
        corredor.setFriendlist( corredorDTO.getFriendlistId() );
        corredor.setAvatar( avatarMapper.fromLong( corredorDTO.getAvatarId() ) );
        corredor.setRunningTeam( corredorDTO.getRunningTeamId() );
        corredor.setSexo( sexoMapper.fromLong( corredorDTO.getSexoId() ) );
        corredor.setNombre( corredorDTO.getNombre() );
        corredor.setApellido( corredorDTO.getApellido() );
        corredor.setFechaNacimiento( corredorDTO.getFechaNacimiento() );
        corredor.setSocial( corredorDTO.getSocial() );
        corredor.setEmail( corredorDTO.getEmail() );
        corredor.setFechaRegistro( corredorDTO.getFechaRegistro() );
        corredor.setFechaUltimoLogin( corredorDTO.getFechaUltimoLogin() );
        corredor.setEnabled( corredorDTO.getEnabled() );
        corredor.setId( corredorDTO.getId() );

        return corredor;
    }

    private Long corredorSexoId(Corredor corredor) {
        if ( corredor == null ) {
            return null;
        }
        Sexo sexo = corredor.getSexo();
        if ( sexo == null ) {
            return null;
        }
        Long id = sexo.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long corredorTipoCorredorId(Corredor corredor) {
        if ( corredor == null ) {
            return null;
        }
        TipoCorredor tipoCorredor = corredor.getTipoCorredor();
        if ( tipoCorredor == null ) {
            return null;
        }
        Long id = tipoCorredor.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long corredorAvatarId(Corredor corredor) {
        if ( corredor == null ) {
            return null;
        }
        Avatar avatar = corredor.getAvatar();
        if ( avatar == null ) {
            return null;
        }
        Long id = avatar.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
