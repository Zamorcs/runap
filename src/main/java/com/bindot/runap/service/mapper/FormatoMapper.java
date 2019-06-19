package com.bindot.runap.service.mapper;

import org.mapstruct.Mapper;

import com.bindot.runap.model.Formato;
import com.bindot.runap.service.dto.FormatoDTO;

/**
 * Mapper for Formato Entity and DTO
 * 
 * @author Cesar Zamorano
 *
 */
@Mapper(componentModel = "spring", uses = {})
public interface FormatoMapper extends EntityMapper<FormatoDTO, Formato> {

	default Formato fromLong(Long value) {
		Formato entity= new Formato();
		entity.setId(value);
		return entity;
	}
}
