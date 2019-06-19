package com.bindot.runap.service.mapper;

import org.mapstruct.Mapper;

import com.bindot.runap.model.Recorrido;
import com.bindot.runap.service.dto.RecorridoDTO;

/**
 * Mapper for Recorrido Entity and DTO
 * 
 * @author Cesar Zamorano
 *
 */
@Mapper(componentModel = "spring", uses = {})
public interface RecorridoMapper extends EntityMapper<RecorridoDTO, Recorrido> {

	default Recorrido fromLong(Long value) {
		Recorrido entity= new Recorrido();
		entity.setId(value);
		return entity;
	}
}
