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

import com.bindot.runap.model.Direccion;
import com.bindot.runap.service.BaseService;
import com.bindot.runap.service.criteria.DireccionCriteriaService;
import com.bindot.runap.service.dto.DireccionCriteria;
import com.bindot.runap.service.dto.DireccionDTO;
import com.bindot.runap.web.rest.error.BadRequestAlertException;
import com.bindot.runap.web.rest.util.HeaderUtil;
import com.bindot.runap.web.rest.util.PaginationUtil;
import com.bindot.runap.web.rest.util.ResponseUtil;

import springfox.documentation.annotations.ApiIgnore;

/**
 * REST controller for managing Direccion.
 * 
 * @author Cesar Zamorano
 *
 */
@RestController
@RequestMapping("/api")
public class DireccionResource {

	private final Logger log = LoggerFactory.getLogger(DireccionResource.class);

	private static final String ENTITY_NAME = "direccion";

	private final BaseService<Direccion, DireccionDTO> service;

	private final DireccionCriteriaService criteriaService;

	public DireccionResource(BaseService<Direccion, DireccionDTO> direccionService,
			DireccionCriteriaService direccionCriteriaService) {
		this.service = direccionService;
		this.criteriaService = direccionCriteriaService;
	}

	/**
	 * POST /direccion : Create a new direccion.
	 *
	 * @param direccionDTO
	 *            the direccionDTO to create
	 * @return the ResponseEntity with status 201 (Created) and with body the new
	 *         direccionDTO, or with status 400 (Bad Request) if the direccion has
	 *         already an ID
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PostMapping("/direccion")
	public ResponseEntity<DireccionDTO> createDireccion(@Valid @RequestBody DireccionDTO direccionDTO)
			throws URISyntaxException {
		log.debug("REST request to save Direccion : {}", direccionDTO);
		if (direccionDTO.getId() != null) {
			throw new BadRequestAlertException("A new direccion cannot already have an ID", ENTITY_NAME, "idexists");
		}
		if (direccionDTO.getEnabled() == null) {
			direccionDTO.setEnabled(true);
		}
		DireccionDTO result = service.save(direccionDTO);
		return ResponseEntity.created(new URI("/api/direccion/" + result.getId()))
				.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString())).body(result);
	}

	/**
	 * PUT /direccion : Updates an existing direccion.
	 *
	 * @param direccionDTO
	 *            the direccionDTO to update
	 * @return the ResponseEntity with status 200 (OK) and with body the updated
	 *         direccionDTO, or with status 400 (Bad Request) if the direccionDTO is
	 *         not valid, or with status 500 (Internal Server Error) if the
	 *         direccionDTO couldn't be updated
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PutMapping("/direccion")
	public ResponseEntity<DireccionDTO> updateDireccion(@Valid @RequestBody DireccionDTO direccionDTO) {
		log.debug("REST request to update Direccion : {}", direccionDTO);
		if (direccionDTO.getId() == null) {
			throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
		}
		DireccionDTO result = service.save(direccionDTO);
		return ResponseEntity.ok()
				.headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, direccionDTO.getId().toString())).body(result);
	}

	/**
	 * GET /direccion : get all the direccions.
	 *
	 * @param pageable
	 *            the pagination information
	 * @return the ResponseEntity with status 200 (OK) and the list of direccions in
	 *         body
	 */
	@ApiPageable
	@GetMapping("/direccion")
	public ResponseEntity<List<DireccionDTO>> getAllDireccions(@ApiIgnore @NonNull Pageable pageable) {
		String message = "REST request to get a page of Direccions";
		log.debug(message);
		Page<DireccionDTO> page = service.findAll(pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/direccion");
		return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	}

	/**
	 * GET /direccion/search : get all the direccions.
	 *
	 * @param pageable
	 *            the pagination information
	 * @param criteria
	 *            the criterias which the requested entities should match
	 * @return the ResponseEntity with status 200 (OK) and the list of direccions in
	 *         body
	 */
	@ApiPageable
	@GetMapping("/direccion/search")
	public ResponseEntity<List<DireccionDTO>> getAllDireccions(DireccionCriteria criteria,
			@ApiIgnore @NonNull Pageable pageable) {
		log.debug("REST request to get Direccions by criteria: {}", criteria);
		Page<DireccionDTO> page = criteriaService.findAllByCriteria(criteria, pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/direccion/search");
		return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	}

	/**
	 * GET /direccion/:id : get the "id" direccion.
	 *
	 * @param id
	 *            the id of the direccionDTO to retrieve
	 * @return the ResponseEntity with status 200 (OK) and with body the
	 *         direccionDTO, or with status 404 (Not Found)
	 */
	@GetMapping("/direccion/{id}")
	public ResponseEntity<DireccionDTO> getDireccion(@PathVariable Long id) {
		log.debug("REST request to get Direccion : {}", id);
		Optional<DireccionDTO> direccionDTO = service.findOne(id);
		return ResponseUtil.wrapOrNotFound(direccionDTO);
	}

	/**
	 * DELETE /direccion/:id : delete the "id" direccion.
	 *
	 * @param id
	 *            the id of the direccionDTO to delete
	 * @return the ResponseEntity with status 200 (OK)
	 */
	@DeleteMapping("/direccion/{id}")
	public ResponseEntity<Void> deleteDireccion(@PathVariable Long id) {
		log.debug("REST request to delete Direccion : {}", id);
		service.delete(id);
		return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
	}
}
