package com.bindot.runap.service.mapper;

import org.mapstruct.Mapper;

import com.bindot.runap.model.Documentacion;
import com.bindot.runap.service.dto.DocumentacionDTO;

/**
 * Mapper for Documentacion Entity and DTO
 * 
 * @author Cesar Zamorano
 *
 */
@Mapper(componentModel = "spring", uses = {})
public interface DocumentacionMapper extends EntityMapper<DocumentacionDTO, Documentacion> {

	default Documentacion fromLong(Long value) {
		Documentacion entity= new Documentacion();
		entity.setId(value);
		return entity;
	}
}
