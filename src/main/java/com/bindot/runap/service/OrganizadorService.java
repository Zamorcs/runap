package com.bindot.runap.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bindot.runap.model.Organizador;
import com.bindot.runap.repository.OrganizadorRepository;
import com.bindot.runap.service.dto.OrganizadorDTO;
import com.bindot.runap.service.mapper.EntityMapper;

@Service
@Transactional
public class OrganizadorService extends BaseService<Organizador, OrganizadorDTO> {

	public OrganizadorService(OrganizadorRepository repository, EntityMapper<OrganizadorDTO, Organizador> mapper) {
		super(repository, mapper);
	}


}
