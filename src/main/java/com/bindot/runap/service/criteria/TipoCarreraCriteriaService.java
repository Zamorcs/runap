/**
 * 
 */
package com.bindot.runap.service.criteria;

import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bindot.runap.model.TipoCarrera;
import com.bindot.runap.repository.TipoCarreraRepository;
import com.bindot.runap.service.dto.TipoCarreraCriteria;
import com.bindot.runap.service.dto.TipoCarreraDTO;
import com.bindot.runap.service.mapper.EntityMapper;
import com.bindot.runap.service.specification.TipoCarreraSpecification;

/**
 * @author Cesar Zamorano
 *
 */
@Service
@Transactional(readOnly = true)
public class TipoCarreraCriteriaService extends BaseCriteriaService<TipoCarrera, TipoCarreraDTO, TipoCarreraCriteria> {

	/**
	 * @param repository
	 * @param mapper
	 */
	public TipoCarreraCriteriaService(TipoCarreraRepository repository, EntityMapper<TipoCarreraDTO, TipoCarrera> mapper) {
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
	Specification<TipoCarrera> createSpecification(TipoCarreraCriteria criteria) {
		Specification<TipoCarrera> specification = Specification.where(null);
		specification = Optional.ofNullable(criteria).map(TipoCarreraCriteria::getDescripcion)
				.map(TipoCarreraSpecification::likeToDescripcion).map(specification::and).orElse(specification);
		specification = Optional.ofNullable(criteria).map(TipoCarreraCriteria::getEnabled)
				.map(TipoCarreraSpecification::equalToEnabled).map(specification::and).orElse(specification);
		return specification;
	}

}