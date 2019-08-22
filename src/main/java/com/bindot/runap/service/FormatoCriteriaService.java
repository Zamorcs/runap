/**
 * 
 */
package com.bindot.runap.service;

import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;

import com.bindot.runap.model.Formato;
import com.bindot.runap.repository.BaseRepository;
import com.bindot.runap.service.dto.FormatoCriteria;
import com.bindot.runap.service.dto.FormatoDTO;
import com.bindot.runap.service.mapper.EntityMapper;
import com.bindot.runap.service.specification.FormatoSpecification;

/**
 * @author Cesar Zamorano
 *
 */
public class FormatoCriteriaService extends BaseCriteriaService<Formato, FormatoDTO, FormatoCriteria> {

	/**
	 * @param repository
	 * @param mapper
	 */
	public FormatoCriteriaService(BaseRepository<Formato> repository, EntityMapper<FormatoDTO, Formato> mapper) {
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
	Specification<Formato> createSpecification(FormatoCriteria criteria) {
		Specification<Formato> specification = Specification.where(null);
		specification = Optional.ofNullable(criteria).map(FormatoCriteria::getDescripcion)
				.map(FormatoSpecification::likeToDescripcion).map(specification::and).orElse(specification);
		specification = Optional.ofNullable(criteria).map(FormatoCriteria::getEnabled)
				.map(FormatoSpecification::equalToEnabled).map(specification::and).orElse(specification);
		return specification;
	}

}