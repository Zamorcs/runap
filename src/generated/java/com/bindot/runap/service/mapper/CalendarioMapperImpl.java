package com.bindot.runap.service.mapper;

import com.bindot.runap.model.Calendario;
import com.bindot.runap.model.CarreraGuardada;
import com.bindot.runap.model.Corredor;
import com.bindot.runap.model.EstadoCalendario;
import com.bindot.runap.service.dto.CalendarioDTO;
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
public class CalendarioMapperImpl implements CalendarioMapper {

    @Autowired
    private CarreraGuardadaMapper carreraGuardadaMapper;
    @Autowired
    private CorredorMapper corredorMapper;
    @Autowired
    private EstadoCalendarioMapper estadoCalendarioMapper;

    @Override
    public List<Calendario> toEntity(List<CalendarioDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Calendario> list = new ArrayList<Calendario>( dtoList.size() );
        for ( CalendarioDTO calendarioDTO : dtoList ) {
            list.add( toEntity( calendarioDTO ) );
        }

        return list;
    }

    @Override
    public List<CalendarioDTO> toDto(List<Calendario> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<CalendarioDTO> list = new ArrayList<CalendarioDTO>( entityList.size() );
        for ( Calendario calendario : entityList ) {
            list.add( toDto( calendario ) );
        }

        return list;
    }

    @Override
    public CalendarioDTO toDto(Calendario calendario) {
        if ( calendario == null ) {
            return null;
        }

        CalendarioDTO calendarioDTO = new CalendarioDTO();

        calendarioDTO.setListaCarrerasGuardadas( carreraGuardadaMapper.entityListToLongList( calendario.getListaCarrerasGuardadas() ) );
        Long id = calendarioEstadoCalendarioId( calendario );
        if ( id != null ) {
            calendarioDTO.setEstadoCalendarioId( id );
        }
        Long id1 = calendarioCorredorId( calendario );
        if ( id1 != null ) {
            calendarioDTO.setCorredorId( id1 );
        }
        calendarioDTO.setId( calendario.getId() );
        calendarioDTO.setEnabled( calendario.getEnabled() );

        return calendarioDTO;
    }

    @Override
    public Calendario toEntity(CalendarioDTO calendarioDTO) {
        if ( calendarioDTO == null ) {
            return null;
        }

        Calendario calendario = new Calendario();

        calendario.setCorredor( corredorMapper.fromLong( calendarioDTO.getCorredorId() ) );
        calendario.setListaCarrerasGuardadas( longListToCarreraGuardadaList( calendarioDTO.getListaCarrerasGuardadas() ) );
        calendario.setEstadoCalendario( estadoCalendarioMapper.fromLong( calendarioDTO.getEstadoCalendarioId() ) );
        calendario.setEnabled( calendarioDTO.getEnabled() );
        calendario.setId( calendarioDTO.getId() );

        return calendario;
    }

    private Long calendarioEstadoCalendarioId(Calendario calendario) {
        if ( calendario == null ) {
            return null;
        }
        EstadoCalendario estadoCalendario = calendario.getEstadoCalendario();
        if ( estadoCalendario == null ) {
            return null;
        }
        Long id = estadoCalendario.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long calendarioCorredorId(Calendario calendario) {
        if ( calendario == null ) {
            return null;
        }
        Corredor corredor = calendario.getCorredor();
        if ( corredor == null ) {
            return null;
        }
        Long id = corredor.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected List<CarreraGuardada> longListToCarreraGuardadaList(List<Long> list) {
        if ( list == null ) {
            return null;
        }

        List<CarreraGuardada> list1 = new ArrayList<CarreraGuardada>( list.size() );
        for ( Long long1 : list ) {
            list1.add( carreraGuardadaMapper.fromLong( long1 ) );
        }

        return list1;
    }
}
