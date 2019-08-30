package com.bindot.runap.service.criteria;

import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bindot.runap.model.Documentacion;
import com.bindot.runap.repository.DocumentacionRepository;
import com.bindot.runap.service.dto.DocumentacionCriteria;
import com.bindot.runap.service.dto.DocumentacionDTO;
import com.bindot.runap.service.mapper.EntityMapper;
import com.bindot.runap.service.specification.DocumentacionSpecification;

/**
 * @author Cesar Zamorano
 *
 */
@Service
@Transactional(readOnly = true)
public class DocumentacionCriteriaService
		extends BaseCriteriaService<Documentacion, DocumentacionDTO, DocumentacionCriteria> {

	/**
	 * @param repository
	 * @param mapper
	 */
	public DocumentacionCriteriaService(DocumentacionRepository repository,
			EntityMapper<DocumentacionDTO, Documentacion> mapper) {
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
	Specification<Documentacion> createSpecification(DocumentacionCriteria criteria) {
		Specification<Documentacion> specification = Specification.where(null);
		specification = Optional.ofNullable(criteria).map(DocumentacionCriteria::getDescripcion)
				.map(DocumentacionSpecification::likeToDescripcion).map(specification::and).orElse(specification);
		specification = Optional.ofNullable(criteria).map(DocumentacionCriteria::getObligatorio)
				.map(DocumentacionSpecification::equalToObligatorio).map(specification::and).orElse(specification);
		specification = Optional.ofNullable(criteria).map(DocumentacionCriteria::getEnabled)
				.map(DocumentacionSpecification::equalToEnabled).map(specification::and).orElse(specification);
		return specification;
	}

}
