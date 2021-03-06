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

import com.bindot.runap.model.Corredor;
import com.bindot.runap.service.BaseService;
import com.bindot.runap.service.criteria.CorredorCriteriaService;
import com.bindot.runap.service.dto.CorredorCriteria;
import com.bindot.runap.service.dto.CorredorDTO;
import com.bindot.runap.web.rest.error.BadRequestAlertException;
import com.bindot.runap.web.rest.util.HeaderUtil;
import com.bindot.runap.web.rest.util.PaginationUtil;
import com.bindot.runap.web.rest.util.ResponseUtil;

import springfox.documentation.annotations.ApiIgnore;

/**
 * REST controller for managing Corredor.
 * 
 * @author Cesar Zamorano
 *
 */
@RestController
@RequestMapping("/api")
public class CorredorResource {

	private final Logger log = LoggerFactory.getLogger(CorredorResource.class);

	private static final String ENTITY_NAME = "corredor";

	private final BaseService<Corredor, CorredorDTO> service;

	private final CorredorCriteriaService criteriaService;

	public CorredorResource(BaseService<Corredor, CorredorDTO> corredorService,
			CorredorCriteriaService corredorCriteriaService) {
		this.service = corredorService;
		this.criteriaService = corredorCriteriaService;
	}

	/**
	 * POST /corredor : Create a new corredor.
	 *
	 * @param corredorDTO
	 *            the corredorDTO to create
	 * @return the ResponseEntity with status 201 (Created) and with body the new
	 *         corredorDTO, or with status 400 (Bad Request) if the corredor has
	 *         already an ID
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PostMapping("/corredor")
	public ResponseEntity<CorredorDTO> createCorredor(@Valid @RequestBody CorredorDTO corredorDTO)
			throws URISyntaxException {
		log.debug("REST request to save Corredor : {}", corredorDTO);
		if (corredorDTO.getId() != null) {
			throw new BadRequestAlertException("A new corredor cannot already have an ID", ENTITY_NAME, "idexists");
		}
		if (corredorDTO.getEnabled() == null) {
			corredorDTO.setEnabled(true);
		}
		CorredorDTO result = service.save(corredorDTO);
		return ResponseEntity.created(new URI("/api/corredor/" + result.getId()))
				.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString())).body(result);
	}

	/**
	 * PUT /corredor : Updates an existing corredor.
	 *
	 * @param corredorDTO
	 *            the corredorDTO to update
	 * @return the ResponseEntity with status 200 (OK) and with body the updated
	 *         corredorDTO, or with status 400 (Bad Request) if the corredorDTO is
	 *         not valid, or with status 500 (Internal Server Error) if the
	 *         corredorDTO couldn't be updated
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PutMapping("/corredor")
	public ResponseEntity<CorredorDTO> updateCorredor(@Valid @RequestBody CorredorDTO corredorDTO) {
		log.debug("REST request to update Corredor : {}", corredorDTO);
		if (corredorDTO.getId() == null) {
			throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
		}
		CorredorDTO result = service.save(corredorDTO);
		return ResponseEntity.ok()
				.headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, corredorDTO.getId().toString())).body(result);
	}

	/**
	 * GET /corredor : get all the corredors.
	 *
	 * @param pageable
	 *            the pagination information
	 * @return the ResponseEntity with status 200 (OK) and the list of corredors in
	 *         body
	 */
	@ApiPageable
	@GetMapping("/corredor")
	public ResponseEntity<List<CorredorDTO>> getAllCorredors(@ApiIgnore @NonNull Pageable pageable) {
		String message = "REST request to get a page of Corredors";
		log.debug(message);
		Page<CorredorDTO> page = service.findAll(pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/corredor");
		return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	}

	/**
	 * GET /corredor/search : get all the corredors.
	 *
	 * @param pageable
	 *            the pagination information
	 * @param criteria
	 *            the criterias which the requested entities should match
	 * @return the ResponseEntity with status 200 (OK) and the list of corredors in
	 *         body
	 */
	@ApiPageable
	@GetMapping("/corredor/search")
	public ResponseEntity<List<CorredorDTO>> getAllCorredors(CorredorCriteria criteria,
			@ApiIgnore @NonNull Pageable pageable) {
		log.debug("REST request to get Corredors by criteria: {}", criteria);
		Page<CorredorDTO> page = criteriaService.findAllByCriteria(criteria, pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/corredor/search");
		return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	}

	/**
	 * GET /corredor/:id : get the "id" corredor.
	 *
	 * @param id
	 *            the id of the corredorDTO to retrieve
	 * @return the ResponseEntity with status 200 (OK) and with body the
	 *         corredorDTO, or with status 404 (Not Found)
	 */
	@GetMapping("/corredor/{id}")
	public ResponseEntity<CorredorDTO> getCorredor(@PathVariable Long id) {
		log.debug("REST request to get Corredor : {}", id);
		Optional<CorredorDTO> corredorDTO = service.findOne(id);
		return ResponseUtil.wrapOrNotFound(corredorDTO);
	}

	/**
	 * DELETE /corredor/:id : delete the "id" corredor.
	 *
	 * @param id
	 *            the id of the corredorDTO to delete
	 * @return the ResponseEntity with status 200 (OK)
	 */
	@DeleteMapping("/corredor/{id}")
	public ResponseEntity<Void> deleteCorredor(@PathVariable Long id) {
		log.debug("REST request to delete Corredor : {}", id);
		service.delete(id);
		return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
	}
}
