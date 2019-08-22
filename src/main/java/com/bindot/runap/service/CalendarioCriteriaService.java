/**
 * 
 */
package com.bindot.runap.service;

import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;

import com.bindot.runap.model.Calendario;
import com.bindot.runap.repository.BaseRepository;
import com.bindot.runap.service.dto.CalendarioCriteria;
import com.bindot.runap.service.dto.CalendarioDTO;
import com.bindot.runap.service.mapper.EntityMapper;
import com.bindot.runap.service.specification.CalendarioSpecification;

/**
 * @author Cesar Zamorano
 *
 */
public class CalendarioCriteriaService extends BaseCriteriaService<Calendario, CalendarioDTO, CalendarioCriteria> {

	/**
	 * @param repository
	 * @param mapper
	 */
	public CalendarioCriteriaService(BaseRepository<Calendario> repository,
			EntityMapper<CalendarioDTO, Calendario> mapper) {
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
	Specification<Calendario> createSpecification(CalendarioCriteria criteria) {
		Specification<Calendario> specification = Specification.where(null);
		specification = Optional.ofNullable(criteria).map(CalendarioCriteria::getEnabled)
				.map(CalendarioSpecification::equalToEnabled).map(specification::and).orElse(specification);
		return specification;
	}

}