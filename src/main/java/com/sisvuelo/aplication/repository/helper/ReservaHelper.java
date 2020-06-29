package com.sisvuelo.aplication.repository.helper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sisvuelo.aplication.filter.ReservaFilter;
import com.sisvuelo.aplication.model.Reserva;



public interface ReservaHelper {

	public Page<Reserva> filtrar(ReservaFilter reservaFilter, Pageable pageable);

}
