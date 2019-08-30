/**
 * 
 */
package com.bindot.runap.service.criteria;

import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bindot.runap.model.Imagen;
import com.bindot.runap.repository.ImagenRepository;
import com.bindot.runap.service.dto.ImagenCriteria;
import com.bindot.runap.service.dto.ImagenDTO;
import com.bindot.runap.service.mapper.EntityMapper;
import com.bindot.runap.service.specification.ImagenSpecification;

/**
 * @author Cesar Zamorano
 *
 */
@Service
@Transactional(readOnly = true)
public class ImagenCriteriaService extends BaseCriteriaService<Imagen, ImagenDTO, ImagenCriteria> {

	/**
	 * @param repository
	 * @param mapper
	 */
	public ImagenCriteriaService(ImagenRepository repository, EntityMapper<ImagenDTO, Imagen> mapper) {
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
