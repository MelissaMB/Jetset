package com.sisvuelo.aplication.service;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sisvuelo.aplication.model.EstatusReserva;
import com.sisvuelo.aplication.repository.EstatusReservaRepository;
import com.sisvuelo.aplication.filter.EstatusReservaFilter;

@Service
public class EstatusReservaService {

	private String errorDelete = "this record is related to other tables.";

    @Autowired
	private EstatusReservaRepository estatusReservaRepository;

	@Transactional
	public void save(EstatusReserva estatusReserva) {
		estatusReservaRepository.save(estatusReserva);
	}
	
	public Page<EstatusReserva> filter(EstatusReservaFilter estatusReservaFilter, Pageable pageable) {
		return estatusReservaRepository.filtrar(estatusReservaFilter, pageable);
	}

	@Transactional
	public void delete(EstatusReserva estatusReserva) {
		try {
			estatusReservaRepository.delete(estatusReserva);
		} catch (Exception e) {
			if (e instanceof org.hibernate.exception.ConstraintViolationException
					|| e instanceof DataIntegrityViolationException) {
				throw new IllegalArgumentException(errorDelete);
			}
			throw e;
		}

	}

}
