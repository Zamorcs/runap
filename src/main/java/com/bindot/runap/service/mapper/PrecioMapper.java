package com.bindot.runap.service.mapper;

import org.mapstruct.Mapper;

import com.bindot.runap.model.Precio;
import com.bindot.runap.service.dto.PrecioDTO;

/**
 * Mapper for Precio Entity and DTO
 * 
 * @author Cesar Zamorano
 *
 */
@Mapper(componentModel = "spring", uses = {})
public interface PrecioMapper extends EntityMapper<PrecioDTO, Precio> {

	default Precio fromLong(Long value) {
		Precio entity= new Precio();
		entity.setId(value);
		return entity;
	}
}
