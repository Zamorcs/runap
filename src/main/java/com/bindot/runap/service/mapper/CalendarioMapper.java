package com.bindot.runap.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.bindot.runap.model.ARunapEntity;
import com.bindot.runap.model.Calendario;
import com.bindot.runap.service.dto.CalendarioDTO;

/**
 * Mapper for Calendario Entity and DTO
 * 
 * @author Cesar Zamorano
 *
 */
@Mapper(componentModel = "spring", uses = { CarreraGuardadaMapper.class, CorredorMapper.class,
		EstadoCalendarioMapper.class })
public interface CalendarioMapper extends EntityMapper<CalendarioDTO, Calendario> {

	@Override
	@Mapping(source = "estadoCalendario.id", target = "estadoCalendarioId")
	@Mapping(source = "corredor.id", target = "corredorId")
	@Mapping(source = "listaCarrerasGuardadas", target = "listaCarrerasGuardadas")
	CalendarioDTO toDto(Calendario calendario);

	@Override
	@Mapping(source = "estadoCalendarioId", target = "estadoCalendario")
	@Mapping(source = "corredorId", target = "corredor")
	@Mapping(source = "listaCarrerasGuardadas", target = "listaCarrerasGuardadas", qualifiedByName = "longListToEntityList")
	Calendario toEntity(CalendarioDTO calendarioDTO);

//	@Named("longListToEntityList")
//	default List<CarreraGuardada> longListToEntityList(List<Long> values) {
//		List<CarreraGuardada> list = new ArrayList<>();
//		for (Long value : values) {
//			CarreraGuardada entity = new CarreraGuardada();
//			entity.setId(value);
//			list.add(entity);
//		}
//		return list;
//	}
//	
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
