/**
 * 
 */
package com.bindot.runap.service;

import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;

import com.bindot.runap.model.TipoDireccion;
import com.bindot.runap.repository.BaseRepository;
import com.bindot.runap.service.dto.TipoDireccionCriteria;
import com.bindot.runap.service.dto.TipoDireccionDTO;
import com.bindot.runap.service.mapper.EntityMapper;
import com.bindot.runap.service.specification.TipoDireccionSpecification;

/**
 * @author Cesar Zamorano
 *
 */
public class TipoDireccionCriteriaService extends BaseCriteriaService<TipoDireccion, TipoDireccionDTO, TipoDireccionCriteria> {

	/**
	 * @param repository
	 * @param mapper
	 */
	public TipoDireccionCriteriaService(BaseRepository<TipoDireccion> repository, EntityMapper<TipoDireccionDTO, TipoDireccion> mapper) {
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
	Specification<TipoDireccion> createSpecification(TipoDireccionCriteria criteria) {
		Specification<TipoDireccion> specification = Specification.where(null);
		specification = Optional.ofNullable(criteria).map(TipoDireccionCriteria::getDescripcion)
				.map(TipoDireccionSpecification::likeToDescripcion).map(specification::and).orElse(specification);
		specification = Optional.ofNullable(criteria).map(TipoDireccionCriteria::getEnabled)
				.map(TipoDireccionSpecification::equalToEnabled).map(specification::and).orElse(specification);
		return specification;
	}

}