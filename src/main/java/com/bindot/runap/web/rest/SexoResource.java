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

import com.bindot.runap.model.Sexo;
import com.bindot.runap.service.BaseService;
import com.bindot.runap.service.SexoCriteriaService;
import com.bindot.runap.service.dto.SexoCriteria;
import com.bindot.runap.service.dto.SexoDTO;
import com.bindot.runap.web.rest.error.BadRequestAlertException;
import com.bindot.runap.web.rest.util.HeaderUtil;
import com.bindot.runap.web.rest.util.PaginationUtil;
import com.bindot.runap.web.rest.util.ResponseUtil;

import springfox.documentation.annotations.ApiIgnore;

/**
 * REST controller for managing Sexo.
 * 
 * @author Cesar Zamorano
 *
 */
@RestController
@RequestMapping("/api")
public class SexoResource {

	private final Logger log = LoggerFactory.getLogger(SexoResource.class);

	private static final String ENTITY_NAME = "sexo";

	private final BaseService<Sexo, SexoDTO> service;

	private final SexoCriteriaService criteriaService;

	public SexoResource(BaseService<Sexo, SexoDTO> sexoService, SexoCriteriaService sexoCriteriaService) {
		this.service = sexoService;
		this.criteriaService = sexoCriteriaService;
	}

	/**
	 * POST /sexo : Create a new sexo.
	 *
	 * @param sexoDTO
	 *            the sexoDTO to create
	 * @return the ResponseEntity with status 201 (Created) and with body the new
	 *         sexoDTO, or with status 400 (Bad Request) if the sexo has already an
	 *         ID
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PostMapping("/sexo")
	public ResponseEntity<SexoDTO> createSexo(@Valid @RequestBody SexoDTO sexoDTO) throws URISyntaxException {
		log.debug("REST request to save Sexo : {}", sexoDTO);
		if (sexoDTO.getId() != null) {
			throw new BadRequestAlertException("A new sexo cannot already have an ID", ENTITY_NAME, "idexists");
		}
		if (sexoDTO.getEnabled() == null) {
			sexoDTO.setEnabled(true);
		}
		SexoDTO result = service.save(sexoDTO);
		return ResponseEntity.created(new URI("/api/sexo/" + result.getId()))
				.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString())).body(result);
	}

	/**
	 * PUT /sexo : Updates an existing sexo.
	 *
	 * @param sexoDTO
	 *            the sexoDTO to update
	 * @return the ResponseEntity with status 200 (OK) and with body the updated
	 *         sexoDTO, or with status 400 (Bad Request) if the sexoDTO is not
	 *         valid, or with status 500 (Internal Server Error) if the sexoDTO
	 *         couldn't be updated
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PutMapping("/sexo")
	public ResponseEntity<SexoDTO> updateSexo(@Valid @RequestBody SexoDTO sexoDTO) {
		log.debug("REST request to update Sexo : {}", sexoDTO);
		if (sexoDTO.getId() == null) {
			throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
		}
		SexoDTO result = service.save(sexoDTO);
		return ResponseEntity.ok().headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, sexoDTO.getId().toString()))
				.body(result);
	}

	/**
	 * GET /sexo : get all the sexos.
	 *
	 * @param pageable
	 *            the pagination information
	 * @return the ResponseEntity with status 200 (OK) and the list of sexos in body
	 */
	@ApiPageable
	@GetMapping("/sexo")
	public ResponseEntity<List<SexoDTO>> getAllSexos(@ApiIgnore @NonNull Pageable pageable) {
		String message = "REST request to get a page of Sexos";
		log.debug(message);
		Page<SexoDTO> page = service.findAll(pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/sexo");
		return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	}

	/**
	 * GET /sexo/search : get all the sexos.
	 *
	 * @param pageable
	 *            the pagination information
	 * @param criteria
	 *            the criterias which the requested entities should match
	 * @return the ResponseEntity with status 200 (OK) and the list of sexos in body
	 */
	@ApiPageable
	@GetMapping("/sexo/search")
	public ResponseEntity<List<SexoDTO>> getAllSexos(SexoCriteria criteria, @ApiIgnore @NonNull Pageable pageable) {
		log.debug("REST request to get Sexos by criteria: {}", criteria);
		Page<SexoDTO> page = criteriaService.findAllByCriteria(criteria, pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/sexo/search");
		return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	}

	/**
	 * GET /sexo/:id : get the "id" sexo.
	 *
	 * @param id
	 *            the id of the sexoDTO to retrieve
	 * @return the ResponseEntity with status 200 (OK) and with body the sexoDTO, or
	 *         with status 404 (Not Found)
	 */
	@GetMapping("/sexo/{id}")
	public ResponseEntity<SexoDTO> getSexo(@PathVariable Long id) {
		log.debug("REST request to get Sexo : {}", id);
		Optional<SexoDTO> sexoDTO = service.findOne(id);
		return ResponseUtil.wrapOrNotFound(sexoDTO);
	}

	/**
	 * DELETE /sexo/:id : delete the "id" sexo.
	 *
	 * @param id
	 *            the id of the sexoDTO to delete
	 * @return the ResponseEntity with status 200 (OK)
	 */
	@DeleteMapping("/sexo/{id}")
	public ResponseEntity<Void> deleteSexo(@PathVariable Long id) {
		log.debug("REST request to delete Sexo : {}", id);
		service.delete(id);
		return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
	}
}
