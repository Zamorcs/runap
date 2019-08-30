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

import com.bindot.runap.model.Documentacion;
import com.bindot.runap.service.BaseService;
import com.bindot.runap.service.criteria.DocumentacionCriteriaService;
import com.bindot.runap.service.dto.DocumentacionCriteria;
import com.bindot.runap.service.dto.DocumentacionDTO;
import com.bindot.runap.web.rest.error.BadRequestAlertException;
import com.bindot.runap.web.rest.util.HeaderUtil;
import com.bindot.runap.web.rest.util.PaginationUtil;
import com.bindot.runap.web.rest.util.ResponseUtil;

import springfox.documentation.annotations.ApiIgnore;

/**
 * REST controller for managing Documentacion.
 * 
 * @author Cesar Zamorano
 *
 */
@RestController
@RequestMapping("/api")
public class DocumentacionResource {

	private final Logger log = LoggerFactory.getLogger(DocumentacionResource.class);

	private static final String ENTITY_NAME = "documentacion";

	private final BaseService<Documentacion, DocumentacionDTO> service;

	private final DocumentacionCriteriaService criteriaService;

	public DocumentacionResource(BaseService<Documentacion, DocumentacionDTO> documentacionService,
			DocumentacionCriteriaService documentacionCriteriaService) {
		this.service = documentacionService;
		this.criteriaService = documentacionCriteriaService;
	}

	/**
	 * POST /documentacion : Create a new documentacion.
	 *
	 * @param documentacionDTO
	 *            the documentacionDTO to create
	 * @return the ResponseEntity with status 201 (Created) and with body the new
	 *         documentacionDTO, or with status 400 (Bad Request) if the
	 *         documentacion has already an ID
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PostMapping("/documentacion")
	public ResponseEntity<DocumentacionDTO> createDocumentacion(@Valid @RequestBody DocumentacionDTO documentacionDTO)
			throws URISyntaxException {
		log.debug("REST request to save Documentacion : {}", documentacionDTO);
		if (documentacionDTO.getId() != null) {
			throw new BadRequestAlertException("A new documentacion cannot already have an ID", ENTITY_NAME,
					"idexists");
		}
		if (documentacionDTO.getEnabled() == null) {
			documentacionDTO.setEnabled(true);
		}
		DocumentacionDTO result = service.save(documentacionDTO);
		return ResponseEntity.created(new URI("/api/documentacion/" + result.getId()))
				.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString())).body(result);
	}

	/**
	 * PUT /documentacion : Updates an existing documentacion.
	 *
	 * @param documentacionDTO
	 *            the documentacionDTO to update
	 * @return the ResponseEntity with status 200 (OK) and with body the updated
	 *         documentacionDTO, or with status 400 (Bad Request) if the
	 *         documentacionDTO is not valid, or with status 500 (Internal Server
	 *         Error) if the documentacionDTO couldn't be updated
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PutMapping("/documentacion")
	public ResponseEntity<DocumentacionDTO> updateDocumentacion(@Valid @RequestBody DocumentacionDTO documentacionDTO) {
		log.debug("REST request to update Documentacion : {}", documentacionDTO);
		if (documentacionDTO.getId() == null) {
			throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
		}
		DocumentacionDTO result = service.save(documentacionDTO);
		return ResponseEntity.ok()
				.headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, documentacionDTO.getId().toString()))
				.body(result);
	}

	/**
	 * GET /documentacion : get all the documentacions.
	 *
	 * @param pageable
	 *            the pagination information
	 * @return the ResponseEntity with status 200 (OK) and the list of
	 *         documentacions in body
	 */
	@ApiPageable
	@GetMapping("/documentacion")
	public ResponseEntity<List<DocumentacionDTO>> getAllDocumentacions(@ApiIgnore @NonNull Pageable pageable) {
		String message = "REST request to get a page of Documentacions";
		log.debug(message);
		Page<DocumentacionDTO> page = service.findAll(pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/documentacion");
		return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	}

	/**
	 * GET /documentacion/search : get all the documentacions.
	 *
	 * @param pageable
	 *            the pagination information
	 * @param criteria
	 *            the criterias which the requested entities should match
	 * @return the ResponseEntity with status 200 (OK) and the list of
	 *         documentacions in body
	 */
	@ApiPageable
	@GetMapping("/documentacion/search")
	public ResponseEntity<List<DocumentacionDTO>> getAllDocumentacions(DocumentacionCriteria criteria,
			@ApiIgnore @NonNull Pageable pageable) {
		log.debug("REST request to get Documentacions by criteria: {}", criteria);
		Page<DocumentacionDTO> page = criteriaService.findAllByCriteria(criteria, pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/documentacion/search");
		return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	}

	/**
	 * GET /documentacion/:id : get the "id" documentacion.
	 *
	 * @param id
	 *            the id of the documentacionDTO to retrieve
	 * @return the ResponseEntity with status 200 (OK) and with body the
	 *         documentacionDTO, or with status 404 (Not Found)
	 */
	@GetMapping("/documentacion/{id}")
	public ResponseEntity<DocumentacionDTO> getDocumentacion(@PathVariable Long id) {
		log.debug("REST request to get Documentacion : {}", id);
		Optional<DocumentacionDTO> documentacionDTO = service.findOne(id);
		return ResponseUtil.wrapOrNotFound(documentacionDTO);
	}

	/**
	 * DELETE /documentacion/:id : delete the "id" documentacion.
	 *
	 * @param id
	 *            the id of the documentacionDTO to delete
	 * @return the ResponseEntity with status 200 (OK)
	 */
	@DeleteMapping("/documentacion/{id}")
	public ResponseEntity<Void> deleteDocumentacion(@PathVariable Long id) {
		log.debug("REST request to delete Documentacion : {}", id);
		service.delete(id);
		return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
	}
}
