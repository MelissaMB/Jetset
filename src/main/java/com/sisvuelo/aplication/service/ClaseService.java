package com.sisvuelo.aplication.service;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sisvuelo.aplication.model.Clase;
import com.sisvuelo.aplication.repository.ClaseRepository;
import com.sisvuelo.aplication.filter.ClaseFilter;

@Service
public class ClaseService {

	private String errorDelete = "this record is related to other tables.";

    @Autowired
	private ClaseRepository claseRepository;

	@Transactional
	public void save(Clase clase) {
		claseRepository.save(clase);
	}
	
	public Page<Clase> filter(ClaseFilter claseFilter, Pageable pageable) {
		return claseRepository.filtrar(claseFilter, pageable);
	}

	@Transactional
	public void delete(Clase clase) {
		try {
			claseRepository.delete(clase);
		} catch (Exception e) {
			if (e instanceof org.hibernate.exception.ConstraintViolationException
					|| e instanceof DataIntegrityViolationException) {
				throw new IllegalArgumentException(errorDelete);
			}
			throw e;
		}

	}

}
