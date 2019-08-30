package com.bindot.runap.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bindot.runap.model.Avatar;
import com.bindot.runap.repository.AvatarRepository;
import com.bindot.runap.service.dto.AvatarDTO;
import com.bindot.runap.service.mapper.EntityMapper;

@Service
@Transactional
public class AvatarService extends BaseService<Avatar, AvatarDTO> {

	public AvatarService(AvatarRepository repository, EntityMapper<AvatarDTO, Avatar> mapper) {
		super(repository, mapper);
	}


}
