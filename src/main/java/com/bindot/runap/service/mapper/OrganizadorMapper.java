package com.bindot.runap.service.mapper;

import org.mapstruct.Mapper;
import com.bindot.runap.model.Organizador;
import com.bindot.runap.service.dto.OrganizadorDTO;

/**
 * Mapper for Imagen Entity and DTO
 * 
 * @author Cesar Zamorano
 *
 */
@Mapper(componentModel = "spring", uses = {})
public interface OrganizadorMapper extends EntityMapper<OrganizadorDTO, Organizador> {

	default Organizador fromLong(Long value) {
		Organizador entity= new Organizador();
		entity.setId(value);
		return entity;
	}
}