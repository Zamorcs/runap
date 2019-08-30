/**
 * 
 */
package com.bindot.runap.service.criteria;

import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bindot.runap.model.Sexo;
import com.bindot.runap.repository.SexoRepository;
import com.bindot.runap.service.dto.SexoCriteria;
import com.bindot.runap.service.dto.SexoDTO;
import com.bindot.runap.service.mapper.EntityMapper;
import com.bindot.runap.service.specification.SexoSpecification;

/**
 * @author Cesar Zamorano
 *
 */
@Service
@Transactional(readOnly = true)
public class SexoCriteriaService extends BaseCriteriaService<Sexo, SexoDTO, SexoCriteria> {

	/**
	 * @param repository
	 * @param mapper
	 */
	public SexoCriteriaService(SexoRepository repository, EntityMapper<SexoDTO, Sexo> mapper) {
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
	Specification<Sexo> createSpecification(SexoCriteria criteria) {
		Specification<Sexo> specification = Specification.where(null);
		specification = Optional.ofNullable(criteria).map(SexoCriteria::getDescripcion)
				.map(SexoSpecification::likeToDescripcion).map(specification::and).orElse(specification);
		specification = Optional.ofNullable(criteria).map(SexoCriteria::getEnabled)
				.map(SexoSpecification::equalToEnabled).map(specification::and).orElse(specification);
		return specification;
	}

}