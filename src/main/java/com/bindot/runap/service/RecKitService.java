package com.bindot.runap.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bindot.runap.model.RecKit;
import com.bindot.runap.repository.RecKitRepository;
import com.bindot.runap.service.dto.RecKitDTO;
import com.bindot.runap.service.mapper.EntityMapper;

@Service
@Transactional
public class RecKitService extends BaseService<RecKit, RecKitDTO> {

	public RecKitService(RecKitRepository repository, EntityMapper<RecKitDTO, RecKit> mapper) {
		super(repository, mapper);
	}


}
