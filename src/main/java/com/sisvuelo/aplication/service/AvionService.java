package com.sisvuelo.aplication.service;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sisvuelo.aplication.model.Avion;
import com.sisvuelo.aplication.repository.AvionRepository;
import com.sisvuelo.aplication.filter.AvionFilter;

@Service
public class AvionService {

	private String errorDelete = "this record is related to other tables.";

    @Autowired
	private AvionRepository avionRepository;

	@Transactional
	public void save(Avion avion) {
		avionRepository.save(avion);
	}
	
	public Page<Avion> filter(AvionFilter avionFilter, Pageable pageable) {
		return avionRepository.filtrar(avionFilter, pageable);
	}

	@Transactional
	public void delete(Avion avion) {
		try {
			avionRepository.delete(avion);
		} catch (Exception e) {
			if (e instanceof org.hibernate.exception.ConstraintViolationException
					|| e instanceof DataIntegrityViolationException) {
				throw new IllegalArgumentException(errorDelete);
			}
			throw e;
		}

	}

}
