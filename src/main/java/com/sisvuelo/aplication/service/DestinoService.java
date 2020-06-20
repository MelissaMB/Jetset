package com.sisvuelo.aplication.service;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sisvuelo.aplication.model.Destino;
import com.sisvuelo.aplication.repository.DestinoRepository;
import com.sisvuelo.aplication.filter.DestinoFilter;

@Service
public class DestinoService {

	private String errorDelete = "this record is related to other tables.";

    @Autowired
	private DestinoRepository destinoRepository;

	@Transactional
	public void save(Destino destino) {
		destinoRepository.save(destino);
	}
	
	public Page<Destino> filter(DestinoFilter destinoFilter, Pageable pageable) {
		return destinoRepository.filtrar(destinoFilter, pageable);
	}

	@Transactional
	public void delete(Destino destino) {
		try {
			destinoRepository.delete(destino);
		} catch (Exception e) {
			if (e instanceof org.hibernate.exception.ConstraintViolationException
					|| e instanceof DataIntegrityViolationException) {
				throw new IllegalArgumentException(errorDelete);
			}
			throw e;
		}

	}

}
