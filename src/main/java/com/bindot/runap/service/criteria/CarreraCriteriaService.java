package com.bindot.runap.service.criteria;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bindot.runap.model.Carrera;
import com.bindot.runap.repository.CarreraRepository;
import com.bindot.runap.service.dto.CarreraCriteria;
import com.bindot.runap.service.dto.CarreraDTO;
import com.bindot.runap.service.mapper.CarreraMapper;
import com.bindot.runap.service.specification.CarreraSpecification;

/**
 * @author Cesar Zamorano
 *
 */
@Service
@Transactional(readOnly = true)
public class CarreraCriteriaService {

	private final Logger log = LoggerFactory.getLogger(CarreraCriteriaService.class);

	private final CarreraRepository repository;

	private final CarreraMapper mapper;

	public CarreraCriteriaService(CarreraRepository repository, CarreraMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	/**
	 * Return a {@link Page} of {@link CarreraDTO} which matches the criteria from
	 * the database
	 *
	 * @param criteria
	 *            The object which holds all the filters, which the entities should
	 *            match.
	 * @param pageable
	 *            The page, which should be returned.
	 * @return the matching entities
	 */
	@Transactional(readOnly = true)
	public Page<CarreraDTO> findAllByCriteria(CarreraCriteria criteria, Pageable pageable) {
		log.debug("find by criteria : {}, page: {}", criteria, pageable);
		final Specification<Carrera> specification = createSpecification(criteria);
		return repository.findAll(specification, pageable).map(mapper::toDto);
	}

	/**
	 * Function to convert Criteria to a {@link Specification}
	 */
	private Specification<Carrera> createSpecification(CarreraCriteria criteria) {
		Specification<Carrera> specification = Specification.where(null);
		specification = Optional.ofNullable(criteria).map(CarreraCriteria::getNombre)
				.map(CarreraSpecification::likeToNombre).map(specification::and).orElse(specification);
		specification = Optional.ofNullable(criteria).map(CarreraCriteria::getDescripcion)
				.map(CarreraSpecification::likeToDescripcion).map(specification::and).orElse(specification);
		specification = Optional.ofNullable(criteria).map(CarreraCriteria::getFechaInicio)
				.map(CarreraSpecification::greaterToFechaInicio).map(specification::and).orElse(specification);
		specification = Optional.ofNullable(criteria).map(CarreraCriteria::getFechaFin)
				.map(CarreraSpecification::lessToFechaFin).map(specification::and).orElse(specification);
		specification = Optional.ofNullable(criteria).map(CarreraCriteria::getFechaInicioInscripcion)
				.map(CarreraSpecification::equalToFechaInicioInscripcion).map(specification::and).orElse(specification);
		specification = Optional.ofNullable(criteria).map(CarreraCriteria::getEnabled)
				.map(CarreraSpecification::equalToEnabled).map(specification::and).orElse(specification);
		return specification;

	}
}
