/**
 * 
 */
package com.bindot.runap.service.criteria;

import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bindot.runap.model.Precio;
import com.bindot.runap.repository.PrecioRepository;
import com.bindot.runap.service.dto.PrecioCriteria;
import com.bindot.runap.service.dto.PrecioDTO;
import com.bindot.runap.service.mapper.EntityMapper;
import com.bindot.runap.service.specification.PrecioSpecification;

/**
 * @author Cesar Zamorano
 *
 */
@Service
@Transactional(readOnly = true)
public class PrecioCriteriaService extends BaseCriteriaService<Precio, PrecioDTO, PrecioCriteria> {

	/**
	 * @param repository
	 * @param mapper
	 */
	public PrecioCriteriaService(PrecioRepository repository, EntityMapper<PrecioDTO, Precio> mapper) {
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
	Specification<Precio> createSpecification(PrecioCriteria criteria) {
		Specification<Precio> specification = Specification.where(null);
		specification = Optional.ofNullable(criteria).map(PrecioCriteria::getDescripcion)
				.map(PrecioSpecification::likeToDescripcion).map(specification::and).orElse(specification);
		specification = Optional.ofNullable(criteria).map(PrecioCriteria::getFechaInicio)
				.map(PrecioSpecification::greaterToFechaInicio).map(specification::and).orElse(specification);
		specification = Optional.ofNullable(criteria).map(PrecioCriteria::getFechaFin)
				.map(PrecioSpecification::lessToFechaFin).map(specification::and).orElse(specification);
		specification = Optional.ofNullable(criteria).map(PrecioCriteria::getMoneda)
				.map(PrecioSpecification::likeToMoneda).map(specification::and).orElse(specification);
		specification = Optional.ofNullable(criteria).map(PrecioCriteria::getMonto)
				.map(PrecioSpecification::equalToMonto).map(specification::and).orElse(specification);
		specification = Optional.ofNullable(criteria).map(PrecioCriteria::getEnabled)
				.map(PrecioSpecification::equalToEnabled).map(specification::and).orElse(specification);
		return specification;
	}

}
