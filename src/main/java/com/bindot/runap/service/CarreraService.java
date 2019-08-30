package com.bindot.runap.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bindot.runap.model.Carrera;
import com.bindot.runap.repository.CarreraRepository;
import com.bindot.runap.service.dto.CarreraDTO;
import com.bindot.runap.service.mapper.EntityMapper;

/**
 * Service Implementation for managing Carrera.
 */
@Service
@Transactional
public class CarreraService extends BaseService<Carrera, CarreraDTO> {
	
	public CarreraService(CarreraRepository repository, EntityMapper<CarreraDTO, Carrera> mapper) {
		super(repository, mapper);
	}

//
//	/**
//	 * Save a Carrera.
//	 *
//	 * @param CarreraDTO
//	 *            the entity to save
//	 * @return the persisted entity
//	 */
//	public CarreraDTO save(CarreraDTO scaleDTO) {
//		log.debug("Request to save Carrera : {}", scaleDTO);
//		Carrera scale = mapper.toEntity(scaleDTO);
//		scale = repository.save(scale);
//		return mapper.toDto(scale);
//	}
//
//	/**
//	 * Get all the Carreras.
//	 *
//	 * @param pageable
//	 *            the pagination information
//	 * @return the list of entities
//	 */
//	@Transactional(readOnly = true)
//	public Page<CarreraDTO> findAll(Pageable pageable) {
//		String message = "Request to get all Carreras";
//		log.debug(message);
//		return repository.findAll(pageable).map(mapper::toDto);
//	}
//
//	/**
//	 * Get one Carrera by id.
//	 *
//	 * @param id
//	 *            the id of the entity
//	 * @return the entity
//	 */
//	@Transactional(readOnly = true)
//	public Optional<CarreraDTO> findOne(Long id) {
//		log.debug("Request to get Carrera : {}", id);
//		return repository.findById(id).map(mapper::toDto);
//	}
//
//	/**
//	 * Delete the Carrera by id.
//	 *
//	 * @param id
//	 *            the id of the entity
//	 */
//	public void delete(Long id) {
//		log.debug("Request to delete Carrera : {}", id);
//		repository.deleteById(id);
//	}

}