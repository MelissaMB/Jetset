package com.sisvuelo.aplication.service;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sisvuelo.aplication.model.Precio;
import com.sisvuelo.aplication.repository.PrecioRepository;
import com.sisvuelo.aplication.filter.PrecioFilter;

@Service
public class PrecioService {

	private String errorDelete = "this record is related to other tables.";

    @Autowired
	private PrecioRepository precioRepository;

	@Transactional
	public void save(Precio precio) {
		precioRepository.save(precio);
	}
	
	public Page<Precio> filter(PrecioFilter precioFilter, Pageable pageable) {
		return precioRepository.filtrar(precioFilter, pageable);
	}

	@Transactional
	public void delete(Precio precio) {
		try {
			precioRepository.delete(precio);
		} catch (Exception e) {
			if (e instanceof org.hibernate.exception.ConstraintViolationException
					|| e instanceof DataIntegrityViolationException) {
				throw new IllegalArgumentException(errorDelete);
			}
			throw e;
		}

	}

}
