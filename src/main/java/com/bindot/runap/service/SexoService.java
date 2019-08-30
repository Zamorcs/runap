package com.bindot.runap.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bindot.runap.model.Sexo;
import com.bindot.runap.repository.SexoRepository;
import com.bindot.runap.service.dto.SexoDTO;
import com.bindot.runap.service.mapper.EntityMapper;

@Service
@Transactional
public class SexoService extends BaseService<Sexo, SexoDTO> {

	public SexoService(SexoRepository repository, EntityMapper<SexoDTO, Sexo> mapper) {
		super(repository, mapper);
	}


}
