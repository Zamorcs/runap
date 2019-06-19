package com.bindot.runap.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.bindot.runap.model.Corredor;
import com.bindot.runap.service.dto.CorredorDTO;

/**
 * Mapper for Corredor Entity and DTO
 * 
 * @author Cesar Zamorano
 *
 */
@Mapper(componentModel = "spring", uses = { TipoCorredorMapper.class, SexoMapper.class, AvatarMapper.class })
public interface CorredorMapper extends EntityMapper<CorredorDTO, Corredor> {
	
	@Override
	@Mapping(source = "tipoCorredor.id", target = "tipoCorredorId")
	@Mapping(source = "sexo.id", target = "sexoId")
	@Mapping(source = "avatar.id", target = "avatarId")
	@Mapping(source = "friendlist", target = "friendlistId")
	@Mapping(source = "runningTeam", target = "runningTeamId")
	CorredorDTO toDto(Corredor corredor);

	@Override
	@Mapping(source = "tipoCorredorId", target = "tipoCorredor")
	@Mapping(source = "sexoId", target = "sexo")
	@Mapping(source = "avatarId", target = "avatar")
	@Mapping(source = "friendlistId", target = "friendlist")
	@Mapping(source = "runningTeamId", target = "runningTeam")
	Corredor toEntity(CorredorDTO corredorDTO);
	
	default Corredor fromLong(Long value) {
		Corredor entity= new Corredor();
		entity.setId(value);
		return entity;
	}
}
