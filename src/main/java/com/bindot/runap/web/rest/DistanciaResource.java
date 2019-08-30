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

import com.bindot.runap.model.Distancia;
import com.bindot.runap.service.BaseService;
import com.bindot.runap.service.criteria.DistanciaCriteriaService;
import com.bindot.runap.service.dto.DistanciaCriteria;
import com.bindot.runap.service.dto.DistanciaDTO;
import com.bindot.runap.web.rest.error.BadRequestAlertException;
import com.bindot.runap.web.rest.util.HeaderUtil;
import com.bindot.runap.web.rest.util.PaginationUtil;
import com.bindot.runap.web.rest.util.ResponseUtil;

import springfox.documentation.annotations.ApiIgnore;

/**
 * REST controller for managing Distancia.
 * 
 * @author Cesar Zamorano
 *
 */
@RestController
@RequestMapping("/api")
public class DistanciaResource {

	private final Logger log = LoggerFactory.getLogger(DistanciaResource.class);

	private static final String ENTITY_NAME = "distancia";

	private final BaseService<Distancia, DistanciaDTO> service;

	private final DistanciaCriteriaService criteriaService;

	public DistanciaResource(BaseService<Distancia, DistanciaDTO> distanciaService,
			DistanciaCriteriaService distanciaCriteriaService) {
		this.service = distanciaService;
		this.criteriaService = distanciaCriteriaService;
	}

	/**
	 * POST /distancia : Create a new distancia.
	 *
	 * @param distanciaDTO
	 *            the distanciaDTO to create
	 * @return the ResponseEntity with status 201 (Created) and with body the new
	 *         distanciaDTO, or with status 400 (Bad Request) if the distancia has
	 *         already an ID
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PostMapping("/distancia")
	public ResponseEntity<DistanciaDTO> createDistancia(@Valid @RequestBody DistanciaDTO distanciaDTO)
			throws URISyntaxException {
		log.debug("REST request to save Distancia : {}", distanciaDTO);
		if (distanciaDTO.getId() != null) {
			throw new BadRequestAlertException("A new distancia cannot already have an ID", ENTITY_NAME, "idexists");
		}
		if (distanciaDTO.getEnabled() == null) {
			distanciaDTO.setEnabled(true);
		}
		DistanciaDTO result = service.save(distanciaDTO);
		return ResponseEntity.created(new URI("/api/distancia/" + result.getId()))
				.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString())).body(result);
	}

	/**
	 * PUT /distancia : Updates an existing distancia.
	 *
	 * @param distanciaDTO
	 *            the distanciaDTO to update
	 * @return the ResponseEntity with status 200 (OK) and with body the updated
	 *         distanciaDTO, or with status 400 (Bad Request) if the distanciaDTO is
	 *         not valid, or with status 500 (Internal Server Error) if the
	 *         distanciaDTO couldn't be updated
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PutMapping("/distancia")
	public ResponseEntity<DistanciaDTO> updateDistancia(@Valid @RequestBody DistanciaDTO distanciaDTO) {
		log.debug("REST request to update Distancia : {}", distanciaDTO);
		if (distanciaDTO.getId() == null) {
			throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
		}
		DistanciaDTO result = service.save(distanciaDTO);
		return ResponseEntity.ok()
				.headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, distanciaDTO.getId().toString())).body(result);
	}

	/**
	 * GET /distancia : get all the distancias.
	 *
	 * @param pageable
	 *            the pagination information
	 * @return the ResponseEntity with status 200 (OK) and the list of distancias in
	 *         body
	 */
	@ApiPageable
	@GetMapping("/distancia")
	public ResponseEntity<List<DistanciaDTO>> getAllDistancias(@ApiIgnore @NonNull Pageable pageable) {
		String message = "REST request to get a page of Distancias";
		log.debug(message);
		Page<DistanciaDTO> page = service.findAll(pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/distancia");
		return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	}

	/**
	 * GET /distancia/search : get all the distancias.
	 *
	 * @param pageable
	 *            the pagination information
	 * @param criteria
	 *            the criterias which the requested entities should match
	 * @return the ResponseEntity with status 200 (OK) and the list of distancias in
	 *         body
	 */
	@ApiPageable
	@GetMapping("/distancia/search")
	public ResponseEntity<List<DistanciaDTO>> getAllDistancias(DistanciaCriteria criteria,
			@ApiIgnore @NonNull Pageable pageable) {
		log.debug("REST request to get Distancias by criteria: {}", criteria);
		Page<DistanciaDTO> page = criteriaService.findAllByCriteria(criteria, pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/distancia/search");
		return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	}

	/**
	 * GET /distancia/:id : get the "id" distancia.
	 *
	 * @param id
	 *            the id of the distanciaDTO to retrieve
	 * @return the ResponseEntity with status 200 (OK) and with body the
	 *         distanciaDTO, or with status 404 (Not Found)
	 */
	@GetMapping("/distancia/{id}")
	public ResponseEntity<DistanciaDTO> getDistancia(@PathVariable Long id) {
		log.debug("REST request to get Distancia : {}", id);
		Optional<DistanciaDTO> distanciaDTO = service.findOne(id);
		return ResponseUtil.wrapOrNotFound(distanciaDTO);
	}

	/**
	 * DELETE /distancia/:id : delete the "id" distancia.
	 *
	 * @param id
	 *            the id of the distanciaDTO to delete
	 * @return the ResponseEntity with status 200 (OK)
	 */
	@DeleteMapping("/distancia/{id}")
	public ResponseEntity<Void> deleteDistancia(@PathVariable Long id) {
		log.debug("REST request to delete Distancia : {}", id);
		service.delete(id);
		return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
	}
}
