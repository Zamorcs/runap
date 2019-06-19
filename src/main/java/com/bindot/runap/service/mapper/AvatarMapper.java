package com.bindot.runap.service.mapper;

import org.mapstruct.Mapper;

import com.bindot.runap.model.Avatar;
import com.bindot.runap.service.dto.AvatarDTO;

/**
 * Mapper for Avatar Entity and DTO
 * 
 * @author Cesar Zamorano
 *
 */
@Mapper(componentModel = "spring", uses = {})
public interface AvatarMapper extends EntityMapper<AvatarDTO, Avatar> {
	
	default Avatar fromLong(Long value) {
		Avatar entity= new Avatar();
		entity.setId(value);
		return entity;
	}
}
