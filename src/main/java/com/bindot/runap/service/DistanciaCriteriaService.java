package com.bindot.runap.service;

import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;

import com.bindot.runap.model.Distancia;
import com.bindot.runap.repository.BaseRepository;
import com.bindot.runap.service.dto.DistanciaCriteria;
import com.bindot.runap.service.dto.DistanciaDTO;
import com.bindot.runap.service.mapper.EntityMapper;
import com.bindot.runap.service.specification.DistanciaSpecification;

/**
 * @author Cesar Zamorano
 *
 */
public class DistanciaCriteriaService extends BaseCriteriaService<Distancia, DistanciaDTO, DistanciaCriteria> {

	/**
	 * @param repository
	 * @param mapper
	 */
	public DistanciaCriteriaService(BaseRepository<Distancia> repository,
			EntityMapper<DistanciaDTO, Distancia> mapper) {
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
	Specification<Distancia> createSpecification(DistanciaCriteria criteria) {
		Specification<Distancia> specification = Specification.where(null);
		specification = Optional.ofNullable(criteria).map(DistanciaCriteria::getDescripcion)
				.map(DistanciaSpecification::likeToDescripcion).map(specification::and).orElse(specification);
		specification = Optional.ofNullable(criteria).map(DistanciaCriteria::getEnabled)
				.map(DistanciaSpecification::equalToEnabled).map(specification::and).orElse(specification);
		return specification;
	}

}
