package com.sisvuelo.aplication.service;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sisvuelo.aplication.model.Aeropuerto;
import com.sisvuelo.aplication.repository.AeropuertoRepository;
import com.sisvuelo.aplication.filter.AeropuertoFilter;

@Service
public class AeropuertoService {

	private String errorDelete = "this record is related to other tables.";

    @Autowired
	private AeropuertoRepository aeropuertoRepository;

	@Transactional
	public void save(Aeropuerto aeropuerto) {
		aeropuertoRepository.save(aeropuerto);
	}
	
	public Page<Aeropuerto> filter(AeropuertoFilter aeropuertoFilter, Pageable pageable) {
		return aeropuertoRepository.filtrar(aeropuertoFilter, pageable);
	}

	@Transactional
	public void delete(Aeropuerto aeropuerto) {
		try {
			aeropuertoRepository.delete(aeropuerto);
		} catch (Exception e) {
			if (e instanceof org.hibernate.exception.ConstraintViolationException
					|| e instanceof DataIntegrityViolationException) {
				throw new IllegalArgumentException(errorDelete);
			}
			throw e;
		}

	}

}
