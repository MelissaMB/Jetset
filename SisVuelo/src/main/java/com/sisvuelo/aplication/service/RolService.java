package com.sisvuelo.aplication.service;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sisvuelo.aplication.model.Rol;
import com.sisvuelo.aplication.repository.RolRepository;
import com.sisvuelo.aplication.filter.RolFilter;

@Service
public class RolService {

	private String errorDelete = "this record is related to other tables.";

    @Autowired
	private RolRepository rolRepository;

	@Transactional
	public void save(Rol rol) {
		rolRepository.save(rol);
	}
	
	public Page<Rol> filter(RolFilter rolFilter, Pageable pageable) {
		return rolRepository.filtrar(rolFilter, pageable);
	}

	@Transactional
	public void delete(Rol rol) {
		try {
			rolRepository.delete(rol);
		} catch (Exception e) {
			if (e instanceof org.hibernate.exception.ConstraintViolationException
					|| e instanceof DataIntegrityViolationException) {
				throw new IllegalArgumentException(errorDelete);
			}
			throw e;
		}

	}

}
