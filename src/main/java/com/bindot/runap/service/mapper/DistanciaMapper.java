package com.bindot.runap.service.mapper;

import org.mapstruct.Mapper;

import com.bindot.runap.model.Distancia;
import com.bindot.runap.service.dto.DistanciaDTO;

/**
 * Mapper for Distancia Entity and DTO
 * 
 * @author Cesar Zamorano
 *
 */
@Mapper(componentModel = "spring", uses = {})
public interface DistanciaMapper extends EntityMapper<DistanciaDTO, Distancia> {

	default Distancia fromLong(Long value) {
		Distancia entity= new Distancia();
		entity.setId(value);
		return entity;
	}
}
