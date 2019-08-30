package com.bindot.runap.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bindot.runap.model.Documentacion;
import com.bindot.runap.repository.DocumentacionRepository;
import com.bindot.runap.service.dto.DocumentacionDTO;
import com.bindot.runap.service.mapper.EntityMapper;

@Service
@Transactional
public class DocumentacionService extends BaseService<Documentacion, DocumentacionDTO> {

	public DocumentacionService(DocumentacionRepository repository, EntityMapper<DocumentacionDTO, Documentacion> mapper) {
		super(repository, mapper);
	}


}
