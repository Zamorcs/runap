package com.bindot.runap.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.bindot.runap.model.Avatar;
import com.bindot.runap.service.AvatarCriteriaService;
import com.bindot.runap.service.BaseService;
import com.bindot.runap.service.dto.AvatarCriteria;
import com.bindot.runap.service.dto.AvatarDTO;
import com.bindot.runap.web.rest.error.BadRequestAlertException;
import com.bindot.runap.web.rest.util.HeaderUtil;
import com.bindot.runap.web.rest.util.PaginationUtil;
import com.bindot.runap.web.rest.util.ResponseUtil;

import springfox.documentation.annotations.ApiIgnore;

/**
 * REST controller for managing Avatar.
 * 
 * @author Cesar Zamorano
 *
 */
@RestController
@RequestMapping("/api")
public class AvatarResource {

	private final Logger log = LoggerFactory.getLogger(AvatarResource.class);

	private static final String ENTITY_NAME = "avatar";

	@Autowired
	private final BaseService<Avatar, AvatarDTO> service;

	private final AvatarCriteriaService criteriaService;

	public AvatarResource(BaseService<Avatar, AvatarDTO> avatarService, AvatarCriteriaService avatarCriteriaService) {
		this.service = avatarService;
		this.criteriaService = avatarCriteriaService;
	}

	/**
	 * POST /avatar : Create a new avatar.
	 *
	 * @param avatarDTO
	 *            the avatarDTO to create
	 * @return the ResponseEntity with status 201 (Created) and with body the new
	 *         avatarDTO, or with status 400 (Bad Request) if the avatar has already
	 *         an ID
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PostMapping("/avatar")
	public ResponseEntity<AvatarDTO> createAvatar(@Valid @RequestBody AvatarDTO avatarDTO) throws URISyntaxException {
		log.debug("REST request to save Avatar : {}", avatarDTO);
		if (avatarDTO.getId() != null) {
			throw new BadRequestAlertException("A new avatar cannot already have an ID", ENTITY_NAME, "idexists");
		}
		if (avatarDTO.getEnabled() == null) {
			avatarDTO.setEnabled(true);
		}
		AvatarDTO result = service.save(avatarDTO);
		return ResponseEntity.created(new URI("/api/avatar/" + result.getId()))
				.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString())).body(result);
	}

	/**
	 * PUT /avatar : Updates an existing avatar.
	 *
	 * @param avatarDTO
	 *            the avatarDTO to update
	 * @return the ResponseEntity with status 200 (OK) and with body the updated
	 *         avatarDTO, or with status 400 (Bad Request) if the avatarDTO is not
	 *         valid, or with status 500 (Internal Server Error) if the avatarDTO
	 *         couldn't be updated
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PutMapping("/avatar")
	public ResponseEntity<AvatarDTO> updateAvatar(@Valid @RequestBody AvatarDTO avatarDTO) {
		log.debug("REST request to update Avatar : {}", avatarDTO);
		if (avatarDTO.getId() == null) {
			throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
		}
		AvatarDTO result = service.save(avatarDTO);
		return ResponseEntity.ok()
				.headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, avatarDTO.getId().toString())).body(result);
	}

	/**
	 * GET /avatar : get all the avatars.
	 *
	 * @param pageable
	 *            the pagination information
	 * @return the ResponseEntity with status 200 (OK) and the list of avatars in
	 *         body
	 */
	@ApiPageable
	@GetMapping("/avatar")
	public ResponseEntity<List<AvatarDTO>> getAllAvatars(@ApiIgnore @NonNull Pageable pageable) {
		String message = "REST request to get a page of Avatars";
		log.debug(message);
		Page<AvatarDTO> page = service.findAll(pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/avatar");
		return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	}

	/**
	 * GET /avatar/search : get all the avatars.
	 *
	 * @param pageable
	 *            the pagination information
	 * @param criteria
	 *            the criterias which the requested entities should match
	 * @return the ResponseEntity with status 200 (OK) and the list of avatars in
	 *         body
	 */
	@ApiPageable
	@GetMapping("/avatar/search")
	public ResponseEntity<List<AvatarDTO>> getAllAvatars(AvatarCriteria criteria,
			@ApiIgnore @NonNull Pageable pageable) {
		log.debug("REST request to get Avatars by criteria: {}", criteria);
		Page<AvatarDTO> page = criteriaService.findAllByCriteria(criteria, pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/avatar/search");
		return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	}

	/**
	 * GET /avatar/:id : get the "id" avatar.
	 *
	 * @param id
	 *            the id of the avatarDTO to retrieve
	 * @return the ResponseEntity with status 200 (OK) and with body the avatarDTO,
	 *         or with status 404 (Not Found)
	 */
	@GetMapping("/avatar/{id}")
	public ResponseEntity<AvatarDTO> getAvatar(@PathVariable Long id) {
		log.debug("REST request to get Avatar : {}", id);
		Optional<AvatarDTO> avatarDTO = service.findOne(id);
		return ResponseUtil.wrapOrNotFound(avatarDTO);
	}

	/**
	 * DELETE /avatar/:id : delete the "id" avatar.
	 *
	 * @param id
	 *            the id of the avatarDTO to delete
	 * @return the ResponseEntity with status 200 (OK)
	 */
	@DeleteMapping("/avatar/{id}")
	public ResponseEntity<Void> deleteAvatar(@PathVariable Long id) {
		log.debug("REST request to delete Avatar : {}", id);
		service.delete(id);
		return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
	}
}
