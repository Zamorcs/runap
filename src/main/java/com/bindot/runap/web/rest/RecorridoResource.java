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

import com.bindot.runap.model.Recorrido;
import com.bindot.runap.service.BaseService;
import com.bindot.runap.service.RecorridoCriteriaService;
import com.bindot.runap.service.dto.RecorridoCriteria;
import com.bindot.runap.service.dto.RecorridoDTO;
import com.bindot.runap.web.rest.error.BadRequestAlertException;
import com.bindot.runap.web.rest.util.HeaderUtil;
import com.bindot.runap.web.rest.util.PaginationUtil;
import com.bindot.runap.web.rest.util.ResponseUtil;

import springfox.documentation.annotations.ApiIgnore;

/**
 * REST controller for managing Recorrido.
 * 
 * @author Cesar Zamorano
 *
 */
@RestController
@RequestMapping("/api")
public class RecorridoResource {

	private final Logger log = LoggerFactory.getLogger(RecorridoResource.class);

	private static final String ENTITY_NAME = "recorrido";

	private final BaseService<Recorrido, RecorridoDTO> service;

	private final RecorridoCriteriaService criteriaService;

	public RecorridoResource(BaseService<Recorrido, RecorridoDTO> recorridoService,
			RecorridoCriteriaService recorridoCriteriaService) {
		this.service = recorridoService;
		this.criteriaService = recorridoCriteriaService;
	}

	/**
	 * POST /recorrido : Create a new recorrido.
	 *
	 * @param recorridoDTO
	 *            the recorridoDTO to create
	 * @return the ResponseEntity with status 201 (Created) and with body the new
	 *         recorridoDTO, or with status 400 (Bad Request) if the recorrido has
	 *         already an ID
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PostMapping("/recorrido")
	public ResponseEntity<RecorridoDTO> createRecorrido(@Valid @RequestBody RecorridoDTO recorridoDTO)
			throws URISyntaxException {
		log.debug("REST request to save Recorrido : {}", recorridoDTO);
		if (recorridoDTO.getId() != null) {
			throw new BadRequestAlertException("A new recorrido cannot already have an ID", ENTITY_NAME, "idexists");
		}
		if (recorridoDTO.getEnabled() == null) {
			recorridoDTO.setEnabled(true);
		}
		RecorridoDTO result = service.save(recorridoDTO);
		return ResponseEntity.created(new URI("/api/recorrido/" + result.getId()))
				.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString())).body(result);
	}

	/**
	 * PUT /recorrido : Updates an existing recorrido.
	 *
	 * @param recorridoDTO
	 *            the recorridoDTO to update
	 * @return the ResponseEntity with status 200 (OK) and with body the updated
	 *         recorridoDTO, or with status 400 (Bad Request) if the recorridoDTO is
	 *         not valid, or with status 500 (Internal Server Error) if the
	 *         recorridoDTO couldn't be updated
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PutMapping("/recorrido")
	public ResponseEntity<RecorridoDTO> updateRecorrido(@Valid @RequestBody RecorridoDTO recorridoDTO) {
		log.debug("REST request to update Recorrido : {}", recorridoDTO);
		if (recorridoDTO.getId() == null) {
			throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
		}
		RecorridoDTO result = service.save(recorridoDTO);
		return ResponseEntity.ok()
				.headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, recorridoDTO.getId().toString())).body(result);
	}

	/**
	 * GET /recorrido : get all the recorridos.
	 *
	 * @param pageable
	 *            the pagination information
	 * @return the ResponseEntity with status 200 (OK) and the list of recorridos in
	 *         body
	 */
	@ApiPageable
	@GetMapping("/recorrido")
	public ResponseEntity<List<RecorridoDTO>> getAllRecorridos(@ApiIgnore @NonNull Pageable pageable) {
		String message = "REST request to get a page of Recorridos";
		log.debug(message);
		Page<RecorridoDTO> page = service.findAll(pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/recorrido");
		return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	}

	/**
	 * GET /recorrido/search : get all the recorridos.
	 *
	 * @param pageable
	 *            the pagination information
	 * @param criteria
	 *            the criterias which the requested entities should match
	 * @return the ResponseEntity with status 200 (OK) and the list of recorridos in
	 *         body
	 */
	@ApiPageable
	@GetMapping("/recorrido/search")
	public ResponseEntity<List<RecorridoDTO>> getAllRecorridos(RecorridoCriteria criteria,
			@ApiIgnore @NonNull Pageable pageable) {
		log.debug("REST request to get Recorridos by criteria: {}", criteria);
		Page<RecorridoDTO> page = criteriaService.findAllByCriteria(criteria, pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/recorrido/search");
		return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	}

	/**
	 * GET /recorrido/:id : get the "id" recorrido.
	 *
	 * @param id
	 *            the id of the recorridoDTO to retrieve
	 * @return the ResponseEntity with status 200 (OK) and with body the
	 *         recorridoDTO, or with status 404 (Not Found)
	 */
	@GetMapping("/recorrido/{id}")
	public ResponseEntity<RecorridoDTO> getRecorrido(@PathVariable Long id) {
		log.debug("REST request to get Recorrido : {}", id);
		Optional<RecorridoDTO> recorridoDTO = service.findOne(id);
		return ResponseUtil.wrapOrNotFound(recorridoDTO);
	}

	/**
	 * DELETE /recorrido/:id : delete the "id" recorrido.
	 *
	 * @param id
	 *            the id of the recorridoDTO to delete
	 * @return the ResponseEntity with status 200 (OK)
	 */
	@DeleteMapping("/recorrido/{id}")
	public ResponseEntity<Void> deleteRecorrido(@PathVariable Long id) {
		log.debug("REST request to delete Recorrido : {}", id);
		service.delete(id);
		return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
	}
}
