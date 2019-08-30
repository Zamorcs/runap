package com.bindot.runap.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bindot.runap.model.Corredor;
import com.bindot.runap.repository.CorredorRepository;
import com.bindot.runap.service.dto.CorredorDTO;
import com.bindot.runap.service.mapper.EntityMapper;

@Service
@Transactional
public class CorredorService extends BaseService<Corredor, CorredorDTO> {

	public CorredorService(CorredorRepository repository, EntityMapper<CorredorDTO, Corredor> mapper) {
		super(repository, mapper);
	}


}
