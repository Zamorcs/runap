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

import com.bindot.runap.model.Formato;
import com.bindot.runap.service.BaseService;
import com.bindot.runap.service.FormatoCriteriaService;
import com.bindot.runap.service.dto.FormatoCriteria;
import com.bindot.runap.service.dto.FormatoDTO;
import com.bindot.runap.web.rest.error.BadRequestAlertException;
import com.bindot.runap.web.rest.util.HeaderUtil;
import com.bindot.runap.web.rest.util.PaginationUtil;
import com.bindot.runap.web.rest.util.ResponseUtil;

import springfox.documentation.annotations.ApiIgnore;

/**
 * REST controller for managing Formato.
 * 
 * @author Cesar Zamorano
 *
 */
@RestController
@RequestMapping("/api")
public class FormatoResource {

	private final Logger log = LoggerFactory.getLogger(FormatoResource.class);

	private static final String ENTITY_NAME = "formato";

	private final BaseService<Formato, FormatoDTO> service;

	private final FormatoCriteriaService criteriaService;

	public FormatoResource(BaseService<Formato, FormatoDTO> formatoService,
			FormatoCriteriaService formatoCriteriaService) {
		this.service = formatoService;
		this.criteriaService = formatoCriteriaService;
	}

	/**
	 * POST /formato : Create a new formato.
	 *
	 * @param formatoDTO
	 *            the formatoDTO to create
	 * @return the ResponseEntity with status 201 (Created) and with body the new
	 *         formatoDTO, or with status 400 (Bad Request) if the formato has
	 *         already an ID
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PostMapping("/formato")
	public ResponseEntity<FormatoDTO> createFormato(@Valid @RequestBody FormatoDTO formatoDTO)
			throws URISyntaxException {
		log.debug("REST request to save Formato : {}", formatoDTO);
		if (formatoDTO.getId() != null) {
			throw new BadRequestAlertException("A new formato cannot already have an ID", ENTITY_NAME, "idexists");
		}
		if (formatoDTO.getEnabled() == null) {
			formatoDTO.setEnabled(true);
		}
		FormatoDTO result = service.save(formatoDTO);
		return ResponseEntity.created(new URI("/api/formato/" + result.getId()))
				.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString())).body(result);
	}

	/**
	 * PUT /formato : Updates an existing formato.
	 *
	 * @param formatoDTO
	 *            the formatoDTO to update
	 * @return the ResponseEntity with status 200 (OK) and with body the updated
	 *         formatoDTO, or with status 400 (Bad Request) if the formatoDTO is not
	 *         valid, or with status 500 (Internal Server Error) if the formatoDTO
	 *         couldn't be updated
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PutMapping("/formato")
	public ResponseEntity<FormatoDTO> updateFormato(@Valid @RequestBody FormatoDTO formatoDTO) {
		log.debug("REST request to update Formato : {}", formatoDTO);
		if (formatoDTO.getId() == null) {
			throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
		}
		FormatoDTO result = service.save(formatoDTO);
		return ResponseEntity.ok()
				.headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, formatoDTO.getId().toString())).body(result);
	}

	/**
	 * GET /formato : get all the formatos.
	 *
	 * @param pageable
	 *            the pagination information
	 * @return the ResponseEntity with status 200 (OK) and the list of formatos in
	 *         body
	 */
	@ApiPageable
	@GetMapping("/formato")
	public ResponseEntity<List<FormatoDTO>> getAllFormatos(@ApiIgnore @NonNull Pageable pageable) {
		String message = "REST request to get a page of Formatos";
		log.debug(message);
		Page<FormatoDTO> page = service.findAll(pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/formato");
		return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	}

	/**
	 * GET /formato/search : get all the formatos.
	 *
	 * @param pageable
	 *            the pagination information
	 * @param criteria
	 *            the criterias which the requested entities should match
	 * @return the ResponseEntity with status 200 (OK) and the list of formatos in
	 *         body
	 */
	@ApiPageable
	@GetMapping("/formato/search")
	public ResponseEntity<List<FormatoDTO>> getAllFormatos(FormatoCriteria criteria,
			@ApiIgnore @NonNull Pageable pageable) {
		log.debug("REST request to get Formatos by criteria: {}", criteria);
		Page<FormatoDTO> page = criteriaService.findAllByCriteria(criteria, pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/formato/search");
		return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	}

	/**
	 * GET /formato/:id : get the "id" formato.
	 *
	 * @param id
	 *            the id of the formatoDTO to retrieve
	 * @return the ResponseEntity with status 200 (OK) and with body the formatoDTO,
	 *         or with status 404 (Not Found)
	 */
	@GetMapping("/formato/{id}")
	public ResponseEntity<FormatoDTO> getFormato(@PathVariable Long id) {
		log.debug("REST request to get Formato : {}", id);
		Optional<FormatoDTO> formatoDTO = service.findOne(id);
		return ResponseUtil.wrapOrNotFound(formatoDTO);
	}

	/**
	 * DELETE /formato/:id : delete the "id" formato.
	 *
	 * @param id
	 *            the id of the formatoDTO to delete
	 * @return the ResponseEntity with status 200 (OK)
	 */
	@DeleteMapping("/formato/{id}")
	public ResponseEntity<Void> deleteFormato(@PathVariable Long id) {
		log.debug("REST request to delete Formato : {}", id);
		service.delete(id);
		return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
	}
}
