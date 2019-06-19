package com.bindot.runap.service.mapper;

import org.mapstruct.Mapper;

import com.bindot.runap.model.Sexo;
import com.bindot.runap.service.dto.SexoDTO;

/**
 * Mapper for Sexo Entity and DTO
 * 
 * @author Cesar Zamorano
 *
 */
@Mapper(componentModel = "spring", uses = {})
public interface SexoMapper extends EntityMapper<SexoDTO, Sexo> {
	
	default Sexo fromLong(Long value) {
		Sexo entity= new Sexo();
		entity.setId(value);
		return entity;
	}
}
