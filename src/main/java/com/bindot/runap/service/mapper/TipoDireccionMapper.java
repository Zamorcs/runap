package com.bindot.runap.service.mapper;

import org.mapstruct.Mapper;

import com.bindot.runap.model.TipoDireccion;
import com.bindot.runap.service.dto.TipoDireccionDTO;

/**
 * Mapper for Avatar Entity and DTO
 * 
 * @author Cesar Zamorano
 *
 */
@Mapper(componentModel = "spring", uses = {})
public interface TipoDireccionMapper extends EntityMapper<TipoDireccionDTO, TipoDireccion> {

	default TipoDireccion fromLong(Long value) {
		TipoDireccion entity= new TipoDireccion();
		entity.setId(value);
		return entity;
	}
}
