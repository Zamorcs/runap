package com.bindot.runap.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bindot.runap.model.Recorrido;
import com.bindot.runap.repository.RecorridoRepository;
import com.bindot.runap.service.dto.RecorridoDTO;
import com.bindot.runap.service.mapper.EntityMapper;

@Service
@Transactional
public class RecorridoService extends BaseService<Recorrido, RecorridoDTO> {

	public RecorridoService(RecorridoRepository repository, EntityMapper<RecorridoDTO, Recorrido> mapper) {
		super(repository, mapper);
	}


}
