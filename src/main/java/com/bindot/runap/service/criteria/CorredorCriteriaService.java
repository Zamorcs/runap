/**
 * 
 */
package com.bindot.runap.service.criteria;

import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bindot.runap.model.Corredor;
import com.bindot.runap.repository.CorredorRepository;
import com.bindot.runap.service.dto.CorredorCriteria;
import com.bindot.runap.service.dto.CorredorDTO;
import com.bindot.runap.service.mapper.EntityMapper;
import com.bindot.runap.service.specification.CorredorSpecification;

/**
 * @author Cesar Zamorano
 *
 */
@Service
@Transactional(readOnly = true)
public class CorredorCriteriaService extends BaseCriteriaService<Corredor, CorredorDTO, CorredorCriteria> {

	/**
	 * @param repository
	 * @param mapper
	 */
	public CorredorCriteriaService(CorredorRepository repository, EntityMapper<CorredorDTO, Corredor> mapper) {
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
	Specification<Corredor> createSpecification(CorredorCriteria criteria) {
		Specification<Corredor> specification = Specification.where(null);
		specification = Optional.ofNullable(criteria).map(CorredorCriteria::getApellido)
				.map(CorredorSpecification::likeToApellido).map(specification::and).orElse(specification);
		specification = Optional.ofNullable(criteria).map(CorredorCriteria::getNombre)
				.map(CorredorSpecification::likeToNombre).map(specification::and).orElse(specification);
		specification = Optional.ofNullable(criteria).map(CorredorCriteria::getEmail)
				.map(CorredorSpecification::likeToEmail).map(specification::and).orElse(specification);
		specification = Optional.ofNullable(criteria).map(CorredorCriteria::getSocial)
				.map(CorredorSpecification::likeToSocial).map(specification::and).orElse(specification);
		specification = Optional.ofNullable(criteria).map(CorredorCriteria::getFechaNacimiento)
				.map(CorredorSpecification::greaterToFechaNacimiento).map(specification::and).orElse(specification);
		specification = Optional.ofNullable(criteria).map(CorredorCriteria::getFechaRegistro)
				.map(CorredorSpecification::greaterThanFechaRegistro).map(specification::and).orElse(specification);
		specification = Optional.ofNullable(criteria).map(CorredorCriteria::getFechaUltimoLogin)
				.map(CorredorSpecification::greaterThanFechaUltimoLogin).map(specification::and).orElse(specification);
		specification = Optional.ofNullable(criteria).map(CorredorCriteria::getEnabled)
				.map(CorredorSpecification::equalToEnabled).map(specification::and).orElse(specification);
		return specification;
	}

}