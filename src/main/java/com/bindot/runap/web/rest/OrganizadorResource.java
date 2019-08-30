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

import com.bindot.runap.model.Organizador;
import com.bindot.runap.service.BaseService;
import com.bindot.runap.service.criteria.OrganizadorCriteriaService;
import com.bindot.runap.service.dto.OrganizadorCriteria;
import com.bindot.runap.service.dto.OrganizadorDTO;
import com.bindot.runap.web.rest.error.BadRequestAlertException;
import com.bindot.runap.web.rest.util.HeaderUtil;
import com.bindot.runap.web.rest.util.PaginationUtil;
import com.bindot.runap.web.rest.util.ResponseUtil;

import springfox.documentation.annotations.ApiIgnore;

/**
 * REST controller for managing Organizador.
 * 
 * @author Cesar Zamorano
 *
 */
@RestController
@RequestMapping("/api")
public class OrganizadorResource {

	private final Logger log = LoggerFactory.getLogger(OrganizadorResource.class);

	private static final String ENTITY_NAME = "organizador";

	private final BaseService<Organizador, OrganizadorDTO> service;

	private final OrganizadorCriteriaService criteriaService;

	public OrganizadorResource(BaseService<Organizador, OrganizadorDTO> organizadorService,
			OrganizadorCriteriaService organizadorCriteriaService) {
		this.service = organizadorService;
		this.criteriaService = organizadorCriteriaService;
	}

	/**
	 * POST /organizador : Create a new organizador.
	 *
	 * @param organizadorDTO
	 *            the organizadorDTO to create
	 * @return the ResponseEntity with status 201 (Created) and with body the new
	 *         organizadorDTO, or with status 400 (Bad Request) if the organizador
	 *         has already an ID
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PostMapping("/organizador")
	public ResponseEntity<OrganizadorDTO> createOrganizador(@Valid @RequestBody OrganizadorDTO organizadorDTO)
			throws URISyntaxException {
		log.debug("REST request to save Organizador : {}", organizadorDTO);
		if (organizadorDTO.getId() != null) {
			throw new BadRequestAlertException("A new organizador cannot already have an ID", ENTITY_NAME, "idexists");
		}
		if (organizadorDTO.getEnabled() == null) {
			organizadorDTO.setEnabled(true);
		}
		OrganizadorDTO result = service.save(organizadorDTO);
		return ResponseEntity.created(new URI("/api/organizador/" + result.getId()))
				.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString())).body(result);
	}

	/**
	 * PUT /organizador : Updates an existing organizador.
	 *
	 * @param organizadorDTO
	 *            the organizadorDTO to update
	 * @return the ResponseEntity with status 200 (OK) and with body the updated
	 *         organizadorDTO, or with status 400 (Bad Request) if the
	 *         organizadorDTO is not valid, or with status 500 (Internal Server
	 *         Error) if the organizadorDTO couldn't be updated
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PutMapping("/organizador")
	public ResponseEntity<OrganizadorDTO> updateOrganizador(@Valid @RequestBody OrganizadorDTO organizadorDTO) {
		log.debug("REST request to update Organizador : {}", organizadorDTO);
		if (organizadorDTO.getId() == null) {
			throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
		}
		OrganizadorDTO result = service.save(organizadorDTO);
		return ResponseEntity.ok()
				.headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, organizadorDTO.getId().toString()))
				.body(result);
	}

	/**
	 * GET /organizador : get all the organizadors.
	 *
	 * @param pageable
	 *            the pagination information
	 * @return the ResponseEntity with status 200 (OK) and the list of organizadors
	 *         in body
	 */
	@ApiPageable
	@GetMapping("/organizador")
	public ResponseEntity<List<OrganizadorDTO>> getAllOrganizadors(@ApiIgnore @NonNull Pageable pageable) {
		String message = "REST request to get a page of Organizadors";
		log.debug(message);
		Page<OrganizadorDTO> page = service.findAll(pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/organizador");
		return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	}

	/**
	 * GET /organizador/search : get all the organizadors.
	 *
	 * @param pageable
	 *            the pagination information
	 * @param criteria
	 *            the criterias which the requested entities should match
	 * @return the ResponseEntity with status 200 (OK) and the list of organizadors
	 *         in body
	 */
	@ApiPageable
	@GetMapping("/organizador/search")
	public ResponseEntity<List<OrganizadorDTO>> getAllOrganizadors(OrganizadorCriteria criteria,
			@ApiIgnore @NonNull Pageable pageable) {
		log.debug("REST request to get Organizadors by criteria: {}", criteria);
		Page<OrganizadorDTO> page = criteriaService.findAllByCriteria(criteria, pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/organizador/search");
		return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	}

	/**
	 * GET /organizador/:id : get the "id" organizador.
	 *
	 * @param id
	 *            the id of the organizadorDTO to retrieve
	 * @return the ResponseEntity with status 200 (OK) and with body the
	 *         organizadorDTO, or with status 404 (Not Found)
	 */
	@GetMapping("/organizador/{id}")
	public ResponseEntity<OrganizadorDTO> getOrganizador(@PathVariable Long id) {
		log.debug("REST request to get Organizador : {}", id);
		Optional<OrganizadorDTO> organizadorDTO = service.findOne(id);
		return ResponseUtil.wrapOrNotFound(organizadorDTO);
	}

	/**
	 * DELETE /organizador/:id : delete the "id" organizador.
	 *
	 * @param id
	 *            the id of the organizadorDTO to delete
	 * @return the ResponseEntity with status 200 (OK)
	 */
	@DeleteMapping("/organizador/{id}")
	public ResponseEntity<Void> deleteOrganizador(@PathVariable Long id) {
		log.debug("REST request to delete Organizador : {}", id);
		service.delete(id);
		return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
	}
}
