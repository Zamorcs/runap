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

import com.bindot.runap.model.Calendario;
import com.bindot.runap.service.BaseService;
import com.bindot.runap.service.criteria.CalendarioCriteriaService;
import com.bindot.runap.service.dto.CalendarioCriteria;
import com.bindot.runap.service.dto.CalendarioDTO;
import com.bindot.runap.web.rest.error.BadRequestAlertException;
import com.bindot.runap.web.rest.util.HeaderUtil;
import com.bindot.runap.web.rest.util.PaginationUtil;
import com.bindot.runap.web.rest.util.ResponseUtil;

import springfox.documentation.annotations.ApiIgnore;

/**
 * REST controller for managing Calendario.
 * 
 * @author Cesar Zamorano
 *
 */
@RestController
@RequestMapping("/api")
public class CalendarioResource {

	private final Logger log = LoggerFactory.getLogger(CalendarioResource.class);

	private static final String ENTITY_NAME = "calendario";

	private final BaseService<Calendario, CalendarioDTO> service;

	private final CalendarioCriteriaService criteriaService;

	public CalendarioResource(BaseService<Calendario, CalendarioDTO> calendarioService,
			CalendarioCriteriaService calendarioCriteriaService) {
		this.service = calendarioService;
		this.criteriaService = calendarioCriteriaService;
	}

	/**
	 * POST /calendario : Create a new calendario.
	 *
	 * @param calendarioDTO
	 *            the calendarioDTO to create
	 * @return the ResponseEntity with status 201 (Created) and with body the new
	 *         calendarioDTO, or with status 400 (Bad Request) if the calendario has
	 *         already an ID
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PostMapping("/calendario")
	public ResponseEntity<CalendarioDTO> createCalendario(@Valid @RequestBody CalendarioDTO calendarioDTO)
			throws URISyntaxException {
		log.debug("REST request to save Calendario : {}", calendarioDTO);
		if (calendarioDTO.getId() != null) {
			throw new BadRequestAlertException("A new calendario cannot already have an ID", ENTITY_NAME, "idexists");
		}
		if (calendarioDTO.getEnabled() == null) {
			calendarioDTO.setEnabled(true);
		}
		CalendarioDTO result = service.save(calendarioDTO);
		return ResponseEntity.created(new URI("/api/calendario/" + result.getId()))
				.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString())).body(result);
	}

	/**
	 * PUT /calendario : Updates an existing calendario.
	 *
	 * @param calendarioDTO
	 *            the calendarioDTO to update
	 * @return the ResponseEntity with status 200 (OK) and with body the updated
	 *         calendarioDTO, or with status 400 (Bad Request) if the calendarioDTO
	 *         is not valid, or with status 500 (Internal Server Error) if the
	 *         calendarioDTO couldn't be updated
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PutMapping("/calendario")
	public ResponseEntity<CalendarioDTO> updateCalendario(@Valid @RequestBody CalendarioDTO calendarioDTO) {
		log.debug("REST request to update Calendario : {}", calendarioDTO);
		if (calendarioDTO.getId() == null) {
			throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
		}
		CalendarioDTO result = service.save(calendarioDTO);
		return ResponseEntity.ok()
				.headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, calendarioDTO.getId().toString()))
				.body(result);
	}

	/**
	 * GET /calendario : get all the calendarios.
	 *
	 * @param pageable
	 *            the pagination information
	 * @return the ResponseEntity with status 200 (OK) and the list of calendarios
	 *         in body
	 */
	@ApiPageable
	@GetMapping("/calendario")
	public ResponseEntity<List<CalendarioDTO>> getAllCalendarios(@ApiIgnore @NonNull Pageable pageable) {
		String message = "REST request to get a page of Calendarios";
		log.debug(message);
		Page<CalendarioDTO> page = service.findAll(pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/calendario");
		return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	}

	/**
	 * GET /calendario/search : get all the calendarios.
	 *
	 * @param pageable
	 *            the pagination information
	 * @param criteria
	 *            the criterias which the requested entities should match
	 * @return the ResponseEntity with status 200 (OK) and the list of calendarios
	 *         in body
	 */
	@ApiPageable
	@GetMapping("/calendario/search")
	public ResponseEntity<List<CalendarioDTO>> getAllCalendarios(CalendarioCriteria criteria,
			@ApiIgnore @NonNull Pageable pageable) {
		log.debug("REST request to get Calendarios by criteria: {}", criteria);
		Page<CalendarioDTO> page = criteriaService.findAllByCriteria(criteria, pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/calendario/search");
		return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	}

	/**
	 * GET /calendario/:id : get the "id" calendario.
	 *
	 * @param id
	 *            the id of the calendarioDTO to retrieve
	 * @return the ResponseEntity with status 200 (OK) and with body the
	 *         calendarioDTO, or with status 404 (Not Found)
	 */
	@GetMapping("/calendario/{id}")
	public ResponseEntity<CalendarioDTO> getCalendario(@PathVariable Long id) {
		log.debug("REST request to get Calendario : {}", id);
		Optional<CalendarioDTO> calendarioDTO = service.findOne(id);
		return ResponseUtil.wrapOrNotFound(calendarioDTO);
	}

	/**
	 * DELETE /calendario/:id : delete the "id" calendario.
	 *
	 * @param id
	 *            the id of the calendarioDTO to delete
	 * @return the ResponseEntity with status 200 (OK)
	 */
	@DeleteMapping("/calendario/{id}")
	public ResponseEntity<Void> deleteCalendario(@PathVariable Long id) {
		log.debug("REST request to delete Calendario : {}", id);
		service.delete(id);
		return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
	}
}
