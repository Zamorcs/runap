package com.bindot.runap.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.bindot.runap.model.ARunapEntity;
import com.bindot.runap.model.Carrera;
import com.bindot.runap.service.dto.CarreraDTO;

/**
 * Mapper for Carrera Entity and DTO
 * 
 * @author Cesar Zamorano
 *
 */
@Mapper(componentModel = "spring", uses = { DistanciaMapper.class, PrecioMapper.class, RecKitMapper.class,
		DireccionMapper.class, FormatoMapper.class, RecorridoMapper.class, ImagenMapper.class,
		TipoCarreraMapper.class })
public interface CarreraMapper extends EntityMapper<CarreraDTO, Carrera> {
	
	@Override
	@Mapping(source = "listaDistancias", target = "listaDistancias")
	@Mapping(source = "listaPrecios", target = "listaPrecios")
	@Mapping(source = "listaRecKits", target = "listaRecKits")
	@Mapping(source = "listaDirecciones", target = "listaDirecciones")
	@Mapping(source = "tipoCarrera.id", target = "tipoCarreraId")
	@Mapping(source = "imagen.id", target = "imagenId")
	@Mapping(source = "recorrido.id", target = "recorridoId")
	@Mapping(source = "formato.id", target = "formatoId")
	CarreraDTO toDto(Carrera entity);

	@Override
	@Mapping(source = "listaDistancias", target = "listaDistancias" , qualifiedByName = "longListToEntityList")
	@Mapping(source = "listaPrecios", target = "listaPrecios", qualifiedByName = "longListToEntityList")
	@Mapping(source = "listaRecKits", target = "listaRecKits", qualifiedByName = "longListToEntityList")
	@Mapping(source = "listaDirecciones", target = "listaDirecciones", qualifiedByName = "longListToEntityList")
	@Mapping(source = "tipoCarreraId", target = "tipoCarrera")
	@Mapping(source = "imagenId", target = "imagen")
	@Mapping(source = "recorridoId", target = "recorrido")
	@Mapping(source = "formatoId", target = "formato")
	Carrera toEntity(CarreraDTO dto);

	@Named("longListToEntityList")
	default List<ARunapEntity> longListToEntityList(List<Long> values, ARunapEntity object){
		Class<? extends ARunapEntity> modelClass = object.getClass();
		ArrayList<ARunapEntity> objects = new ArrayList<ARunapEntity>();
		for (Long value : values) {
			try {
				ARunapEntity instance = modelClass.newInstance();
				instance.setId(value);
				objects.add(instance);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return objects;
	}
}
