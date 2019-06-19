package com.bindot.runap.service.mapper;

import org.mapstruct.Mapper;

import com.bindot.runap.model.CarreraGuardada;
import com.bindot.runap.service.dto.CarreraGuardadaDTO;

/**
 * Mapper for CarreraGuardada Entity and DTO
 * 
 * @author Cesar Zamorano
 *
 */
@Mapper(componentModel = "spring", uses = {CarreraMapper.class})
public interface CarreraGuardadaMapper extends EntityMapper<CarreraGuardadaDTO, CarreraGuardada> {

	default CarreraGuardada fromLong(Long value) {
		CarreraGuardada entity = new CarreraGuardada();
		entity.setId(value);
		return entity;
	}
}
