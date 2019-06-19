package com.bindot.runap.service.mapper;

import org.mapstruct.Mapper;

import com.bindot.runap.model.TipoCorredor;
import com.bindot.runap.service.dto.TipoCorredorDTO;

/**
 * Mapper for TipoCorredor Entity and DTO
 * 
 * @author Cesar Zamorano
 *
 */
@Mapper(componentModel = "spring", uses = {})
public interface TipoCorredorMapper extends EntityMapper<TipoCorredorDTO, TipoCorredor> {

	default TipoCorredor fromLong(Long value) {
		TipoCorredor entity= new TipoCorredor();
		entity.setId(value);
		return entity;
	}
}
