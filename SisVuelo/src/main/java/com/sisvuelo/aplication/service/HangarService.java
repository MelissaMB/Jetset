package com.sisvuelo.aplication.service;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sisvuelo.aplication.model.Hangar;
import com.sisvuelo.aplication.repository.HangarRepository;
import com.sisvuelo.aplication.filter.HangarFilter;

@Service
public class HangarService {

	private String errorDelete = "this record is related to other tables.";

    @Autowired
	private HangarRepository hangarRepository;

	@Transactional
	public void save(Hangar hangar) {
		hangarRepository.save(hangar);
	}
	
	public Page<Hangar> filter(HangarFilter hangarFilter, Pageable pageable) {
		return hangarRepository.filtrar(hangarFilter, pageable);
	}

	@Transactional
	public void delete(Hangar hangar) {
		try {
			hangarRepository.delete(hangar);
		} catch (Exception e) {
			if (e instanceof org.hibernate.exception.ConstraintViolationException
					|| e instanceof DataIntegrityViolationException) {
				throw new IllegalArgumentException(errorDelete);
			}
			throw e;
		}

	}

}
