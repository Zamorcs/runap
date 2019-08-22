/**
 * 
 */
package com.bindot.runap.service;

import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;

import com.bindot.runap.model.Recorrido;
import com.bindot.runap.repository.BaseRepository;
import com.bindot.runap.service.dto.RecorridoCriteria;
import com.bindot.runap.service.dto.RecorridoDTO;
import com.bindot.runap.service.mapper.EntityMapper;
import com.bindot.runap.service.specification.RecorridoSpecification;

/**
 * @author Cesar Zamorano
 *
 */
public class RecorridoCriteriaService extends BaseCriteriaService<Recorrido, RecorridoDTO, RecorridoCriteria> {

	/**
	 * @param repository
	 * @param mapper
	 */
	public RecorridoCriteriaService(BaseRepository<Recorrido> repository,
			EntityMapper<RecorridoDTO, Recorrido> mapper) {
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
	Specification<Recorrido> createSpecification(RecorridoCriteria criteria) {
		Specification<Recorrido> specification = Specification.where(null);
		specification = Optional.ofNullable(criteria).map(RecorridoCriteria::getDescripcion)
				.map(RecorridoSpecification::likeToDescripcion).map(specification::and).orElse(specification);
		specification = Optional.ofNullable(criteria).map(RecorridoCriteria::getEnabled)
				.map(RecorridoSpecification::equalToEnabled).map(specification::and).orElse(specification);
		return specification;
	}

}
