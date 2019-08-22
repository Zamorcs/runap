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

import com.bindot.runap.model.EstadoCalendario;
import com.bindot.runap.service.BaseService;
import com.bindot.runap.service.EstadoCalendarioCriteriaService;
import com.bindot.runap.service.dto.EstadoCalendarioCriteria;
import com.bindot.runap.service.dto.EstadoCalendarioDTO;
import com.bindot.runap.web.rest.error.BadRequestAlertException;
import com.bindot.runap.web.rest.util.HeaderUtil;
import com.bindot.runap.web.rest.util.PaginationUtil;
import com.bindot.runap.web.rest.util.ResponseUtil;

import springfox.documentation.annotations.ApiIgnore;

/**
 * REST controller for managing EstadoCalendario.
 * 
 * @author Cesar Zamorano
 *
 */
@RestController
@RequestMapping("/api")
public class EstadoCalendarioResource {

	private final Logger log = LoggerFactory.getLogger(EstadoCalendarioResource.class);

	private static final String ENTITY_NAME = "estadoCalendario";

	private final BaseService<EstadoCalendario, EstadoCalendarioDTO> service;

	private final EstadoCalendarioCriteriaService criteriaService;

	public EstadoCalendarioResource(BaseService<EstadoCalendario, EstadoCalendarioDTO> estadoCalendarioService,
			EstadoCalendarioCriteriaService estadoCalendarioCriteriaService) {
		this.service = estadoCalendarioService;
		this.criteriaService = estadoCalendarioCriteriaService;
	}

	/**
	 * POST /estadoCalendario : Create a new estadoCalendario.
	 *
	 * @param estadoCalendarioDTO
	 *            the estadoCalendarioDTO to create
	 * @return the ResponseEntity with status 201 (Created) and with body the new
	 *         estadoCalendarioDTO, or with status 400 (Bad Request) if the
	 *         estadoCalendario has already an ID
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PostMapping("/estadoCalendario")
	public ResponseEntity<EstadoCalendarioDTO> createEstadoCalendario(
			@Valid @RequestBody EstadoCalendarioDTO estadoCalendarioDTO) throws URISyntaxException {
		log.debug("REST request to save EstadoCalendario : {}", estadoCalendarioDTO);
		if (estadoCalendarioDTO.getId() != null) {
			throw new BadRequestAlertException("A new estadoCalendario cannot already have an ID", ENTITY_NAME,
					"idexists");
		}
		if (estadoCalendarioDTO.getEnabled() == null) {
			estadoCalendarioDTO.setEnabled(true);
		}
		EstadoCalendarioDTO result = service.save(estadoCalendarioDTO);
		return ResponseEntity.created(new URI("/api/estadoCalendario/" + result.getId()))
				.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString())).body(result);
	}

	/**
	 * PUT /estadoCalendario : Updates an existing estadoCalendario.
	 *
	 * @param estadoCalendarioDTO
	 *            the estadoCalendarioDTO to update
	 * @return the ResponseEntity with status 200 (OK) and with body the updated
	 *         estadoCalendarioDTO, or with status 400 (Bad Request) if the
	 *         estadoCalendarioDTO is not valid, or with status 500 (Internal Server
	 *         Error) if the estadoCalendarioDTO couldn't be updated
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PutMapping("/estadoCalendario")
	public ResponseEntity<EstadoCalendarioDTO> updateEstadoCalendario(
			@Valid @RequestBody EstadoCalendarioDTO estadoCalendarioDTO) {
		log.debug("REST request to update EstadoCalendario : {}", estadoCalendarioDTO);
		if (estadoCalendarioDTO.getId() == null) {
			throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
		}
		EstadoCalendarioDTO result = service.save(estadoCalendarioDTO);
		return ResponseEntity.ok()
				.headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, estadoCalendarioDTO.getId().toString()))
				.body(result);
	}

	/**
	 * GET /estadoCalendario : get all the estadoCalendarios.
	 *
	 * @param pageable
	 *            the pagination information
	 * @return the ResponseEntity with status 200 (OK) and the list of
	 *         estadoCalendarios in body
	 */
	@ApiPageable
	@GetMapping("/estadoCalendario")
	public ResponseEntity<List<EstadoCalendarioDTO>> getAllEstadoCalendarios(@ApiIgnore @NonNull Pageable pageable) {
		String message = "REST request to get a page of EstadoCalendarios";
		log.debug(message);
		Page<EstadoCalendarioDTO> page = service.findAll(pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/estadoCalendario");
		return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	}

	/**
	 * GET /estadoCalendario/search : get all the estadoCalendarios.
	 *
	 * @param pageable
	 *            the pagination information
	 * @param criteria
	 *            the criterias which the requested entities should match
	 * @return the ResponseEntity with status 200 (OK) and the list of
	 *         estadoCalendarios in body
	 */
	@ApiPageable
	@GetMapping("/estadoCalendario/search")
	public ResponseEntity<List<EstadoCalendarioDTO>> getAllEstadoCalendarios(EstadoCalendarioCriteria criteria,
			@ApiIgnore @NonNull Pageable pageable) {
		log.debug("REST request to get EstadoCalendarios by criteria: {}", criteria);
		Page<EstadoCalendarioDTO> page = criteriaService.findAllByCriteria(criteria, pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/estadoCalendario/search");
		return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	}

	/**
	 * GET /estadoCalendario/:id : get the "id" estadoCalendario.
	 *
	 * @param id
	 *            the id of the estadoCalendarioDTO to retrieve
	 * @return the ResponseEntity with status 200 (OK) and with body the
	 *         estadoCalendarioDTO, or with status 404 (Not Found)
	 */
	@GetMapping("/estadoCalendario/{id}")
	public ResponseEntity<EstadoCalendarioDTO> getEstadoCalendario(@PathVariable Long id) {
		log.debug("REST request to get EstadoCalendario : {}", id);
		Optional<EstadoCalendarioDTO> estadoCalendarioDTO = service.findOne(id);
		return ResponseUtil.wrapOrNotFound(estadoCalendarioDTO);
	}

	/**
	 * DELETE /estadoCalendario/:id : delete the "id" estadoCalendario.
	 *
	 * @param id
	 *            the id of the estadoCalendarioDTO to delete
	 * @return the ResponseEntity with status 200 (OK)
	 */
	@DeleteMapping("/estadoCalendario/{id}")
	public ResponseEntity<Void> deleteEstadoCalendario(@PathVariable Long id) {
		log.debug("REST request to delete EstadoCalendario : {}", id);
		service.delete(id);
		return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
	}
}
