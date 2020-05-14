package com.sisvuelo.aplication.service;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sisvuelo.aplication.model.Vuelo;
import com.sisvuelo.aplication.repository.VueloRepository;
import com.sisvuelo.aplication.filter.VueloFilter;

@Service
public class VueloService {

	private String errorDelete = "this record is related to other tables.";

    @Autowired
	private VueloRepository vueloRepository;

	@Transactional
	public void save(Vuelo vuelo) {
		vueloRepository.save(vuelo);
	}
	
	public Page<Vuelo> filter(VueloFilter vueloFilter, Pageable pageable) {
		return vueloRepository.filtrar(vueloFilter, pageable);
	}

	@Transactional
	public void delete(Vuelo vuelo) {
		try {
			vueloRepository.delete(vuelo);
		} catch (Exception e) {
			if (e instanceof org.hibernate.exception.ConstraintViolationException
					|| e instanceof DataIntegrityViolationException) {
				throw new IllegalArgumentException(errorDelete);
			}
			throw e;
		}

	}

}
