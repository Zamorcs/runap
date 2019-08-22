package com.bindot.runap.service.mapper;

import com.bindot.runap.model.Carrera;
import com.bindot.runap.model.Direccion;
import com.bindot.runap.model.Distancia;
import com.bindot.runap.model.Formato;
import com.bindot.runap.model.Imagen;
import com.bindot.runap.model.Organizador;
import com.bindot.runap.model.Precio;
import com.bindot.runap.model.RecKit;
import com.bindot.runap.model.Recorrido;
import com.bindot.runap.model.TipoCarrera;
import com.bindot.runap.service.dto.CarreraDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-08-22T02:21:30-0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_171 (Oracle Corporation)"
)
@Component
public class CarreraMapperImpl implements CarreraMapper {

    @Autowired
    private DistanciaMapper distanciaMapper;
    @Autowired
    private PrecioMapper precioMapper;
    @Autowired
    private RecKitMapper recKitMapper;
    @Autowired
    private DireccionMapper direccionMapper;
    @Autowired
    private FormatoMapper formatoMapper;
    @Autowired
    private RecorridoMapper recorridoMapper;
    @Autowired
    private ImagenMapper imagenMapper;
    @Autowired
    private TipoCarreraMapper tipoCarreraMapper;
    @Autowired
    private OrganizadorMapper organizadorMapper;

    @Override
    public List<Carrera> toEntity(List<CarreraDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Carrera> list = new ArrayList<Carrera>( dtoList.size() );
        for ( CarreraDTO carreraDTO : dtoList ) {
            list.add( toEntity( carreraDTO ) );
        }

        return list;
    }

    @Override
    public List<CarreraDTO> toDto(List<Carrera> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<CarreraDTO> list = new ArrayList<CarreraDTO>( entityList.size() );
        for ( Carrera carrera : entityList ) {
            list.add( toDto( carrera ) );
        }

        return list;
    }

    @Override
    public CarreraDTO toDto(Carrera entity) {
        if ( entity == null ) {
            return null;
        }

        CarreraDTO carreraDTO = new CarreraDTO();

        carreraDTO.setListaPrecios( precioMapper.entityListToLongList( entity.getListaPrecios() ) );
        carreraDTO.setListaDirecciones( direccionMapper.entityListToLongList( entity.getListaDirecciones() ) );
        Long id = entityRecorridoId( entity );
        if ( id != null ) {
            carreraDTO.setRecorridoId( id );
        }
        carreraDTO.setListaDistancias( distanciaMapper.entityListToLongList( entity.getListaDistancias() ) );
        Long id1 = entityFormatoId( entity );
        if ( id1 != null ) {
            carreraDTO.setFormatoId( id1 );
        }
        Long id2 = entityOrganizadorId( entity );
        if ( id2 != null ) {
            carreraDTO.setOrganizadorId( id2 );
        }
        carreraDTO.setListaRecKits( recKitMapper.entityListToLongList( entity.getListaRecKits() ) );
        Long id3 = entityTipoCarreraId( entity );
        if ( id3 != null ) {
            carreraDTO.setTipoCarreraId( id3 );
        }
        Long id4 = entityImagenId( entity );
        if ( id4 != null ) {
            carreraDTO.setImagenId( id4 );
        }
        carreraDTO.setId( entity.getId() );
        carreraDTO.setNombre( entity.getNombre() );
        carreraDTO.setDescripcion( entity.getDescripcion() );
        carreraDTO.setFechaInicio( entity.getFechaInicio() );
        carreraDTO.setFechaFin( entity.getFechaFin() );
        carreraDTO.setWebpage( entity.getWebpage() );
        carreraDTO.setPais( entity.getPais() );
        carreraDTO.setFechaInicioInscripcion( entity.getFechaInicioInscripcion() );
        carreraDTO.setNovedades( entity.getNovedades() );
        carreraDTO.setEnabled( entity.getEnabled() );

        return carreraDTO;
    }

    @Override
    public Carrera toEntity(CarreraDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Carrera carrera = new Carrera();

        carrera.setListaPrecios( longListToPrecioList( dto.getListaPrecios() ) );
        carrera.setListaDirecciones( longListToDireccionList( dto.getListaDirecciones() ) );
        carrera.setTipoCarrera( tipoCarreraMapper.fromLong( dto.getTipoCarreraId() ) );
        carrera.setListaDistancias( longListToDistanciaList( dto.getListaDistancias() ) );
        carrera.setFormato( formatoMapper.fromLong( dto.getFormatoId() ) );
        carrera.setImagen( imagenMapper.fromLong( dto.getImagenId() ) );
        carrera.setListaRecKits( longListToRecKitList( dto.getListaRecKits() ) );
        carrera.setRecorrido( recorridoMapper.fromLong( dto.getRecorridoId() ) );
        carrera.setOrganizador( organizadorMapper.fromLong( dto.getOrganizadorId() ) );
        carrera.setNombre( dto.getNombre() );
        carrera.setDescripcion( dto.getDescripcion() );
        carrera.setFechaInicio( dto.getFechaInicio() );
        carrera.setFechaFin( dto.getFechaFin() );
        carrera.setWebpage( dto.getWebpage() );
        carrera.setPais( dto.getPais() );
        carrera.setFechaInicioInscripcion( dto.getFechaInicioInscripcion() );
        carrera.setNovedades( dto.getNovedades() );
        carrera.setEnabled( dto.getEnabled() );
        carrera.setId( dto.getId() );

        return carrera;
    }

    private Long entityRecorridoId(Carrera carrera) {
        if ( carrera == null ) {
            return null;
        }
        Recorrido recorrido = carrera.getRecorrido();
        if ( recorrido == null ) {
            return null;
        }
        Long id = recorrido.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long entityFormatoId(Carrera carrera) {
        if ( carrera == null ) {
            return null;
        }
        Formato formato = carrera.getFormato();
        if ( formato == null ) {
            return null;
        }
        Long id = formato.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long entityOrganizadorId(Carrera carrera) {
        if ( carrera == null ) {
            return null;
        }
        Organizador organizador = carrera.getOrganizador();
        if ( organizador == null ) {
            return null;
        }
        Long id = organizador.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long entityTipoCarreraId(Carrera carrera) {
        if ( carrera == null ) {
            return null;
        }
        TipoCarrera tipoCarrera = carrera.getTipoCarrera();
        if ( tipoCarrera == null ) {
            return null;
        }
        Long id = tipoCarrera.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long entityImagenId(Carrera carrera) {
        if ( carrera == null ) {
            return null;
        }
        Imagen imagen = carrera.getImagen();
        if ( imagen == null ) {
            return null;
        }
        Long id = imagen.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected List<Precio> longListToPrecioList(List<Long> list) {
        if ( list == null ) {
            return null;
        }

        List<Precio> list1 = new ArrayList<Precio>( list.size() );
        for ( Long long1 : list ) {
            list1.add( precioMapper.fromLong( long1 ) );
        }

        return list1;
    }

    protected List<Direccion> longListToDireccionList(List<Long> list) {
        if ( list == null ) {
            return null;
        }

        List<Direccion> list1 = new ArrayList<Direccion>( list.size() );
        for ( Long long1 : list ) {
            list1.add( direccionMapper.fromLong( long1 ) );
        }

        return list1;
    }

    protected List<Distancia> longListToDistanciaList(List<Long> list) {
        if ( list == null ) {
            return null;
        }

        List<Distancia> list1 = new ArrayList<Distancia>( list.size() );
        for ( Long long1 : list ) {
            list1.add( distanciaMapper.fromLong( long1 ) );
        }

        return list1;
    }

    protected List<RecKit> longListToRecKitList(List<Long> list) {
        if ( list == null ) {
            return null;
        }

        List<RecKit> list1 = new ArrayList<RecKit>( list.size() );
        for ( Long long1 : list ) {
            list1.add( recKitMapper.fromLong( long1 ) );
        }

        return list1;
    }
}
