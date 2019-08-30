package com.bindot.runap.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bindot.runap.model.Imagen;
import com.bindot.runap.repository.ImagenRepository;
import com.bindot.runap.service.dto.ImagenDTO;
import com.bindot.runap.service.mapper.EntityMapper;

@Service
@Transactional
public class ImagenService extends BaseService<Imagen, ImagenDTO> {

	public ImagenService(ImagenRepository repository, EntityMapper<ImagenDTO, Imagen> mapper) {
		super(repository, mapper);
	}


}
