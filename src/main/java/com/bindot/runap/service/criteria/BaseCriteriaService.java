package com.bindot.runap.service.criteria;

import java.io.Serializable;

import javax.persistence.Entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import com.bindot.runap.repository.BaseRepository;
import com.bindot.runap.service.mapper.EntityMapper;


public abstract class BaseCriteriaService<E extends Serializable, D, C> {

	private final Logger log = LoggerFactory.getLogger(BaseCriteriaService.class);

	private final BaseRepository<E> repository;

	private final EntityMapper<D, E> mapper;

	public BaseCriteriaService(BaseRepository<E> repository, EntityMapper<D, E> mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	/**
	 * Return a {@link Page} of {@link Entity} which matches the criteria from the
	 * database
	 *
	 * @param criteria
	 *            The object which holds all the filters, which the entities should
	 *            match.
	 * @param pageable
	 *            The page, which should be returned.
	 * @return the matching entities
	 */
	@Transactional(readOnly = true)
	public Page<D> findAllByCriteria(C criteria, Pageable pageable) {
		log.debug("find by criteria : {}, page: {}", criteria, pageable);
		final Specification<E> specification = createSpecification(criteria);
		return repository.findAll(specification, pageable).map(mapper::toDto);
	}

	/**
	 * Function to convert Criteria to a {@link Specification}
	 */
	abstract Specification<E> createSpecification(C criteria);
}
