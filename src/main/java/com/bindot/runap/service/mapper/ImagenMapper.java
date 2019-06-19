package com.bindot.runap.service.mapper;

import org.mapstruct.Mapper;

import com.bindot.runap.model.Imagen;
import com.bindot.runap.service.dto.ImagenDTO;

/**
 * Mapper for Imagen Entity and DTO
 * 
 * @author Cesar Zamorano
 *
 */
@Mapper(componentModel = "spring", uses = {})
public interface ImagenMapper extends EntityMapper<ImagenDTO, Imagen> {

	default Imagen fromLong(Long value) {
		Imagen entity= new Imagen();
		entity.setId(value);
		return entity;
	}
}
