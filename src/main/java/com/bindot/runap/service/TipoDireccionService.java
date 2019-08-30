package com.bindot.runap.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bindot.runap.model.TipoDireccion;
import com.bindot.runap.repository.TipoDireccionRepository;
import com.bindot.runap.service.dto.TipoDireccionDTO;
import com.bindot.runap.service.mapper.EntityMapper;

@Service
@Transactional
public class TipoDireccionService extends BaseService<TipoDireccion, TipoDireccionDTO> {

	public TipoDireccionService(TipoDireccionRepository repository, EntityMapper<TipoDireccionDTO, TipoDireccion> mapper) {
		super(repository, mapper);
	}


}
