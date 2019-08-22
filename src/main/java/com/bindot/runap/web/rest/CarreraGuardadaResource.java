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
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bindot.runap.model.CarreraGuardada;
import com.bindot.runap.service.BaseService;
import com.bindot.runap.service.CarreraGuardadaCriteriaService;
import com.bindot.runap.service.dto.CarreraGuardadaCriteria;
import com.bindot.runap.service.dto.CarreraGuardadaDTO;
import com.bindot.runap.web.rest.error.BadRequestAlertException;
import com.bindot.runap.web.rest.util.HeaderUtil;
import com.bindot.runap.web.rest.util.PaginationUtil;
import com.bindot.runap.web.rest.util.ResponseUtil;

import springfox.documentation.annotations.ApiIgnore;

/**
 * REST controller for managing CarreraGuardada.
 * 
 * @author Cesar Zamorano
 *
 */
@RestController
@RequestMapping("/api")
public class CarreraGuardadaResource {

	private final Logger log = LoggerFactory.getLogger(CarreraGuardadaResource.class);

	private static final String ENTITY_NAME = "carreraGuardada";

	private final BaseService<CarreraGuardada, CarreraGuardadaDTO> service;

	private final CarreraGuardadaCriteriaService criteriaService;

	public CarreraGuardadaResource(BaseService<CarreraGuardada, CarreraGuardadaDTO> carreraGuardadaService,
			CarreraGuardadaCriteriaService carreraGuardadaCriteriaService) {
		this.service = carreraGuardadaService;
		this.criteriaService = carreraGuardadaCriteriaService;
	}

	/**
	 * POST /carreraGuardada : Create a new carreraGuardada.
	 *
	 * @param carreraGuardadaDTO
	 *            the carreraGuardadaDTO to create
	 * @return the ResponseEntity with status 201 (Created) and with body the new
	 *         carreraGuardadaDTO, or with status 400 (Bad Request) if the
	 *         carreraGuardada has already an ID
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PostMapping("/carreraGuardada")
	public ResponseEntity<CarreraGuardadaDTO> createCarreraGuardada(
			@Valid @RequestBody CarreraGuardadaDTO carreraGuardadaDTO) throws URISyntaxException {
		log.debug("REST request to save CarreraGuardada : {}", carreraGuardadaDTO);
		if (carreraGuardadaDTO.getId() != null) {
			throw new BadRequestAlertException("A new carreraGuardada cannot already have an ID", ENTITY_NAME,
					"idexists");
		}
		if (carreraGuardadaDTO.getEnabled() == null) {
			carreraGuardadaDTO.setEnabled(true);
		}
		CarreraGuardadaDTO result = service.save(carreraGuardadaDTO);
		return ResponseEntity.created(new URI("/api/carreraGuardada/" + result.getId()))
				.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString())).body(result);
	}

	/**
	 * PUT /carreraGuardada : Updates an existing carreraGuardada.
	 *
	 * @param carreraGuardadaDTO
	 *            the carreraGuardadaDTO to update
	 * @return the ResponseEntity with status 200 (OK) and with body the updated
	 *         carreraGuardadaDTO, or with status 400 (Bad Request) if the
	 *         carreraGuardadaDTO is not valid, or with status 500 (Internal Server
	 *         Error) if the carreraGuardadaDTO couldn't be updated
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PutMapping("/carreraGuardada")
	public ResponseEntity<CarreraGuardadaDTO> updateCarreraGuardada(
			@Valid @RequestBody CarreraGuardadaDTO carreraGuardadaDTO) {
		log.debug("REST request to update CarreraGuardada : {}", carreraGuardadaDTO);
		if (carreraGuardadaDTO.getId() == null) {
			throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
		}
		CarreraGuardadaDTO result = service.save(carreraGuardadaDTO);
		return ResponseEntity.ok()
				.headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, carreraGuardadaDTO.getId().toString()))
				.body(result);
	}

	/**
	 * GET /carreraGuardada : get all the carreraGuardadas.
	 *
	 * @param pageable
	 *            the pagination information
	 * @return the ResponseEntity with status 200 (OK) and the list of
	 *         carreraGuardadas in body
	 */
	@ApiPageable
	@GetMapping("/carreraGuardada")
	public ResponseEntity<List<CarreraGuardadaDTO>> getAllCarreraGuardadas(@ApiIgnore @NonNull Pageable pageable) {
		String message = "REST request to get a page of CarreraGuardadas";
		log.debug(message);
		Page<CarreraGuardadaDTO> page = service.findAll(pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/carreraGuardada");
		return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	}

	/**
	 * GET /carreraGuardada/search : get all the carreraGuardadas.
	 *
	 * @param pageable
	 *            the pagination information
	 * @param criteria
	 *            the criterias which the requested entities should match
	 * @return the ResponseEntity with status 200 (OK) and the list of
	 *         carreraGuardadas in body
	 */
	@ApiPageable
	@GetMapping("/carreraGuardada/search")
	public ResponseEntity<List<CarreraGuardadaDTO>> getAllCarreraGuardadas(CarreraGuardadaCriteria criteria,
			@ApiIgnore @NonNull Pageable pageable) {
		log.debug("REST request to get CarreraGuardadas by criteria: {}", criteria);
		Page<CarreraGuardadaDTO> page = criteriaService.findAllByCriteria(criteria, pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/carreraGuardada/search");
		return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	}

	/**
	 * GET /carreraGuardada/:id : get the "id" carreraGuardada.
	 *
	 * @param id
	 *            the id of the carreraGuardadaDTO to retrieve
	 * @return the ResponseEntity with status 200 (OK) and with body the
	 *         carreraGuardadaDTO, or with status 404 (Not Found)
	 */
	@GetMapping("/carreraGuardada/{id}")
	public ResponseEntity<CarreraGuardadaDTO> getCarreraGuardada(@PathVariable Long id) {
		log.debug("REST request to get CarreraGuardada : {}", id);
		Optional<CarreraGuardadaDTO> carreraGuardadaDTO = service.findOne(id);
		return ResponseUtil.wrapOrNotFound(carreraGuardadaDTO);
	}

	/**
	 * DELETE /carreraGuardada/:id : delete the "id" carreraGuardada.
	 *
	 * @param id
	 *            the id of the carreraGuardadaDTO to delete
	 * @return the ResponseEntity with status 200 (OK)
	 */
	@DeleteMapping("/carreraGuardada/{id}")
	public ResponseEntity<Void> deleteCarreraGuardada(@PathVariable Long id) {
		log.debug("REST request to delete CarreraGuardada : {}", id);
		service.delete(id);
		return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
	}
}
