/**
 * 
 */
package com.bindot.runap.service;

import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;

import com.bindot.runap.model.Imagen;
import com.bindot.runap.repository.BaseRepository;
import com.bindot.runap.service.dto.ImagenCriteria;
import com.bindot.runap.service.dto.ImagenDTO;
import com.bindot.runap.service.mapper.EntityMapper;
import com.bindot.runap.service.specification.ImagenSpecification;

/**
 * @author Cesar Zamorano
 *
 */
public class ImagenCriteriaService extends BaseCriteriaService<Imagen, ImagenDTO, ImagenCriteria> {

	/**
	 * @param repository
	 * @param mapper
	 */
	public ImagenCriteriaService(BaseRepository<Imagen> repository, EntityMapper<ImagenDTO, Imagen> mapper) {
		super(repository, mapper);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bindot.runap.service.BaseCriteriaService#createSpecification(java.lang.
	 * Object)
	 */
	@Override
	Specification<Imagen> createSpecification(ImagenCriteria criteria) {
		Specification<Imagen> specification = Specification.where(null);
		specification = Optional.ofNullable(criteria).map(ImagenCriteria::getDescripcion)
				.map(ImagenSpecification::likeToDescripcion).map(specification::and).orElse(specification);
		specification = Optional.ofNullable(criteria).map(ImagenCriteria::getEnabled)
				.map(ImagenSpecification::equalToEnabled).map(specification::and).orElse(specification);
		return specification;
	}

}
