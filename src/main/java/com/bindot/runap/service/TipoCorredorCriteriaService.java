/**
 * 
 */
package com.bindot.runap.service;

import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;

import com.bindot.runap.model.TipoCorredor;
import com.bindot.runap.repository.BaseRepository;
import com.bindot.runap.service.dto.TipoCorredorCriteria;
import com.bindot.runap.service.dto.TipoCorredorDTO;
import com.bindot.runap.service.mapper.EntityMapper;
import com.bindot.runap.service.specification.TipoCorredorSpecification;

/**
 * @author Cesar Zamorano
 *
 */
public class TipoCorredorCriteriaService
		extends BaseCriteriaService<TipoCorredor, TipoCorredorDTO, TipoCorredorCriteria> {

	/**
	 * @param repository
	 * @param mapper
	 */
	public TipoCorredorCriteriaService(BaseRepository<TipoCorredor> repository,
			EntityMapper<TipoCorredorDTO, TipoCorredor> mapper) {
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
	Specification<TipoCorredor> createSpecification(TipoCorredorCriteria criteria) {
		Specification<TipoCorredor> specification = Specification.where(null);
		specification = Optional.ofNullable(criteria).map(TipoCorredorCriteria::getDescripcion)
				.map(TipoCorredorSpecification::likeToDescripcion).map(specification::and).orElse(specification);
		specification = Optional.ofNullable(criteria).map(TipoCorredorCriteria::getEnabled)
				.map(TipoCorredorSpecification::equalToEnabled).map(specification::and).orElse(specification);
		return specification;
	}

}