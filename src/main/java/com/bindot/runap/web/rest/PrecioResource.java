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

import com.bindot.runap.model.Precio;
import com.bindot.runap.service.BaseService;
import com.bindot.runap.service.criteria.PrecioCriteriaService;
import com.bindot.runap.service.dto.PrecioCriteria;
import com.bindot.runap.service.dto.PrecioDTO;
import com.bindot.runap.web.rest.error.BadRequestAlertException;
import com.bindot.runap.web.rest.util.HeaderUtil;
import com.bindot.runap.web.rest.util.PaginationUtil;
import com.bindot.runap.web.rest.util.ResponseUtil;

import springfox.documentation.annotations.ApiIgnore;

/**
 * REST controller for managing Precio.
 * 
 * @author Cesar Zamorano
 *
 */
@RestController
@RequestMapping("/api")
public class PrecioResource {

	private final Logger log = LoggerFactory.getLogger(PrecioResource.class);

	private static final String ENTITY_NAME = "precio";

	private final BaseService<Precio, PrecioDTO> service;

	private final PrecioCriteriaService criteriaService;

	public PrecioResource(BaseService<Precio, PrecioDTO> precioService, PrecioCriteriaService precioCriteriaService) {
		this.service = precioService;
		this.criteriaService = precioCriteriaService;
	}

	/**
	 * POST /precio : Create a new precio.
	 *
	 * @param precioDTO
	 *            the precioDTO to create
	 * @return the ResponseEntity with status 201 (Created) and with body the new
	 *         precioDTO, or with status 400 (Bad Request) if the precio has already
	 *         an ID
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PostMapping("/precio")
	public ResponseEntity<PrecioDTO> createPrecio(@Valid @RequestBody PrecioDTO precioDTO) throws URISyntaxException {
		log.debug("REST request to save Precio : {}", precioDTO);
		if (precioDTO.getId() != null) {
			throw new BadRequestAlertException("A new precio cannot already have an ID", ENTITY_NAME, "idexists");
		}
		if (precioDTO.getEnabled() == null) {
			precioDTO.setEnabled(true);
		}
		PrecioDTO result = service.save(precioDTO);
		return ResponseEntity.created(new URI("/api/precio/" + result.getId()))
				.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString())).body(result);
	}

	/**
	 * PUT /precio : Updates an existing precio.
	 *
	 * @param precioDTO
	 *            the precioDTO to update
	 * @return the ResponseEntity with status 200 (OK) and with body the updated
	 *         precioDTO, or with status 400 (Bad Request) if the precioDTO is not
	 *         valid, or with status 500 (Internal Server Error) if the precioDTO
	 *         couldn't be updated
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PutMapping("/precio")
	public ResponseEntity<PrecioDTO> updatePrecio(@Valid @RequestBody PrecioDTO precioDTO) {
		log.debug("REST request to update Precio : {}", precioDTO);
		if (precioDTO.getId() == null) {
			throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
		}
		PrecioDTO result = service.save(precioDTO);
		return ResponseEntity.ok()
				.headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, precioDTO.getId().toString())).body(result);
	}

	/**
	 * GET /precio : get all the precios.
	 *
	 * @param pageable
	 *            the pagination information
	 * @return the ResponseEntity with status 200 (OK) and the list of precios in
	 *         body
	 */
	@ApiPageable
	@GetMapping("/precio")
	public ResponseEntity<List<PrecioDTO>> getAllPrecios(@ApiIgnore @NonNull Pageable pageable) {
		String message = "REST request to get a page of Precios";
		log.debug(message);
		Page<PrecioDTO> page = service.findAll(pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/precio");
		return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	}

	/**
	 * GET /precio/search : get all the precios.
	 *
	 * @param pageable
	 *            the pagination information
	 * @param criteria
	 *            the criterias which the requested entities should match
	 * @return the ResponseEntity with status 200 (OK) and the list of precios in
	 *         body
	 */
	@ApiPageable
	@GetMapping("/precio/search")
	public ResponseEntity<List<PrecioDTO>> getAllPrecios(PrecioCriteria criteria,
			@ApiIgnore @NonNull Pageable pageable) {
		log.debug("REST request to get Precios by criteria: {}", criteria);
		Page<PrecioDTO> page = criteriaService.findAllByCriteria(criteria, pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/precio/search");
		return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	}

	/**
	 * GET /precio/:id : get the "id" precio.
	 *
	 * @param id
	 *            the id of the precioDTO to retrieve
	 * @return the ResponseEntity with status 200 (OK) and with body the precioDTO,
	 *         or with status 404 (Not Found)
	 */
	@GetMapping("/precio/{id}")
	public ResponseEntity<PrecioDTO> getPrecio(@PathVariable Long id) {
		log.debug("REST request to get Precio : {}", id);
		Optional<PrecioDTO> precioDTO = service.findOne(id);
		return ResponseUtil.wrapOrNotFound(precioDTO);
	}

	/**
	 * DELETE /precio/:id : delete the "id" precio.
	 *
	 * @param id
	 *            the id of the precioDTO to delete
	 * @return the ResponseEntity with status 200 (OK)
	 */
	@DeleteMapping("/precio/{id}")
	public ResponseEntity<Void> deletePrecio(@PathVariable Long id) {
		log.debug("REST request to delete Precio : {}", id);
		service.delete(id);
		return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
	}
}
