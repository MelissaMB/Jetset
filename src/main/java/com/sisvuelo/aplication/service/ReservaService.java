package com.sisvuelo.aplication.service;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sisvuelo.aplication.model.Reserva;
import com.sisvuelo.aplication.repository.ReservaRepository;
import com.sisvuelo.aplication.filter.ReservaFilter;

@Service
public class ReservaService {

	private String errorDelete = "this record is related to other tables.";

    @Autowired
	private ReservaRepository reservaRepository;

	@Transactional
	public void save(Reserva reserva) {
		reservaRepository.save(reserva);
	}
	
	public Page<Reserva> filter(ReservaFilter reservaFilter, Pageable pageable) {
		return reservaRepository.filtrar(reservaFilter, pageable);
	}

	@Transactional
	public void delete(Reserva reserva) {
		try {
			reservaRepository.delete(reserva);
		} catch (Exception e) {
			if (e instanceof org.hibernate.exception.ConstraintViolationException
					|| e instanceof DataIntegrityViolationException) {
				throw new IllegalArgumentException(errorDelete);
			}
			throw e;
		}

	}

}
