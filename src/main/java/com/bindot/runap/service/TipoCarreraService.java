package com.bindot.runap.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bindot.runap.model.TipoCarrera;
import com.bindot.runap.repository.TipoCarreraRepository;
import com.bindot.runap.service.dto.TipoCarreraDTO;
import com.bindot.runap.service.mapper.EntityMapper;

@Service
@Transactional
public class TipoCarreraService extends BaseService<TipoCarrera, TipoCarreraDTO> {

	public TipoCarreraService(TipoCarreraRepository repository, EntityMapper<TipoCarreraDTO, TipoCarrera> mapper) {
		super(repository, mapper);
	}


}
