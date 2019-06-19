package com.bindot.runap.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.bindot.runap.model.RecKit;
import com.bindot.runap.service.dto.RecKitDTO;

/**
 * Mapper for RecKit Entity and DTO
 * 
 * @author Cesar Zamorano
 *
 */
@Mapper(componentModel = "spring", uses = {DocumentacionMapper.class, DireccionMapper.class})
public interface RecKitMapper extends EntityMapper<RecKitDTO, RecKit> {

	@Override
	@Mapping(source = "documentacionId", target = "documentacion")
	@Mapping(source = "direccionId", target = "direccion")
	RecKit toEntity(RecKitDTO dto);

	@Override
	@Mapping(source = "documentacion.id", target = "documentacionId")
	@Mapping(source = "direccion.id", target = "direccionId")
	RecKitDTO toDto(RecKit entity);
	
	default RecKit fromLong(Long value) {
		RecKit entity= new RecKit();
		entity.setId(value);
		return entity;
	}
}
