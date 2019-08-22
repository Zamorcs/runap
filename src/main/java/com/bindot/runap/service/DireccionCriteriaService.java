package com.bindot.runap.service;

import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;

import com.bindot.runap.model.Direccion;
import com.bindot.runap.repository.BaseRepository;
import com.bindot.runap.service.dto.DireccionCriteria;
import com.bindot.runap.service.dto.DireccionDTO;
import com.bindot.runap.service.mapper.EntityMapper;
import com.bindot.runap.service.specification.DireccionSpecification;

/**
 * @author Cesar Zamorano
 *
 */
public class DireccionCriteriaService extends BaseCriteriaService<Direccion, DireccionDTO, DireccionCriteria> {

	/**
	 * @param repository
	 * @param mapper
	 */
	public DireccionCriteriaService(BaseRepository<Direccion> repository,
			EntityMapper<DireccionDTO, Direccion> mapper) {
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
	Specification<Direccion> createSpecification(DireccionCriteria criteria) {
		Specification<Direccion> specification = Specification.where(null);
		specification = Optional.ofNullable(criteria).map(DireccionCriteria::getCodigoPostal)
				.map(DireccionSpecification::likeToCodigoPostal).map(specification::and).orElse(specification);
		specification = Optional.ofNullable(criteria).map(DireccionCriteria::getEnabled)
				.map(DireccionSpecification::equalToEnabled).map(specification::and).orElse(specification);
		specification = Optional.ofNullable(criteria).map(DireccionCriteria::getCalle)
				.map(DireccionSpecification::likeToCalle).map(specification::and).orElse(specification);
		specification = Optional.ofNullable(criteria).map(DireccionCriteria::getNumero)
				.map(DireccionSpecification::equalToNumero).map(specification::and).orElse(specification);
		specification = Optional.ofNullable(criteria).map(DireccionCriteria::getLocalidad)
				.map(DireccionSpecification::likeToLocalidad).map(specification::and).orElse(specification);
		specification = Optional.ofNullable(criteria).map(DireccionCriteria::getNotas)
				.map(DireccionSpecification::likeToLocalidad).map(specification::and).orElse(specification);
		specification = Optional.ofNullable(criteria).map(DireccionCriteria::getProvincia)
				.map(DireccionSpecification::likeToProvincia).map(specification::and).orElse(specification);
		specification = Optional.ofNullable(criteria).map(DireccionCriteria::getPais)
				.map(DireccionSpecification::likeToPais).map(specification::and).orElse(specification);
		return specification;
	}

}
