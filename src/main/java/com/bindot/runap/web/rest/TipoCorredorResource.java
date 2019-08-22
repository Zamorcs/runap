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

import com.bindot.runap.model.TipoCorredor;
import com.bindot.runap.service.BaseService;
import com.bindot.runap.service.TipoCorredorCriteriaService;
import com.bindot.runap.service.dto.TipoCorredorCriteria;
import com.bindot.runap.service.dto.TipoCorredorDTO;
import com.bindot.runap.web.rest.error.BadRequestAlertException;
import com.bindot.runap.web.rest.util.HeaderUtil;
import com.bindot.runap.web.rest.util.PaginationUtil;
import com.bindot.runap.web.rest.util.ResponseUtil;

import springfox.documentation.annotations.ApiIgnore;

/**
 * REST controller for managing TipoCorredor.
 * 
 * @author Cesar Zamorano
 *
 */
@RestController
@RequestMapping("/api")
public class TipoCorredorResource {

	private final Logger log = LoggerFactory.getLogger(TipoCorredorResource.class);

	private static final String ENTITY_NAME = "tipoCorredor";

	private final BaseService<TipoCorredor, TipoCorredorDTO> service;

	private final TipoCorredorCriteriaService criteriaService;

	public TipoCorredorResource(BaseService<TipoCorredor, TipoCorredorDTO> tipoCorredorService,
			TipoCorredorCriteriaService tipoCorredorCriteriaService) {
		this.service = tipoCorredorService;
		this.criteriaService = tipoCorredorCriteriaService;
	}

	/**
	 * POST /tipoCorredor : Create a new tipoCorredor.
	 *
	 * @param tipoCorredorDTO
	 *            the tipoCorredorDTO to create
	 * @return the ResponseEntity with status 201 (Created) and with body the new
	 *         tipoCorredorDTO, or with status 400 (Bad Request) if the tipoCorredor
	 *         has already an ID
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PostMapping("/tipoCorredor")
	public ResponseEntity<TipoCorredorDTO> createTipoCorredor(@Valid @RequestBody TipoCorredorDTO tipoCorredorDTO)
			throws URISyntaxException {
		log.debug("REST request to save TipoCorredor : {}", tipoCorredorDTO);
		if (tipoCorredorDTO.getId() != null) {
			throw new BadRequestAlertException("A new tipoCorredor cannot already have an ID", ENTITY_NAME, "idexists");
		}
		if (tipoCorredorDTO.getEnabled() == null) {
			tipoCorredorDTO.setEnabled(true);
		}
		TipoCorredorDTO result = service.save(tipoCorredorDTO);
		return ResponseEntity.created(new URI("/api/tipoCorredor/" + result.getId()))
				.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString())).body(result);
	}

	/**
	 * PUT /tipoCorredor : Updates an existing tipoCorredor.
	 *
	 * @param tipoCorredorDTO
	 *            the tipoCorredorDTO to update
	 * @return the ResponseEntity with status 200 (OK) and with body the updated
	 *         tipoCorredorDTO, or with status 400 (Bad Request) if the
	 *         tipoCorredorDTO is not valid, or with status 500 (Internal Server
	 *         Error) if the tipoCorredorDTO couldn't be updated
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PutMapping("/tipoCorredor")
	public ResponseEntity<TipoCorredorDTO> updateTipoCorredor(@Valid @RequestBody TipoCorredorDTO tipoCorredorDTO) {
		log.debug("REST request to update TipoCorredor : {}", tipoCorredorDTO);
		if (tipoCorredorDTO.getId() == null) {
			throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
		}
		TipoCorredorDTO result = service.save(tipoCorredorDTO);
		return ResponseEntity.ok()
				.headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, tipoCorredorDTO.getId().toString()))
				.body(result);
	}

	/**
	 * GET /tipoCorredor : get all the tipoCorredors.
	 *
	 * @param pageable
	 *            the pagination information
	 * @return the ResponseEntity with status 200 (OK) and the list of tipoCorredors
	 *         in body
	 */
	@ApiPageable
	@GetMapping("/tipoCorredor")
	public ResponseEntity<List<TipoCorredorDTO>> getAllTipoCorredors(@ApiIgnore @NonNull Pageable pageable) {
		String message = "REST request to get a page of TipoCorredors";
		log.debug(message);
		Page<TipoCorredorDTO> page = service.findAll(pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/tipoCorredor");
		return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	}

	/**
	 * GET /tipoCorredor/search : get all the tipoCorredors.
	 *
	 * @param pageable
	 *            the pagination information
	 * @param criteria
	 *            the criterias which the requested entities should match
	 * @return the ResponseEntity with status 200 (OK) and the list of tipoCorredors
	 *         in body
	 */
	@ApiPageable
	@GetMapping("/tipoCorredor/search")
	public ResponseEntity<List<TipoCorredorDTO>> getAllTipoCorredors(TipoCorredorCriteria criteria,
			@ApiIgnore @NonNull Pageable pageable) {
		log.debug("REST request to get TipoCorredors by criteria: {}", criteria);
		Page<TipoCorredorDTO> page = criteriaService.findAllByCriteria(criteria, pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/tipoCorredor/search");
		return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	}

	/**
	 * GET /tipoCorredor/:id : get the "id" tipoCorredor.
	 *
	 * @param id
	 *            the id of the tipoCorredorDTO to retrieve
	 * @return the ResponseEntity with status 200 (OK) and with body the
	 *         tipoCorredorDTO, or with status 404 (Not Found)
	 */
	@GetMapping("/tipoCorredor/{id}")
	public ResponseEntity<TipoCorredorDTO> getTipoCorredor(@PathVariable Long id) {
		log.debug("REST request to get TipoCorredor : {}", id);
		Optional<TipoCorredorDTO> tipoCorredorDTO = service.findOne(id);
		return ResponseUtil.wrapOrNotFound(tipoCorredorDTO);
	}

	/**
	 * DELETE /tipoCorredor/:id : delete the "id" tipoCorredor.
	 *
	 * @param id
	 *            the id of the tipoCorredorDTO to delete
	 * @return the ResponseEntity with status 200 (OK)
	 */
	@DeleteMapping("/tipoCorredor/{id}")
	public ResponseEntity<Void> deleteTipoCorredor(@PathVariable Long id) {
		log.debug("REST request to delete TipoCorredor : {}", id);
		service.delete(id);
		return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
	}
}
