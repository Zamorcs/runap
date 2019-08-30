package com.bindot.runap.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bindot.runap.model.EstadoCalendario;
import com.bindot.runap.repository.EstadoCalendarioRepository;
import com.bindot.runap.service.dto.EstadoCalendarioDTO;
import com.bindot.runap.service.mapper.EntityMapper;

@Service
@Transactional
public class EstadoCalendarioService extends BaseService<EstadoCalendario, EstadoCalendarioDTO> {

	public EstadoCalendarioService(EstadoCalendarioRepository repository, EntityMapper<EstadoCalendarioDTO, EstadoCalendario> mapper) {
		super(repository, mapper);
	}


}
