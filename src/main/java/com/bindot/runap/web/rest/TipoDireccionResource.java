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

import com.bindot.runap.model.TipoDireccion;
import com.bindot.runap.service.BaseService;
import com.bindot.runap.service.TipoDireccionCriteriaService;
import com.bindot.runap.service.dto.TipoDireccionCriteria;
import com.bindot.runap.service.dto.TipoDireccionDTO;
import com.bindot.runap.web.rest.error.BadRequestAlertException;
import com.bindot.runap.web.rest.util.HeaderUtil;
import com.bindot.runap.web.rest.util.PaginationUtil;
import com.bindot.runap.web.rest.util.ResponseUtil;

import springfox.documentation.annotations.ApiIgnore;

/**
 * REST controller for managing TipoDireccion.
 * 
 * @author Cesar Zamorano
 *
 */
@RestController
@RequestMapping("/api")
public class TipoDireccionResource {

	private final Logger log = LoggerFactory.getLogger(TipoDireccionResource.class);

	private static final String ENTITY_NAME = "tipoDireccion";

	private final BaseService<TipoDireccion, TipoDireccionDTO> service;

	private final TipoDireccionCriteriaService criteriaService;

	public TipoDireccionResource(BaseService<TipoDireccion, TipoDireccionDTO> tipoDireccionService,
			TipoDireccionCriteriaService tipoDireccionCriteriaService) {
		this.service = tipoDireccionService;
		this.criteriaService = tipoDireccionCriteriaService;
	}

	/**
	 * POST /tipoDireccion : Create a new tipoDireccion.
	 *
	 * @param tipoDireccionDTO
	 *            the tipoDireccionDTO to create
	 * @return the ResponseEntity with status 201 (Created) and with body the new
	 *         tipoDireccionDTO, or with status 400 (Bad Request) if the
	 *         tipoDireccion has already an ID
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PostMapping("/tipoDireccion")
	public ResponseEntity<TipoDireccionDTO> createTipoDireccion(@Valid @RequestBody TipoDireccionDTO tipoDireccionDTO)
			throws URISyntaxException {
		log.debug("REST request to save TipoDireccion : {}", tipoDireccionDTO);
		if (tipoDireccionDTO.getId() != null) {
			throw new BadRequestAlertException("A new tipoDireccion cannot already have an ID", ENTITY_NAME,
					"idexists");
		}
		if (tipoDireccionDTO.getEnabled() == null) {
			tipoDireccionDTO.setEnabled(true);
		}
		TipoDireccionDTO result = service.save(tipoDireccionDTO);
		return ResponseEntity.created(new URI("/api/tipoDireccion/" + result.getId()))
				.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString())).body(result);
	}

	/**
	 * PUT /tipoDireccion : Updates an existing tipoDireccion.
	 *
	 * @param tipoDireccionDTO
	 *            the tipoDireccionDTO to update
	 * @return the ResponseEntity with status 200 (OK) and with body the updated
	 *         tipoDireccionDTO, or with status 400 (Bad Request) if the
	 *         tipoDireccionDTO is not valid, or with status 500 (Internal Server
	 *         Error) if the tipoDireccionDTO couldn't be updated
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PutMapping("/tipoDireccion")
	public ResponseEntity<TipoDireccionDTO> updateTipoDireccion(@Valid @RequestBody TipoDireccionDTO tipoDireccionDTO) {
		log.debug("REST request to update TipoDireccion : {}", tipoDireccionDTO);
		if (tipoDireccionDTO.getId() == null) {
			throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
		}
		TipoDireccionDTO result = service.save(tipoDireccionDTO);
		return ResponseEntity.ok()
				.headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, tipoDireccionDTO.getId().toString()))
				.body(result);
	}

	/**
	 * GET /tipoDireccion : get all the tipoDireccions.
	 *
	 * @param pageable
	 *            the pagination information
	 * @return the ResponseEntity with status 200 (OK) and the list of
	 *         tipoDireccions in body
	 */
	@ApiPageable
	@GetMapping("/tipoDireccion")
	public ResponseEntity<List<TipoDireccionDTO>> getAllTipoDireccions(@ApiIgnore @NonNull Pageable pageable) {
		String message = "REST request to get a page of TipoDireccions";
		log.debug(message);
		Page<TipoDireccionDTO> page = service.findAll(pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/tipoDireccion");
		return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	}

	/**
	 * GET /tipoDireccion/search : get all the tipoDireccions.
	 *
	 * @param pageable
	 *            the pagination information
	 * @param criteria
	 *            the criterias which the requested entities should match
	 * @return the ResponseEntity with status 200 (OK) and the list of
	 *         tipoDireccions in body
	 */
	@ApiPageable
	@GetMapping("/tipoDireccion/search")
	public ResponseEntity<List<TipoDireccionDTO>> getAllTipoDireccions(TipoDireccionCriteria criteria,
			@ApiIgnore @NonNull Pageable pageable) {
		log.debug("REST request to get TipoDireccions by criteria: {}", criteria);
		Page<TipoDireccionDTO> page = criteriaService.findAllByCriteria(criteria, pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/tipoDireccion/search");
		return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	}

	/**
	 * GET /tipoDireccion/:id : get the "id" tipoDireccion.
	 *
	 * @param id
	 *            the id of the tipoDireccionDTO to retrieve
	 * @return the ResponseEntity with status 200 (OK) and with body the
	 *         tipoDireccionDTO, or with status 404 (Not Found)
	 */
	@GetMapping("/tipoDireccion/{id}")
	public ResponseEntity<TipoDireccionDTO> getTipoDireccion(@PathVariable Long id) {
		log.debug("REST request to get TipoDireccion : {}", id);
		Optional<TipoDireccionDTO> tipoDireccionDTO = service.findOne(id);
		return ResponseUtil.wrapOrNotFound(tipoDireccionDTO);
	}

	/**
	 * DELETE /tipoDireccion/:id : delete the "id" tipoDireccion.
	 *
	 * @param id
	 *            the id of the tipoDireccionDTO to delete
	 * @return the ResponseEntity with status 200 (OK)
	 */
	@DeleteMapping("/tipoDireccion/{id}")
	public ResponseEntity<Void> deleteTipoDireccion(@PathVariable Long id) {
		log.debug("REST request to delete TipoDireccion : {}", id);
		service.delete(id);
		return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
	}
}
