package com.bindot.runap.service;

import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;

import com.bindot.runap.model.Avatar;
import com.bindot.runap.repository.BaseRepository;
import com.bindot.runap.service.dto.AvatarCriteria;
import com.bindot.runap.service.dto.AvatarDTO;
import com.bindot.runap.service.mapper.EntityMapper;
import com.bindot.runap.service.specification.AvatarSpecification;

public class AvatarCriteriaService extends BaseCriteriaService<Avatar, AvatarDTO, AvatarCriteria> {

	public AvatarCriteriaService(BaseRepository<Avatar> repository, EntityMapper<AvatarDTO, Avatar> mapper) {
		super(repository, mapper);
	}

	@Override
	Specification<Avatar> createSpecification(AvatarCriteria criteria) {
		Specification<Avatar> specification = Specification.where(null);
		specification = Optional.ofNullable(criteria).map(AvatarCriteria::getDescripcion)
				.map(AvatarSpecification::likeToDescripcion).map(specification::and).orElse(specification);
		specification = Optional.ofNullable(criteria).map(AvatarCriteria::getEnabled)
				.map(AvatarSpecification::equalToEnabled).map(specification::and).orElse(specification);
		return specification;
	}

}
