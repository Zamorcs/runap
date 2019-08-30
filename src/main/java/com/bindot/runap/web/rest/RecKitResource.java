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

import com.bindot.runap.model.RecKit;
import com.bindot.runap.service.BaseService;
import com.bindot.runap.service.criteria.RecKitCriteriaService;
import com.bindot.runap.service.dto.RecKitCriteria;
import com.bindot.runap.service.dto.RecKitDTO;
import com.bindot.runap.web.rest.error.BadRequestAlertException;
import com.bindot.runap.web.rest.util.HeaderUtil;
import com.bindot.runap.web.rest.util.PaginationUtil;
import com.bindot.runap.web.rest.util.ResponseUtil;

import springfox.documentation.annotations.ApiIgnore;

/**
 * REST controller for managing RecKit.
 * 
 * @author Cesar Zamorano
 *
 */
@RestController
@RequestMapping("/api")
public class RecKitResource {

	private final Logger log = LoggerFactory.getLogger(RecKitResource.class);

	private static final String ENTITY_NAME = "recKit";

	private final BaseService<RecKit, RecKitDTO> service;

	private final RecKitCriteriaService criteriaService;

	public RecKitResource(BaseService<RecKit, RecKitDTO> recKitService, RecKitCriteriaService recKitCriteriaService) {
		this.service = recKitService;
		this.criteriaService = recKitCriteriaService;
	}

	/**
	 * POST /recKit : Create a new recKit.
	 *
	 * @param recKitDTO
	 *            the recKitDTO to create
	 * @return the ResponseEntity with status 201 (Created) and with body the new
	 *         recKitDTO, or with status 400 (Bad Request) if the recKit has already
	 *         an ID
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PostMapping("/recKit")
	public ResponseEntity<RecKitDTO> createRecKit(@Valid @RequestBody RecKitDTO recKitDTO) throws URISyntaxException {
		log.debug("REST request to save RecKit : {}", recKitDTO);
		if (recKitDTO.getId() != null) {
			throw new BadRequestAlertException("A new recKit cannot already have an ID", ENTITY_NAME, "idexists");
		}
		if (recKitDTO.getEnabled() == null) {
			recKitDTO.setEnabled(true);
		}
		RecKitDTO result = service.save(recKitDTO);
		return ResponseEntity.created(new URI("/api/recKit/" + result.getId()))
				.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString())).body(result);
	}

	/**
	 * PUT /recKit : Updates an existing recKit.
	 *
	 * @param recKitDTO
	 *            the recKitDTO to update
	 * @return the ResponseEntity with status 200 (OK) and with body the updated
	 *         recKitDTO, or with status 400 (Bad Request) if the recKitDTO is not
	 *         valid, or with status 500 (Internal Server Error) if the recKitDTO
	 *         couldn't be updated
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PutMapping("/recKit")
	public ResponseEntity<RecKitDTO> updateRecKit(@Valid @RequestBody RecKitDTO recKitDTO) {
		log.debug("REST request to update RecKit : {}", recKitDTO);
		if (recKitDTO.getId() == null) {
			throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
		}
		RecKitDTO result = service.save(recKitDTO);
		return ResponseEntity.ok()
				.headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, recKitDTO.getId().toString())).body(result);
	}

	/**
	 * GET /recKit : get all the recKits.
	 *
	 * @param pageable
	 *            the pagination information
	 * @return the ResponseEntity with status 200 (OK) and the list of recKits in
	 *         body
	 */
	@ApiPageable
	@GetMapping("/recKit")
	public ResponseEntity<List<RecKitDTO>> getAllRecKits(@ApiIgnore @NonNull Pageable pageable) {
		String message = "REST request to get a page of RecKits";
		log.debug(message);
		Page<RecKitDTO> page = service.findAll(pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/recKit");
		return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	}

	/**
	 * GET /recKit/search : get all the recKits.
	 *
	 * @param pageable
	 *            the pagination information
	 * @param criteria
	 *            the criterias which the requested entities should match
	 * @return the ResponseEntity with status 200 (OK) and the list of recKits in
	 *         body
	 */
	@ApiPageable
	@GetMapping("/recKit/search")
	public ResponseEntity<List<RecKitDTO>> getAllRecKits(RecKitCriteria criteria,
			@ApiIgnore @NonNull Pageable pageable) {
		log.debug("REST request to get RecKits by criteria: {}", criteria);
		Page<RecKitDTO> page = criteriaService.findAllByCriteria(criteria, pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/recKit/search");
		return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	}

	/**
	 * GET /recKit/:id : get the "id" recKit.
	 *
	 * @param id
	 *            the id of the recKitDTO to retrieve
	 * @return the ResponseEntity with status 200 (OK) and with body the recKitDTO,
	 *         or with status 404 (Not Found)
	 */
	@GetMapping("/recKit/{id}")
	public ResponseEntity<RecKitDTO> getRecKit(@PathVariable Long id) {
		log.debug("REST request to get RecKit : {}", id);
		Optional<RecKitDTO> recKitDTO = service.findOne(id);
		return ResponseUtil.wrapOrNotFound(recKitDTO);
	}

	/**
	 * DELETE /recKit/:id : delete the "id" recKit.
	 *
	 * @param id
	 *            the id of the recKitDTO to delete
	 * @return the ResponseEntity with status 200 (OK)
	 */
	@DeleteMapping("/recKit/{id}")
	public ResponseEntity<Void> deleteRecKit(@PathVariable Long id) {
		log.debug("REST request to delete RecKit : {}", id);
		service.delete(id);
		return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
	}
}
