/**
 * 
 */
package com.bindot.runap.service;

import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;

import com.bindot.runap.model.RecKit;
import com.bindot.runap.repository.BaseRepository;
import com.bindot.runap.service.dto.RecKitCriteria;
import com.bindot.runap.service.dto.RecKitDTO;
import com.bindot.runap.service.mapper.EntityMapper;
import com.bindot.runap.service.specification.RecKitSpecification;

/**
 * @author Cesar Zamorano
 *
 */
public class RecKitCriteriaService extends BaseCriteriaService<RecKit, RecKitDTO, RecKitCriteria> {

	/**
	 * @param repository
	 * @param mapper
	 */
	public RecKitCriteriaService(BaseRepository<RecKit> repository, EntityMapper<RecKitDTO, RecKit> mapper) {
		super(repository, mapper);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bindot.runap.service.BaseCriteriaService#createSpecification(java.lang.
	 * Object)
	 */
	@Override
	Specification<RecKit> createSpecification(RecKitCriteria criteria) {
		Specification<RecKit> specification = Specification.where(null);
		specification = Optional.ofNullable(criteria).map(RecKitCriteria::getDescripcion)
				.map(RecKitSpecification::likeToDescripcion).map(specification::and).orElse(specification);
		specification = Optional.ofNullable(criteria).map(RecKitCriteria::getFechaInicio)
				.map(RecKitSpecification::greaterToFechaInicio).map(specification::and).orElse(specification);
		specification = Optional.ofNullable(criteria).map(RecKitCriteria::getFechaFin)
				.map(RecKitSpecification::lessToFechaFin).map(specification::and).orElse(specification);
		specification = Optional.ofNullable(criteria).map(RecKitCriteria::getEnabled)
				.map(RecKitSpecification::equalToEnabled).map(specification::and).orElse(specification);
		return specification;
	}

}
