package com.bindot.runap.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bindot.runap.service.CarreraCriteriaService;
import com.bindot.runap.service.CarreraService;
import com.bindot.runap.service.dto.CarreraCriteria;
import com.bindot.runap.service.dto.CarreraDTO;
import com.bindot.runap.web.rest.error.BadRequestAlertException;
import com.bindot.runap.web.rest.util.HeaderUtil;
import com.bindot.runap.web.rest.util.PaginationUtil;
import com.bindot.runap.web.rest.util.ResponseUtil;

/**
 * REST controller for managing Carrera.
 * 
 * @author Cesar Zamorano
 *
 */
@RestController
@RequestMapping("/api")
public class CarreraResource {

	private final Logger log = LoggerFactory.getLogger(CarreraResource.class);

	private static final String ENTITY_NAME = "carrera";

	private final CarreraService service;

	private final CarreraCriteriaService criteriaService;

	public CarreraResource(CarreraService carreraService, CarreraCriteriaService carreraCriteriaService) {
		this.service = carreraService;
		this.criteriaService = carreraCriteriaService;
	}

	/**
	 * POST /carrera : Create a new carrera.
	 *
	 * @param carreraDTO
	 *            the carreraDTO to create
	 * @return the ResponseEntity with status 201 (Created) and with body the new
	 *         carreraDTO, or with status 400 (Bad Request) if the carrera has
	 *         already an ID
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PostMapping("/carrera")
	public ResponseEntity<CarreraDTO> createCarrera(@Valid @RequestBody CarreraDTO carreraDTO)
			throws URISyntaxException {
		log.debug("REST request to save Carrera : {}", carreraDTO);
		if (carreraDTO.getId() != null) {
			throw new BadRequestAlertException("A new carrera cannot already have an ID", ENTITY_NAME, "idexists");
		}
		if (carreraDTO.getEnabled() == null) {
			carreraDTO.setEnabled(true);
		}
		CarreraDTO result = service.save(carreraDTO);
		return ResponseEntity.created(new URI("/api/carrera/" + result.getId()))
				.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
				.body(result);
	}

	/**
	 * PUT /carrera : Updates an existing carrera.
	 *
	 * @param carreraDTO
	 *            the carreraDTO to update
	 * @return the ResponseEntity with status 200 (OK) and with body the updated
	 *         carreraDTO, or with status 400 (Bad Request) if the carreraDTO is not
	 *         valid, or with status 500 (Internal Server Error) if the carreraDTO
	 *         couldn't be updated
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PutMapping("/carrera")
	public ResponseEntity<CarreraDTO> updateCarrera(@Valid @RequestBody CarreraDTO carreraDTO) {
		log.debug("REST request to update Carrera : {}", carreraDTO);
		if (carreraDTO.getId() == null) {
			throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
		}
		CarreraDTO result = service.save(carreraDTO);
		return ResponseEntity.ok()
				.headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, carreraDTO.getId().toString()))
				.body(result);
	}

	/**
	 * GET /carrera : get all the carreras.
	 *
	 * @param pageable
	 *            the pagination information
	 * @return the ResponseEntity with status 200 (OK) and the list of carreras in
	 *         body
	 */
	@GetMapping("/carrera")
	public ResponseEntity<List<CarreraDTO>> getAllCarreras(Pageable pageable) {
		String message = "REST request to get a page of Carreras";
		log.debug(message);
		Page<CarreraDTO> page = service.findAll(pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/carrera");
		return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	}

	/**
	 * GET /carrera/search : get all the carreras.
	 *
	 * @param pageable
	 *            the pagination information
	 * @param criteria
	 *            the criterias which the requested entities should match
	 * @return the ResponseEntity with status 200 (OK) and the list of carreras in
	 *         body
	 */
	@GetMapping("/carrera/search")
	public ResponseEntity<List<CarreraDTO>> getAllCarreras(CarreraCriteria criteria, Pageable pageable) {
		log.debug("REST request to get Carreras by criteria: {}", criteria);
		Page<CarreraDTO> page = criteriaService.findAllByCriteria(criteria, pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/carrera/search");
		return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	}

	/**
	 * GET /carrera/:id : get the "id" carrera.
	 *
	 * @param id
	 *            the id of the carreraDTO to retrieve
	 * @return the ResponseEntity with status 200 (OK) and with body the carreraDTO,
	 *         or with status 404 (Not Found)
	 */
	@GetMapping("/carrera/{id}")
	public ResponseEntity<CarreraDTO> getCarrera(@PathVariable Long id) {
		log.debug("REST request to get Carrera : {}", id);
		Optional<CarreraDTO> carreraDTO = service.findOne(id);
		return ResponseUtil.wrapOrNotFound(carreraDTO);
	}

	/**
	 * DELETE /carrera/:id : delete the "id" carrera.
	 *
	 * @param id
	 *            the id of the carreraDTO to delete
	 * @return the ResponseEntity with status 200 (OK)
	 */
	@DeleteMapping("/carrera/{id}")
	public ResponseEntity<Void> deleteCarrera(@PathVariable Long id) {
		log.debug("REST request to delete Carrera : {}", id);
		service.delete(id);
		return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
	}
}
