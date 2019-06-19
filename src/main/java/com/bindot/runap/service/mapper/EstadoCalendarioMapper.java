package com.bindot.runap.service.mapper;

import org.mapstruct.Mapper;

import com.bindot.runap.model.EstadoCalendario;
import com.bindot.runap.service.dto.EstadoCalendarioDTO;

/**
 * Mapper for EstadoCalendario Entity and DTO
 * 
 * @author Cesar Zamorano
 *
 */
@Mapper(componentModel = "spring", uses = {})
public interface EstadoCalendarioMapper extends EntityMapper<EstadoCalendarioDTO, EstadoCalendario> {

	default EstadoCalendario fromLong(Long value) {
		EstadoCalendario entity = new EstadoCalendario();
		entity.setId(value);
		return entity;
	}
}
