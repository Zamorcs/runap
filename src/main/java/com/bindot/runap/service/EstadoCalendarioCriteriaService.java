/**
 * 
 */
package com.bindot.runap.service;

import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;

import com.bindot.runap.model.EstadoCalendario;
import com.bindot.runap.repository.BaseRepository;
import com.bindot.runap.service.dto.EstadoCalendarioCriteria;
import com.bindot.runap.service.dto.EstadoCalendarioDTO;
import com.bindot.runap.service.mapper.EntityMapper;
import com.bindot.runap.service.specification.EstadoCalendarioSpecification;

/**
 * @author Cesar Zamorano
 *
 */
public class EstadoCalendarioCriteriaService
		extends BaseCriteriaService<EstadoCalendario, EstadoCalendarioDTO, EstadoCalendarioCriteria> {

	/**
	 * @param repository
	 * @param mapper
	 */
	public EstadoCalendarioCriteriaService(BaseRepository<EstadoCalendario> repository,
			EntityMapper<EstadoCalendarioDTO, EstadoCalendario> mapper) {
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
	Specification<EstadoCalendario> createSpecification(EstadoCalendarioCriteria criteria) {
		Specification<EstadoCalendario> specification = Specification.where(null);
		specification = Optional.ofNullable(criteria).map(EstadoCalendarioCriteria::getDescripcion)
				.map(EstadoCalendarioSpecification::likeToDescripcion).map(specification::and).orElse(specification);
		specification = Optional.ofNullable(criteria).map(EstadoCalendarioCriteria::getEnabled)
				.map(EstadoCalendarioSpecification::equalToEnabled).map(specification::and).orElse(specification);
		return specification;
	}

}