package com.bindot.runap.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bindot.runap.model.CarreraGuardada;
import com.bindot.runap.repository.CarreraGuardadaRepository;
import com.bindot.runap.service.dto.CarreraGuardadaDTO;
import com.bindot.runap.service.mapper.EntityMapper;

@Service
@Transactional
public class CarreraGuardadaService extends BaseService<CarreraGuardada, CarreraGuardadaDTO>{

	public CarreraGuardadaService(CarreraGuardadaRepository repository,
			EntityMapper<CarreraGuardadaDTO, CarreraGuardada> mapper) {
		super(repository, mapper);
	}

}
