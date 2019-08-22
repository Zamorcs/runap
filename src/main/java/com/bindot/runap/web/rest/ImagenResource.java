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

import com.bindot.runap.model.Imagen;
import com.bindot.runap.service.BaseService;
import com.bindot.runap.service.ImagenCriteriaService;
import com.bindot.runap.service.dto.ImagenCriteria;
import com.bindot.runap.service.dto.ImagenDTO;
import com.bindot.runap.web.rest.error.BadRequestAlertException;
import com.bindot.runap.web.rest.util.HeaderUtil;
import com.bindot.runap.web.rest.util.PaginationUtil;
import com.bindot.runap.web.rest.util.ResponseUtil;

import springfox.documentation.annotations.ApiIgnore;

/**
 * REST controller for managing Imagen.
 * 
 * @author Cesar Zamorano
 *
 */
@RestController
@RequestMapping("/api")
public class ImagenResource {

	private final Logger log = LoggerFactory.getLogger(ImagenResource.class);

	private static final String ENTITY_NAME = "imagen";

	private final BaseService<Imagen, ImagenDTO> service;

	private final ImagenCriteriaService criteriaService;

	public ImagenResource(BaseService<Imagen, ImagenDTO> imagenService, ImagenCriteriaService imagenCriteriaService) {
		this.service = imagenService;
		this.criteriaService = imagenCriteriaService;
	}

	/**
	 * POST /imagen : Create a new imagen.
	 *
	 * @param imagenDTO
	 *            the imagenDTO to create
	 * @return the ResponseEntity with status 201 (Created) and with body the new
	 *         imagenDTO, or with status 400 (Bad Request) if the imagen has already
	 *         an ID
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PostMapping("/imagen")
	public ResponseEntity<ImagenDTO> createImagen(@Valid @RequestBody ImagenDTO imagenDTO) throws URISyntaxException {
		log.debug("REST request to save Imagen : {}", imagenDTO);
		if (imagenDTO.getId() != null) {
			throw new BadRequestAlertException("A new imagen cannot already have an ID", ENTITY_NAME, "idexists");
		}
		if (imagenDTO.getEnabled() == null) {
			imagenDTO.setEnabled(true);
		}
		ImagenDTO result = service.save(imagenDTO);
		return ResponseEntity.created(new URI("/api/imagen/" + result.getId()))
				.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString())).body(result);
	}

	/**
	 * PUT /imagen : Updates an existing imagen.
	 *
	 * @param imagenDTO
	 *            the imagenDTO to update
	 * @return the ResponseEntity with status 200 (OK) and with body the updated
	 *         imagenDTO, or with status 400 (Bad Request) if the imagenDTO is not
	 *         valid, or with status 500 (Internal Server Error) if the imagenDTO
	 *         couldn't be updated
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PutMapping("/imagen")
	public ResponseEntity<ImagenDTO> updateImagen(@Valid @RequestBody ImagenDTO imagenDTO) {
		log.debug("REST request to update Imagen : {}", imagenDTO);
		if (imagenDTO.getId() == null) {
			throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
		}
		ImagenDTO result = service.save(imagenDTO);
		return ResponseEntity.ok()
				.headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, imagenDTO.getId().toString())).body(result);
	}

	/**
	 * GET /imagen : get all the imagens.
	 *
	 * @param pageable
	 *            the pagination information
	 * @return the ResponseEntity with status 200 (OK) and the list of imagens in
	 *         body
	 */
	@ApiPageable
	@GetMapping("/imagen")
	public ResponseEntity<List<ImagenDTO>> getAllImagens(@ApiIgnore @NonNull Pageable pageable) {
		String message = "REST request to get a page of Imagens";
		log.debug(message);
		Page<ImagenDTO> page = service.findAll(pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/imagen");
		return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	}

	/**
	 * GET /imagen/search : get all the imagens.
	 *
	 * @param pageable
	 *            the pagination information
	 * @param criteria
	 *            the criterias which the requested entities should match
	 * @return the ResponseEntity with status 200 (OK) and the list of imagens in
	 *         body
	 */
	@ApiPageable
	@GetMapping("/imagen/search")
	public ResponseEntity<List<ImagenDTO>> getAllImagens(ImagenCriteria criteria,
			@ApiIgnore @NonNull Pageable pageable) {
		log.debug("REST request to get Imagens by criteria: {}", criteria);
		Page<ImagenDTO> page = criteriaService.findAllByCriteria(criteria, pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/imagen/search");
		return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	}

	/**
	 * GET /imagen/:id : get the "id" imagen.
	 *
	 * @param id
	 *            the id of the imagenDTO to retrieve
	 * @return the ResponseEntity with status 200 (OK) and with body the imagenDTO,
	 *         or with status 404 (Not Found)
	 */
	@GetMapping("/imagen/{id}")
	public ResponseEntity<ImagenDTO> getImagen(@PathVariable Long id) {
		log.debug("REST request to get Imagen : {}", id);
		Optional<ImagenDTO> imagenDTO = service.findOne(id);
		return ResponseUtil.wrapOrNotFound(imagenDTO);
	}

	/**
	 * DELETE /imagen/:id : delete the "id" imagen.
	 *
	 * @param id
	 *            the id of the imagenDTO to delete
	 * @return the ResponseEntity with status 200 (OK)
	 */
	@DeleteMapping("/imagen/{id}")
	public ResponseEntity<Void> deleteImagen(@PathVariable Long id) {
		log.debug("REST request to delete Imagen : {}", id);
		service.delete(id);
		return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
	}
}
