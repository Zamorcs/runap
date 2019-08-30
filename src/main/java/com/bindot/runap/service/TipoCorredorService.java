package com.bindot.runap.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bindot.runap.model.TipoCorredor;
import com.bindot.runap.repository.TipoCorredorRepository;
import com.bindot.runap.service.dto.TipoCorredorDTO;
import com.bindot.runap.service.mapper.EntityMapper;

@Service
@Transactional
public class TipoCorredorService extends BaseService<TipoCorredor, TipoCorredorDTO> {

	public TipoCorredorService(TipoCorredorRepository repository, EntityMapper<TipoCorredorDTO, TipoCorredor> mapper) {
		super(repository, mapper);
	}


}
