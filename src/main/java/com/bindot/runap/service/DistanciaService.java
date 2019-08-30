package com.bindot.runap.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bindot.runap.model.Distancia;
import com.bindot.runap.repository.DistanciaRepository;
import com.bindot.runap.service.dto.DistanciaDTO;
import com.bindot.runap.service.mapper.EntityMapper;

@Service
@Transactional
public class DistanciaService extends BaseService<Distancia, DistanciaDTO> {

	public DistanciaService(DistanciaRepository repository, EntityMapper<DistanciaDTO, Distancia> mapper) {
		super(repository, mapper);
	}


}
