package com.bindot.runap.service.mapper;

import com.bindot.runap.model.CarreraGuardada;
import com.bindot.runap.service.dto.CarreraGuardadaDTO;
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
public class CarreraGuardadaMapperImpl implements CarreraGuardadaMapper {

    @Override
    public CarreraGuardada toEntity(CarreraGuardadaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        CarreraGuardada carreraGuardada = new CarreraGuardada();

        carreraGuardada.setCarreraId( dto.getCarreraId() );
        carreraGuardada.setInscripto( dto.getInscripto() );
        carreraGuardada.setEnabled( dto.getEnabled() );
        carreraGuardada.setId( dto.getId() );

        return carreraGuardada;
    }

    @Override
    public CarreraGuardadaDTO toDto(CarreraGuardada entity) {
        if ( entity == null ) {
            return null;
        }

        CarreraGuardadaDTO carreraGuardadaDTO = new CarreraGuardadaDTO();

        carreraGuardadaDTO.setId( entity.getId() );
        carreraGuardadaDTO.setCarreraId( entity.getCarreraId() );
        carreraGuardadaDTO.setInscripto( entity.getInscripto() );
        carreraGuardadaDTO.setEnabled( entity.getEnabled() );

        return carreraGuardadaDTO;
    }

    @Override
    public List<CarreraGuardada> toEntity(List<CarreraGuardadaDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<CarreraGuardada> list = new ArrayList<CarreraGuardada>( dtoList.size() );
        for ( CarreraGuardadaDTO carreraGuardadaDTO : dtoList ) {
            list.add( toEntity( carreraGuardadaDTO ) );
        }

        return list;
    }

    @Override
    public List<CarreraGuardadaDTO> toDto(List<CarreraGuardada> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<CarreraGuardadaDTO> list = new ArrayList<CarreraGuardadaDTO>( entityList.size() );
        for ( CarreraGuardada carreraGuardada : entityList ) {
            list.add( toDto( carreraGuardada ) );
        }

        return list;
    }
}
