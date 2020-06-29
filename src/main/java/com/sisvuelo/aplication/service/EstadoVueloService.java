package com.sisvuelo.aplication.service;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sisvuelo.aplication.model.EstadoVuelo;
import com.sisvuelo.aplication.repository.EstadoVueloRepository;
import com.sisvuelo.aplication.filter.EstadoVueloFilter;

@Service
public class EstadoVueloService {

	private String errorDelete = "this record is related to other tables.";

    @Autowired
	private EstadoVueloRepository estadoVueloRepository;

	@Transactional
	public void save(EstadoVuelo estadoVuelo) {
		estadoVueloRepository.save(estadoVuelo);
	}
	
	public Page<EstadoVuelo> filter(EstadoVueloFilter estadoVueloFilter, Pageable pageable) {
		return estadoVueloRepository.filtrar(estadoVueloFilter, pageable);
	}

	@Transactional
	public void delete(EstadoVuelo estadoVuelo) {
		try {
			estadoVueloRepository.delete(estadoVuelo);
		} catch (Exception e) {
			if (e instanceof org.hibernate.exception.ConstraintViolationException
					|| e instanceof DataIntegrityViolationException) {
				throw new IllegalArgumentException(errorDelete);
			}
			throw e;
		}

	}

}
