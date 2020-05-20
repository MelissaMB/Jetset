package com.sisvuelo.aplication.service;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sisvuelo.aplication.model.Ciudad;
import com.sisvuelo.aplication.repository.CiudadRepository;
import com.sisvuelo.aplication.filter.CiudadFilter;

@Service
public class CiudadService {

	private String errorDelete = "this record is related to other tables.";

    @Autowired
	private CiudadRepository ciudadRepository;

	@Transactional
	public void save(Ciudad ciudad) {
		ciudadRepository.save(ciudad);
	}
	
	public Page<Ciudad> filter(CiudadFilter ciudadFilter, Pageable pageable) {
		return ciudadRepository.filtrar(ciudadFilter, pageable);
	}

	@Transactional
	public void delete(Ciudad ciudad) {
		try {
			ciudadRepository.delete(ciudad);
		} catch (Exception e) {
			if (e instanceof org.hibernate.exception.ConstraintViolationException
					|| e instanceof DataIntegrityViolationException) {
				throw new IllegalArgumentException(errorDelete);
			}
			throw e;
		}

	}

}
