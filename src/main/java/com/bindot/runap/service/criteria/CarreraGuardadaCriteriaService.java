/**
 * 
 */
package com.bindot.runap.service.criteria;

import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bindot.runap.model.CarreraGuardada;
import com.bindot.runap.repository.CarreraGuardadaRepository;
import com.bindot.runap.service.dto.CarreraGuardadaCriteria;
import com.bindot.runap.service.dto.CarreraGuardadaDTO;
import com.bindot.runap.service.mapper.EntityMapper;
import com.bindot.runap.service.specification.CarreraGuardadaSpecification;

/**
 * @author Cesar Zamorano
 *
 */
@Service
@Transactional(readOnly = true)
public class CarreraGuardadaCriteriaService
		extends BaseCriteriaService<CarreraGuardada, CarreraGuardadaDTO, CarreraGuardadaCriteria> {

	/**
	 * @param repository
	 * @param mapper
	 */
	public CarreraGuardadaCriteriaService(CarreraGuardadaRepository repository,
			EntityMapper<CarreraGuardadaDTO, CarreraGuardada> mapper) {
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
	Specification<CarreraGuardada> createSpecification(CarreraGuardadaCriteria criteria) {
		Specification<CarreraGuardada> specification = Specification.where(null);
		specification = Optional.ofNullable(criteria).map(CarreraGuardadaCriteria::getInscripto)
				.map(CarreraGuardadaSpecification::equalToInscripto).map(specification::and).orElse(specification);
		specification = Optional.ofNullable(criteria).map(CarreraGuardadaCriteria::getEnabled)
				.map(CarreraGuardadaSpecification::equalToEnabled).map(specification::and).orElse(specification);
		return specification;
	}

}
