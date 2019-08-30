package com.bindot.runap.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bindot.runap.model.Direccion;
import com.bindot.runap.repository.DireccionRepository;
import com.bindot.runap.service.dto.DireccionDTO;
import com.bindot.runap.service.mapper.EntityMapper;

@Service
@Transactional
public class DireccionService extends BaseService<Direccion, DireccionDTO> {

	public DireccionService(DireccionRepository repository, EntityMapper<DireccionDTO, Direccion> mapper) {
		super(repository, mapper);
	}


}
