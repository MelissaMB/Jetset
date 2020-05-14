package com.sisvuelo.aplication.service;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sisvuelo.aplication.model.Modelo;
import com.sisvuelo.aplication.repository.ModeloRepository;
import com.sisvuelo.aplication.filter.ModeloFilter;

@Service
public class ModeloService {

	private String errorDelete = "this record is related to other tables.";

    @Autowired
	private ModeloRepository modeloRepository;

	@Transactional
	public void save(Modelo modelo) {
		modeloRepository.save(modelo);
	}
	
	public Page<Modelo> filter(ModeloFilter modeloFilter, Pageable pageable) {
		return modeloRepository.filtrar(modeloFilter, pageable);
	}

	@Transactional
	public void delete(Modelo modelo) {
		try {
			modeloRepository.delete(modelo);
		} catch (Exception e) {
			if (e instanceof org.hibernate.exception.ConstraintViolationException
					|| e instanceof DataIntegrityViolationException) {
				throw new IllegalArgumentException(errorDelete);
			}
			throw e;
		}

	}

}
