package com.sisvuelo.aplication.service;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sisvuelo.aplication.model.Pais;
import com.sisvuelo.aplication.repository.PaisRepository;
import com.sisvuelo.aplication.filter.PaisFilter;

@Service
public class PaisService {

	private String errorDelete = "this record is related to other tables.";

    @Autowired
	private PaisRepository paisRepository;

	@Transactional
	public void save(Pais pais) {
		paisRepository.save(pais);
	}
	
	public Page<Pais> filter(PaisFilter paisFilter, Pageable pageable) {
		return paisRepository.filtrar(paisFilter, pageable);
	}

	@Transactional
	public void delete(Pais pais) {
		try {
			paisRepository.delete(pais);
		} catch (Exception e) {
			if (e instanceof org.hibernate.exception.ConstraintViolationException
					|| e instanceof DataIntegrityViolationException) {
				throw new IllegalArgumentException(errorDelete);
			}
			throw e;
		}

	}

}
