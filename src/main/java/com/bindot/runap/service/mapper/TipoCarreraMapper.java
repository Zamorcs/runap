package com.bindot.runap.service.mapper;

import org.mapstruct.Mapper;

import com.bindot.runap.model.TipoCarrera;
import com.bindot.runap.service.dto.TipoCarreraDTO;

/**
 * Mapper for TipoCarrera Entity and DTO
 * 
 * @author Cesar Zamorano
 *
 */
@Mapper(componentModel = "spring", uses = {})
public interface TipoCarreraMapper extends EntityMapper<TipoCarreraDTO, TipoCarrera> {

	default TipoCarrera fromLong(Long value) {
		TipoCarrera entity= new TipoCarrera();
		entity.setId(value);
		return entity;
	}
}
