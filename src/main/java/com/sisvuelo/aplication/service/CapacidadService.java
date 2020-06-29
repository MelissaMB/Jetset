package com.sisvuelo.aplication.service;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sisvuelo.aplication.model.Capacidad;
import com.sisvuelo.aplication.repository.CapacidadRepository;
import com.sisvuelo.aplication.filter.CapacidadFilter;

@Service
public class CapacidadService {

	private String errorDelete = "this record is related to other tables.";

    @Autowired
	private CapacidadRepository capacidadRepository;

	@Transactional
	public void save(Capacidad capacidad) {
		capacidadRepository.save(capacidad);
	}
	
	public Page<Capacidad> filter(CapacidadFilter capacidadFilter, Pageable pageable) {
		return capacidadRepository.filtrar(capacidadFilter, pageable);
	}

	@Transactional
	public void delete(Capacidad capacidad) {
		try {
			capacidadRepository.delete(capacidad);
		} catch (Exception e) {
			if (e instanceof org.hibernate.exception.ConstraintViolationException
					|| e instanceof DataIntegrityViolationException) {
				throw new IllegalArgumentException(errorDelete);
			}
			throw e;
		}

	}

}
