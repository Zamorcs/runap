package com.bindot.runap.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bindot.runap.model.Precio;
import com.bindot.runap.repository.PrecioRepository;
import com.bindot.runap.service.dto.PrecioDTO;
import com.bindot.runap.service.mapper.EntityMapper;

@Service
@Transactional
public class PrecioService extends BaseService<Precio, PrecioDTO> {

	public PrecioService(PrecioRepository repository, EntityMapper<PrecioDTO, Precio> mapper) {
		super(repository, mapper);
	}


}
