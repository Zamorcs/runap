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

import com.bindot.runap.model.TipoCarrera;
import com.bindot.runap.service.BaseService;
import com.bindot.runap.service.TipoCarreraCriteriaService;
import com.bindot.runap.service.dto.TipoCarreraCriteria;
import com.bindot.runap.service.dto.TipoCarreraDTO;
import com.bindot.runap.web.rest.error.BadRequestAlertException;
import com.bindot.runap.web.rest.util.HeaderUtil;
import com.bindot.runap.web.rest.util.PaginationUtil;
import com.bindot.runap.web.rest.util.ResponseUtil;

import springfox.documentation.annotations.ApiIgnore;

/**
 * REST controller for managing TipoCarrera.
 * 
 * @author Cesar Zamorano
 *
 */
@RestController
@RequestMapping("/api")
public class TipoCarreraResource {

	private final Logger log = LoggerFactory.getLogger(TipoCarreraResource.class);

	private static final String ENTITY_NAME = "tipoCarrera";

	private final BaseService<TipoCarrera, TipoCarreraDTO> service;

	private final TipoCarreraCriteriaService criteriaService;

	public TipoCarreraResource(BaseService<TipoCarrera, TipoCarreraDTO> tipoCarreraService,
			TipoCarreraCriteriaService tipoCarreraCriteriaService) {
		this.service = tipoCarreraService;
		this.criteriaService = tipoCarreraCriteriaService;
	}

	/**
	 * POST /tipoCarrera : Create a new tipoCarrera.
	 *
	 * @param tipoCarreraDTO
	 *            the tipoCarreraDTO to create
	 * @return the ResponseEntity with status 201 (Created) and with body the new
	 *         tipoCarreraDTO, or with status 400 (Bad Request) if the tipoCarrera
	 *         has already an ID
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PostMapping("/tipoCarrera")
	public ResponseEntity<TipoCarreraDTO> createTipoCarrera(@Valid @RequestBody TipoCarreraDTO tipoCarreraDTO)
			throws URISyntaxException {
		log.debug("REST request to save TipoCarrera : {}", tipoCarreraDTO);
		if (tipoCarreraDTO.getId() != null) {
			throw new BadRequestAlertException("A new tipoCarrera cannot already have an ID", ENTITY_NAME, "idexists");
		}
		if (tipoCarreraDTO.getEnabled() == null) {
			tipoCarreraDTO.setEnabled(true);
		}
		TipoCarreraDTO result = service.save(tipoCarreraDTO);
		return ResponseEntity.created(new URI("/api/tipoCarrera/" + result.getId()))
				.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString())).body(result);
	}

	/**
	 * PUT /tipoCarrera : Updates an existing tipoCarrera.
	 *
	 * @param tipoCarreraDTO
	 *            the tipoCarreraDTO to update
	 * @return the ResponseEntity with status 200 (OK) and with body the updated
	 *         tipoCarreraDTO, or with status 400 (Bad Request) if the
	 *         tipoCarreraDTO is not valid, or with status 500 (Internal Server
	 *         Error) if the tipoCarreraDTO couldn't be updated
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PutMapping("/tipoCarrera")
	public ResponseEntity<TipoCarreraDTO> updateTipoCarrera(@Valid @RequestBody TipoCarreraDTO tipoCarreraDTO) {
		log.debug("REST request to update TipoCarrera : {}", tipoCarreraDTO);
		if (tipoCarreraDTO.getId() == null) {
			throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
		}
		TipoCarreraDTO result = service.save(tipoCarreraDTO);
		return ResponseEntity.ok()
				.headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, tipoCarreraDTO.getId().toString()))
				.body(result);
	}

	/**
	 * GET /tipoCarrera : get all the tipoCarreras.
	 *
	 * @param pageable
	 *            the pagination information
	 * @return the ResponseEntity with status 200 (OK) and the list of tipoCarreras
	 *         in body
	 */
	@ApiPageable
	@GetMapping("/tipoCarrera")
	public ResponseEntity<List<TipoCarreraDTO>> getAllTipoCarreras(@ApiIgnore @NonNull Pageable pageable) {
		String message = "REST request to get a page of TipoCarreras";
		log.debug(message);
		Page<TipoCarreraDTO> page = service.findAll(pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/tipoCarrera");
		return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	}

	/**
	 * GET /tipoCarrera/search : get all the tipoCarreras.
	 *
	 * @param pageable
	 *            the pagination information
	 * @param criteria
	 *            the criterias which the requested entities should match
	 * @return the ResponseEntity with status 200 (OK) and the list of tipoCarreras
	 *         in body
	 */
	@ApiPageable
	@GetMapping("/tipoCarrera/search")
	public ResponseEntity<List<TipoCarreraDTO>> getAllTipoCarreras(TipoCarreraCriteria criteria,
			@ApiIgnore @NonNull Pageable pageable) {
		log.debug("REST request to get TipoCarreras by criteria: {}", criteria);
		Page<TipoCarreraDTO> page = criteriaService.findAllByCriteria(criteria, pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/tipoCarrera/search");
		return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	}

	/**
	 * GET /tipoCarrera/:id : get the "id" tipoCarrera.
	 *
	 * @param id
	 *            the id of the tipoCarreraDTO to retrieve
	 * @return the ResponseEntity with status 200 (OK) and with body the
	 *         tipoCarreraDTO, or with status 404 (Not Found)
	 */
	@GetMapping("/tipoCarrera/{id}")
	public ResponseEntity<TipoCarreraDTO> getTipoCarrera(@PathVariable Long id) {
		log.debug("REST request to get TipoCarrera : {}", id);
		Optional<TipoCarreraDTO> tipoCarreraDTO = service.findOne(id);
		return ResponseUtil.wrapOrNotFound(tipoCarreraDTO);
	}

	/**
	 * DELETE /tipoCarrera/:id : delete the "id" tipoCarrera.
	 *
	 * @param id
	 *            the id of the tipoCarreraDTO to delete
	 * @return the ResponseEntity with status 200 (OK)
	 */
	@DeleteMapping("/tipoCarrera/{id}")
	public ResponseEntity<Void> deleteTipoCarrera(@PathVariable Long id) {
		log.debug("REST request to delete TipoCarrera : {}", id);
		service.delete(id);
		return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
	}
}
