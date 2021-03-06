/**
 * 
 */
package com.bindot.runap.service.criteria;

import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bindot.runap.model.Organizador;
import com.bindot.runap.repository.OrganizadorRepository;
import com.bindot.runap.service.dto.OrganizadorCriteria;
import com.bindot.runap.service.dto.OrganizadorDTO;
import com.bindot.runap.service.mapper.EntityMapper;
import com.bindot.runap.service.specification.OrganizadorSpecification;

/**
 * @author Cesar Zamorano
 *
 */
@Service
@Transactional(readOnly = true)
public class OrganizadorCriteriaService extends BaseCriteriaService<Organizador, OrganizadorDTO, OrganizadorCriteria> {

	/**
	 * @param repository
	 * @param mapper
	 */
	public OrganizadorCriteriaService(OrganizadorRepository repository,
			EntityMapper<OrganizadorDTO, Organizador> mapper) {
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
	Specification<Organizador> createSpecification(OrganizadorCriteria criteria) {
		Specification<Organizador> specification = Specification.where(null);
		specification = Optional.ofNullable(criteria).map(OrganizadorCriteria::getDescripcion)
				.map(OrganizadorSpecification::likeToDescripcion).map(specification::and).orElse(specification);
		specification = Optional.ofNullable(criteria).map(OrganizadorCriteria::getWebpage)
				.map(OrganizadorSpecification::likeToWebpage).map(specification::and).orElse(specification);
		specification = Optional.ofNullable(criteria).map(OrganizadorCriteria::getEnabled)
				.map(OrganizadorSpecification::equalToEnabled).map(specification::and).orElse(specification);
		return specification;
	}

}
