package com.bindot.runap.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bindot.runap.repository.BaseRepository;
import com.bindot.runap.service.mapper.EntityMapper;

/**
 * Service Implementation for managing Entities.
 */
@Service
@Transactional
public abstract class BaseService<E, D> {

	private final Logger log = LoggerFactory.getLogger(BaseService.class);

	private final BaseRepository<E> repository;

	private final EntityMapper<D, E> mapper;

	public BaseService(BaseRepository<E> repository, EntityMapper<D, E> mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	/**
	 * Save an Entity.
	 *
	 * @param dto
	 *            the entity to save
	 * @return the persisted entity
	 */
	public D save(D dto) {
		log.debug("Request to save Entity : {}", dto);
		E entity = mapper.toEntity(dto);
		entity = repository.save(entity);
		return mapper.toDto(entity);
	}

	/**
	 * Get all the Entities.
	 *
	 * @param pageable
	 *            the pagination information
	 * @return the list of entities
	 */
	@Transactional(readOnly = true)
	public Page<D> findAll(Pageable pageable) {
		String message = "Request to get all Entities";
		log.debug(message);
		return repository.findAll(pageable).map(mapper::toDto);
	}

	/**
	 * Get one Entity by id.
	 *
	 * @param id
	 *            the id of the entity
	 * @return the entity
	 */
	@Transactional(readOnly = true)
	public Optional<D> findOne(Long id) {
		log.debug("Request to get Entity : {}", id);
		return repository.findById(id).map(mapper::toDto);
	}

	/**
	 * Delete the Entity by id.
	 *
	 * @param id
	 *            the id of the entity
	 */
	public void delete(Long id) {
		log.debug("Request to delete Entity : {}", id);
		repository.deleteById(id);
	}

}