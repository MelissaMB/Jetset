package com.sisvuelo.aplication.service;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sisvuelo.aplication.model.Aerolinea;
import com.sisvuelo.aplication.repository.AerolineaRepository;
import com.sisvuelo.aplication.filter.AerolineaFilter;

@Service
public class AerolineaService {

	private String errorDelete = "this record is related to other tables.";

    @Autowired
	private AerolineaRepository aerolineaRepository;

	@Transactional
	public void save(Aerolinea aerolinea) {
		aerolineaRepository.save(aerolinea);
	}
	
	public Page<Aerolinea> filter(AerolineaFilter aerolineaFilter, Pageable pageable) {
		return aerolineaRepository.filtrar(aerolineaFilter, pageable);
	}

	@Transactional
	public void delete(Aerolinea aerolinea) {
		try {
			aerolineaRepository.delete(aerolinea);
		} catch (Exception e) {
			if (e instanceof org.hibernate.exception.ConstraintViolationException
					|| e instanceof DataIntegrityViolationException) {
				throw new IllegalArgumentException(errorDelete);
			}
			throw e;
		}

	}

}
