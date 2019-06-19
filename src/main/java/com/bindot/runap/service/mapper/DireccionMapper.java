package com.bindot.runap.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.bindot.runap.model.Direccion;
import com.bindot.runap.service.dto.DireccionDTO;

/**
 * Mapper for Direccion Entity and DTO
 * 
 * @author Cesar Zamorano
 *
 */
@Mapper(componentModel = "spring", uses = {TipoDireccionMapper.class})
public interface DireccionMapper extends EntityMapper<DireccionDTO, Direccion> {

	@Override
	@Mapping(source = "tipoDireccion.id", target = "tipoDireccionId")
	DireccionDTO toDto(Direccion entity);

	@Override
	@Mapping(source = "tipoDireccionId", target = "tipoDireccion")
	Direccion toEntity(DireccionDTO dto);
	
	default Direccion fromLong(Long value) {
		Direccion entity= new Direccion();
		entity.setId(value);
		return entity;
	}
}
