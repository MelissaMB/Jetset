package com.sisvuelo.aplication.repository.helper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sisvuelo.aplication.filter.CapacidadFilter;
import com.sisvuelo.aplication.model.Capacidad;



public interface CapacidadHelper {

	public Page<Capacidad> filtrar(CapacidadFilter capacidadFilter, Pageable pageable);

}
