package com.bindot.runap.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bindot.runap.model.Calendario;
import com.bindot.runap.repository.CalendarioRepository;
import com.bindot.runap.service.dto.CalendarioDTO;
import com.bindot.runap.service.mapper.EntityMapper;

@Service
@Transactional
public class CalendarioService extends BaseService<Calendario, CalendarioDTO> {

	public CalendarioService(CalendarioRepository repository, EntityMapper<CalendarioDTO, Calendario> mapper) {
		super(repository, mapper);
	}


}
