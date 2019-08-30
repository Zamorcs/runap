package com.bindot.runap.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bindot.runap.model.Formato;
import com.bindot.runap.repository.FormatoRepository;
import com.bindot.runap.service.dto.FormatoDTO;
import com.bindot.runap.service.mapper.EntityMapper;

@Service
@Transactional
public class FormatoService extends BaseService<Formato, FormatoDTO> {

	public FormatoService(FormatoRepository repository, EntityMapper<FormatoDTO, Formato> mapper) {
		super(repository, mapper);
	}


}
